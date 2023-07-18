package dev.kocken.touchbar;

import dev.kocken.TouchBarPluginConfig;

public enum Tabs {
    CHAT("chat"),
    FRIENDS("friends"),
    ACCOUNT("account"),
    LOGOUT("logout"),
    SETTINGS("settings"),
    EMOTES("emotes"),
    MUSIC("music"),
    COMBAT("combat"),
    SKILLS("skills"),
    QUESTS("quests"),
    INVENTORY("inventory"),
    EQUIPMENT("equipment"),
    PRAYER("prayer"),
    MAGIC("spellbook");

    public final String imageName;

    Tabs(final String imageName) {
        this.imageName = imageName;
    }

    int getOrderUsingConfig(TouchBarPluginConfig config) {
        switch (this) {
            case CHAT:
                return config.chatOrder();
            case FRIENDS:
                return config.friendsOrder();
            case ACCOUNT:
                return config.accountOrder();
            case LOGOUT:
                return config.logoutOrder();
            case SETTINGS:
                return config.settingsOrder();
            case EMOTES:
                return config.emotesOrder();
            case MUSIC:
                return config.musicOrder();
            case COMBAT:
                return config.combatOrder();
            case SKILLS:
                return config.skillsOrder();
            case QUESTS:
                return config.questsOrder();
            case INVENTORY:
                return config.inventoryOrder();
            case EQUIPMENT:
                return config.equipmentOrder();
            case PRAYER:
                return config.prayerOrder();
            case MAGIC:
                return config.magicOrder();
            default:
                return -1;
        }
    }

    KeyBindings getKeyBindingUsingConfig(TouchBarPluginConfig config) {
        switch (this) {
            case CHAT:
                return config.chat();
            case FRIENDS:
                return config.friends();
            case ACCOUNT:
                return config.account();
            case LOGOUT:
                return config.logout();
            case SETTINGS:
                return config.settings();
            case EMOTES:
                return config.emotes();
            case MUSIC:
                return config.music();
            case COMBAT:
                return config.combat();
            case SKILLS:
                return config.skills();
            case QUESTS:
                return config.quests();
            case INVENTORY:
                return config.inventory();
            case EQUIPMENT:
                return config.equipment();
            case PRAYER:
                return config.prayer();
            case MAGIC:
                return config.magic();
            default:
                return KeyBindings.NONE;
        }
    }
}
