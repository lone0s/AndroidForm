package com.example.androidform.core;

public enum Language
{
    Rust,
    Haskell,
    Caml,
    Malboge,
    CPP,
    Python,
    R,
    JS,
    PHP,
    Java,
    CS;

    public static Language fromInt(int i) {
        assert i >= 0;
        assert i <= 10;

        switch (i)
        {
            case 0 : return Rust;
            case 1 : return Haskell;
            case 2 : return Caml;
            case 3 : return Malboge;
            case 4 : return CPP;
            case 5 : return Python;
            case 6 : return R;
            case 7 : return JS;
            case 8 : return PHP;
            case 9 : return Java;
            case 10 : return CS;
        }

        return null;
    }

    public int toInt()
    {
        return Language.toInt(this);
    }

    public static int toInt(Language l)
    {
        switch (l)
        {
            case Rust : return 0;
            case Haskell: return 1;
            case Caml: return 2;
            case Malboge: return 3;
            case CPP : return 4;
            case Python : return 5;
            case R : return 6;
            case JS : return 7;
            case PHP : return 8;
            case Java : return 9;
            case CS : return 10;
        }

        return -1;
    }
}
