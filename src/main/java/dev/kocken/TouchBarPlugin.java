package dev.kocken;

import com.google.inject.Provides;
import dev.kocken.nativebridge.JavaTouchBar;
import dev.kocken.nativebridge.common.Image;
import dev.kocken.nativebridge.item.TouchBarItem;
import dev.kocken.nativebridge.item.view.TouchBarButton;
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
import java.io.IOException;

@Slf4j
@PluginDescriptor(
        name = "Touch Bar Plugin"
)
public class TouchBarPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private TouchBarPluginConfig config;

    @Override
    protected void startUp() throws Exception {
        log.info("Example started!");
    }

    @Override
    protected void shutDown() throws Exception {
        log.info("Example stopped!");
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged gameStateChanged) throws IOException {
        if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {

            Frame[] frames = Frame.getFrames();
            JavaTouchBar touchBar = new JavaTouchBar();

            Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/inventory.png"));

            TouchBarButton button = new TouchBarButton();
            button.setImage(image);
            button.setAction(view -> log.info("Clicked"));

            touchBar.addItem(new TouchBarItem("Button_0", button, true));

            for (Frame f : frames) {
                touchBar.show(f);
            }
        }
    }

    @Provides
    TouchBarPluginConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(TouchBarPluginConfig.class);
    }
}
