package dev.kocken.touchbar;

import dev.kocken.TouchBarPluginConfig;
import dev.kocken.nativebridge.JavaTouchBar;
import dev.kocken.nativebridge.common.Image;
import dev.kocken.nativebridge.item.TouchBarItem;
import dev.kocken.nativebridge.item.view.TouchBarButton;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TouchBarManager {

    private static final int TAB_BUTTONS_COUNT = 7;

    private final TouchBarConfiguration touchBarConfig;
    private final JavaTouchBar touchBar;
    private final Robot robot;

    private final List<TouchBarButton> tabButtons = new ArrayList<>();
    private final List<TouchBarItem> tabItems = new ArrayList<>();

    private TouchBarPluginConfig config;
    private boolean isTopRowActive = true;

    public TouchBarManager(TouchBarPluginConfig config) throws AWTException {
        this.touchBarConfig = new TouchBarConfiguration();
        this.touchBar = new JavaTouchBar();
        this.robot = new Robot();
        this.config = config;

        InitializeTabButtons();
        SetTabButtons();
    }

    /**
     * Method for re-setting TabItems and showing the TouchBar on all the Frames
     */
    public void ShowTouchBar() {
        touchBar.setItems(tabItems);

        for (Frame frame : Frame.getFrames())
            touchBar.show(frame);
    }

    /**
     * Method for hiding the TouchBar on all the Frames
     */
    public void HideTouchBar() {
        for (Frame frame : Frame.getFrames())
            touchBar.hide(frame);
    }

    /**
     * Method for switching which tab row is active and setting the new tab buttons
     */
    private void SwitchRows() {
        isTopRowActive = !isTopRowActive;
        SetTabButtons();
    }

    /**
     * Method for Initializing empty TouchBarButtons and adding them to a TouchBarItem
     */
    private void InitializeTabButtons() {
        for (int i = 0; i < TAB_BUTTONS_COUNT; i++) {
            tabButtons.add(new TouchBarButton());
            tabItems.add(new TouchBarItem(String.valueOf(i), tabButtons.get(i)));
        }

        tabItems.add(new TouchBarItem("switch", CreateSwitchRowButton()));
    }

    /**
     * Method for setting the variables of the existing TouchBarButton using a TouchBarConfiguration
     */
    private void SetTabButtons() {
        Map<String, Integer> configuration = isTopRowActive ? touchBarConfig.topRowButtonsConfiguration(config) : touchBarConfig.bottomRowButtonsConfiguration(config);

        int index = 0;
        for (Map.Entry<String, Integer> entry : configuration.entrySet()) {
            String imageName = entry.getKey();
            Integer keyCode = entry.getValue();

            tabButtons.get(index).setImage(loadButtonImage(imageName));
            tabButtons.get(index).setAction(view -> robot.keyPress(keyCode));
            index += 1;
        }
        ShowTouchBar();
    }

    /**
     * Loads the image for a TouchBarButton
     *
     * @param imageName the name of the png image in the resources/images directory
     * @return returns the TouchBar Button Image
     */
    private Image loadButtonImage(String imageName) {
        Image image = null;
        try {
            InputStream imageStream = getClass().getClassLoader().getResourceAsStream(String.format("images/%s.png", imageName));
            image = new Image(imageStream);
        } catch (IOException error) {
            error.printStackTrace();
        }
        return image;
    }

    /**
     * Method for creating a TouchBarButton that switches the active row
     *
     * @return returns TouchBarButton for switching the active row
     */
    private TouchBarButton CreateSwitchRowButton() {
        TouchBarButton switchRowButton = new TouchBarButton();
        switchRowButton.setTitle("??????");
        switchRowButton.setAction(view -> SwitchRows());

        return switchRowButton;
    }

    /**
     * Method for updating the plugin config, setting the TouchBarButtons and showing the updated TouchBar
     *
     * @param config the updated config
     */
    public void UpdatePluginConfig(TouchBarPluginConfig config) {
        this.config = config;
        SetTabButtons();
    }

}
