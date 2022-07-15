package dev.kocken;

import dev.kocken.touchbar.KeyBindings;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("touch-bar")
public interface TouchBarPluginConfig extends Config
{
	@ConfigItem(keyName = "combat", name = "Combat Option key", position = 1, description = "")
	default KeyBindings combat()
	{
		return KeyBindings.F1;
	}

	@ConfigItem(keyName = "skills", name = "Skills key", position = 2, description = "")
	default KeyBindings skills()
	{
		return KeyBindings.F2;
	}

	@ConfigItem(keyName = "quests", name = "Quest List key", position = 3, description = "")
	default KeyBindings quests()
	{
		return KeyBindings.F3;
	}

	@ConfigItem(keyName = "inventory", name = "Inventory key", position = 4, description = "")
	default KeyBindings inventory()
	{
		return KeyBindings.ESCAPE;
	}

	@ConfigItem(keyName = "equipment", name = "Worn Equipment key", position = 5, description = "")
	default KeyBindings equipment()
	{
		return KeyBindings.F4;
	}

	@ConfigItem(keyName = "prayer", name = "Prayer key", position = 6, description = "")
	default KeyBindings prayer()
	{
		return KeyBindings.F5;
	}

	@ConfigItem(keyName = "magic", name = "Magic key", position = 7, description = "")
	default KeyBindings magic()
	{
		return KeyBindings.F6;
	}

	@ConfigItem(keyName = "chat", name = "Chat-channel key", position = 8, description = "")
	default KeyBindings chat()
	{
		return KeyBindings.F7;
	}

	@ConfigItem(keyName = "friends", name = "Friends List key", position = 9, description = "")
	default KeyBindings friends()
	{
		return KeyBindings.F8;
	}

	@ConfigItem(keyName = "account", name = "Account Management key", position = 10, description = "")
	default KeyBindings account()
	{
		return KeyBindings.F9;
	}

	@ConfigItem(keyName = "logout", name = "Logout key", position = 11, description = "")
	default KeyBindings logout()
	{
		return KeyBindings.NONE;
	}

	@ConfigItem(keyName = "settings", name = "Settings key", position = 12, description = "")
	default KeyBindings settings()
	{
		return KeyBindings.F10;
	}

	@ConfigItem(keyName = "emotes", name = "Emotes key", position = 13, description = "")
	default KeyBindings emotes()
	{
		return KeyBindings.F11;
	}

	@ConfigItem(keyName = "music", name = "Music Player key", position = 14, description = "")
	default KeyBindings music()
	{
		return KeyBindings.F12;
	}

}
