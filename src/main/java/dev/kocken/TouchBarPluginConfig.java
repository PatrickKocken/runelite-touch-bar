package dev.kocken;

import dev.kocken.touchbar.KeyBindings;
import net.runelite.client.config.*;

@ConfigGroup("touch-bar")
public interface TouchBarPluginConfig extends Config {
    int TOOLBAR_ORDER_MIN = 0;
    int TOOLBAR_ORDER_MAX = 13;
    
    String KEYBINDING_NAME = "Key binding";
    String ORDER_NAME = "Touchbar order";
    String TOOLBAR_POSITION_DESCRIPTION = "The order in which this tab appears in the touchbar. (" + TOOLBAR_ORDER_MIN + "-" + TOOLBAR_ORDER_MAX + ")";
    String OPTION_KEY_DESCRIPTION = "The shortcut which opens this tab. This must match the Runescape keybindings.";

    int GROUP_POSITION_KEY_BINDING = 0;
    int GROUP_POSITION_ORDER = 1;

    @ConfigSection(name = "Combat Options", description = "Combat tab", position = 0)
    String combatSection = "Combat Options";

    @ConfigItem(keyName = "combat", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = combatSection, position=GROUP_POSITION_KEY_BINDING)
    default KeyBindings combat() {
        return KeyBindings.F1;
    }

    @ConfigItem(keyName = "combatOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = combatSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int combatOrder() {
        return 0;
    }

    @ConfigSection(name = "Skills", description = "Skills tab", position = 1)
    String skillsSection = "Skills";

    @ConfigItem(keyName = "skills", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = skillsSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings skills() {
        return KeyBindings.F2;
    }

    @ConfigItem(keyName = "skillsOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = skillsSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int skillsOrder() {
        return 1;
    }

    @ConfigSection(name = "Quest List", description = "Quest List", position = 2)
    String questsSection = "Quest List";

    @ConfigItem(keyName = "quests", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = questsSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings quests() {
        return KeyBindings.F3;
    }

    @ConfigItem(keyName = "questsOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = questsSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int questsOrder() {
        return 2;
    }

    @ConfigSection(name = "Inventory", description = "Inventory tab", position = 3)
    String inventorySection = "Inventory";

    @ConfigItem(keyName = "inventory", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = inventorySection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings inventory() {
        return KeyBindings.ESCAPE;
    }

    @ConfigItem(keyName = "inventoryOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = inventorySection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int inventoryOrder() {
        return 3;
    }

    @ConfigSection(name = "Worn Equipment", description = "Worn Equipment tab", position = 4)
    String equipmentSection = "Worn Equipment";

    @ConfigItem(keyName = "equipment", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = equipmentSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings equipment() {
        return KeyBindings.F4;
    }

    @ConfigItem(keyName = "equipmentOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = equipmentSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int equipmentOrder() {
        return 4;
    }

    @ConfigSection(name = "Prayer", description = "Prayer tab", position = 5)
    String prayerSection = "Prayer";

    @ConfigItem(keyName = "prayer", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = prayerSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings prayer() {
        return KeyBindings.F5;
    }

    @ConfigItem(keyName = "prayerOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = prayerSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int prayerOrder() {
        return 5;
    }

    @ConfigSection(name = "Magic", description = "Magic tab", position = 6)
    String magicSection = "Magic";

    @ConfigItem(keyName = "magic", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = magicSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings magic() {
        return KeyBindings.F6;
    }

    @ConfigItem(keyName = "magicOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = magicSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int magicOrder() {
        return 6;
    }

    @ConfigSection(name = "Chat-channel", description = "Chat-channel tab", position = 7)
    String chatSection = "Chat-channel";

    @ConfigItem(keyName = "chat", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = chatSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings chat() {
        return KeyBindings.F7;
    }

    @ConfigItem(keyName = "chatOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = chatSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int chatOrder() {
        return 7;
    }

    @ConfigSection(name = "Friends List", description = "Friends List tab", position = 8)
    String friendsSection = "Friends List";

    @ConfigItem(keyName = "friends", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = friendsSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings friends() {
        return KeyBindings.F8;
    }

    @ConfigItem(keyName = "friendsOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = friendsSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int friendsOrder() {
        return 8;
    }

    @ConfigSection(name = "Account Management", description = "Account Management tab", position = 9)
    String accountSection = "Account Management";

    @ConfigItem(keyName = "account", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = accountSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings account() {
        return KeyBindings.F9;
    }

    @ConfigItem(keyName = "accountOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = accountSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int accountOrder() {
        return 9;
    }

    @ConfigSection(name = "Logout", description = "Logout tab", position = 10)
    String logoutSection = "Logout";

    @ConfigItem(keyName = "logout", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = logoutSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings logout() {
        return KeyBindings.NONE;
    }

    @ConfigItem(keyName = "logoutOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = logoutSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int logoutOrder() {
        return 10;
    }

    @ConfigSection(name = "Settings", description = "Settings tab", position = 11)
    String settingsSection = "Settings";

    @ConfigItem(keyName = "settings", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = settingsSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings settings() {
        return KeyBindings.F10;
    }

    @ConfigItem(keyName = "settingsOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = settingsSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int settingsOrder() {
        return 11;
    }

    @ConfigSection(name = "Emotes", description = "Emotes tab", position = 12)
    String emotesSection = "Emotes";

    @ConfigItem(keyName = "emotes", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = emotesSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings emotes() {
        return KeyBindings.F11;
    }

    @ConfigItem(keyName = "emotesOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = emotesSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int emotesOrder() {
        return 12;
    }

    @ConfigSection(name = "Music Player", description = "Music Player tab", position = 13)
    String musicSection = "Music Player";

    @ConfigItem(keyName = "music", name = KEYBINDING_NAME, description = OPTION_KEY_DESCRIPTION, section = musicSection, position = GROUP_POSITION_KEY_BINDING)
    default KeyBindings music() {
        return KeyBindings.F12;
    }

    @ConfigItem(keyName = "musicOrder", name = ORDER_NAME, description = TOOLBAR_POSITION_DESCRIPTION, section = musicSection, position = GROUP_POSITION_ORDER)
    @Range(max = TOOLBAR_ORDER_MAX)
    default int musicOrder() {
        return 13;
    }
}
