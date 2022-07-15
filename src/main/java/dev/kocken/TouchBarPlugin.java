package dev.kocken;

import com.google.inject.Provides;
import dev.kocken.touchbar.TouchBarManager;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
        name = "Touch Bar Plugin"
)
public class TouchBarPlugin extends Plugin {

    @Inject
    private TouchBarPluginConfig config;

    private TouchBarManager touchBarManager;

    @Override
    protected void startUp() throws Exception {
        touchBarManager = new TouchBarManager();
        log.info("Touch Bar Plugin started!");
    }

    @Override
    protected void shutDown() {
        log.info("Touch Bar Plugin stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        GameState state = gameStateChanged.getGameState();

        if (state == GameState.LOGGED_IN)
            touchBarManager.ShowTouchBar();

        if (state == GameState.LOGIN_SCREEN)
            touchBarManager.HideTouchBar();
    }

    @Provides
    TouchBarPluginConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(TouchBarPluginConfig.class);
    }
}
