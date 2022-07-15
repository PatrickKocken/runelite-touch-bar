package dev.kocken;

import com.google.inject.Provides;
import dev.kocken.nativebridge.JavaTouchBar;
import dev.kocken.nativebridge.item.TouchBarItem;
import dev.kocken.nativebridge.item.view.TouchBarButton;
import dev.kocken.touchbar.TouchBarManager;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;
import java.awt.*;

@Slf4j
@PluginDescriptor(
        name = "Touch Bar Plugin"
)
public class TouchBarPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private TouchBarPluginConfig config;

    private TouchBarManager touchBarManager;

    @Override
    protected void startUp() throws Exception {
        log.info("Example started!");
        touchBarManager = new TouchBarManager();
    }

    @Override
    protected void shutDown() {
        log.info("Example stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
            touchBarManager.RenderTouchBar();
        }
    }

    @Provides
    TouchBarPluginConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(TouchBarPluginConfig.class);
    }
}
