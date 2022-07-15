package dev.kocken.touchbar;

public enum KeyBindings {
    F1(112),
    F2(113),
    F3(114),
    F4(115),
    F5(116),
    F6(117),
    F7(118),
    F8(119),
    F9(120),
    F10(121),
    F11(122),
    F12(123),
    ESCAPE(27),
    NONE(-1);

    private final int keyCode;

    KeyBindings(Integer keyCode)
    {
        this.keyCode = keyCode;
    }

    public int getKeyCode()
    {
        return keyCode;
    }
}
