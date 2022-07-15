package dev.kocken.touchbar;

import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;
import java.util.Map;

public final class TouchBarConfiguration {

    private TouchBarConfiguration() {
        throw new UnsupportedOperationException();
    }

    public static Map<String, Integer> topRowButtonsConfiguration(){
        return new LinkedHashMap<String, Integer>() {{
            put("combat", KeyEvent.VK_F1);
            put("skills", KeyEvent.VK_F2);
            put("quests", KeyEvent.VK_F3);
            put("inventory", KeyEvent.VK_ESCAPE);
            put("equipment", KeyEvent.VK_F4);
            put("prayer", KeyEvent.VK_F5);
            put("spellbook", KeyEvent.VK_F6);
        }};
    }

    public static Map<String, Integer> bottomRowButtonsConfiguration(){
        return new LinkedHashMap<String, Integer>() {{
            put("chat", KeyEvent.VK_F7);
            put("friends", KeyEvent.VK_F8);
            put("account", KeyEvent.VK_F9);
            put("logout", null);
            put("settings", KeyEvent.VK_F10);
            put("emotes", KeyEvent.VK_F11);
            put("music", KeyEvent.VK_F12);
        }};
    }
}
