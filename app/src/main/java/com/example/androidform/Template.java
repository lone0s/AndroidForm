package com.example.androidform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public abstract class Template extends AppCompatActivity {
    private final String LOGGER_TAG;
    private final int layoutId;

    protected DataContainer data;

    public Template(int id) {
        this.layoutId = id;
        this.LOGGER_TAG = "Template->" + this.getClass().getSimpleName();
    }

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        Log.i(this.LOGGER_TAG, "Running onCreate");
        super.onCreate(savedInstanceState);
        this.setContentView(layoutId);

        Log.i(this.LOGGER_TAG, "Retrieving DataContainer from Parcel");
        this.data = this.getIntent().getParcelableExtra("scores");
        assert data != null;

        Log.i(this.LOGGER_TAG, "Running onCreateHook");
        this.onCreateHook(savedInstanceState);

        Log.i(this.LOGGER_TAG, "Binding [Next] and [Before] buttons");
        this.findViewById(R.id.beforeButton).setOnClickListener(this::backButtonEventListener);
        this.findViewById(R.id.nextButton).setOnClickListener(this::nextButtonEventListener);
    }

    /**
     * Returns whether or not the user is allowed to get to the next activity
     * */
    protected abstract boolean canClickNextButton();

    /**
     * @return the text to display as a Toast when the "Next" button is pressed and the form isn't valid
     */
    @NonNull
    protected abstract CharSequence onInvalidFormToastText();

    private void backButtonEventListener(View evt)
    {
        Log.d(this.LOGGER_TAG, "[Back buttom] clicked");
        this.backButtonAction(evt);
    }

    private void nextButtonEventListener(View evt)
    {
        Log.d(this.LOGGER_TAG, "[Next button] clicked");

        if(!this.canClickNextButton())
        {
            Log.i(this.LOGGER_TAG, "Form " + this.getClass().getSimpleName() + " hasn't been fully completed.");

            Context context = this.getApplicationContext();
            CharSequence text = this.onInvalidFormToastText();
            int duration = Toast.LENGTH_SHORT;

            Log.i(this.LOGGER_TAG, "Sending toast");
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            Log.i(this.LOGGER_TAG, "Toast sent");

            return;
        }

        this.nextButtonAction(evt);
    }

    protected final void startActivity(Template self, Class<? extends Template> targetActivity)
    {
        Log.i(this.LOGGER_TAG, "Creating intent for next activity");
        Intent intent = new Intent(self, targetActivity);
        intent.putExtra("scores", (Parcelable) this.data);


        Log.i(this.LOGGER_TAG, "Starting next activity");
        this.startActivity(intent);
    }

    protected void onCreateHook(Bundle savedInstanceState)
    {

    }

    /**
     * Action to be performed when clicking the "Previous" button
     * */
    protected void backButtonAction(View evt)
    {
        this.finish();
    }
    /**
     * Action to be performed when clicking the "Next" button
     * */
    protected abstract void nextButtonAction(View evt);
}