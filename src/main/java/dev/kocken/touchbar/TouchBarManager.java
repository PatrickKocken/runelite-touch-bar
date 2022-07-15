package dev.kocken.touchbar;

import dev.kocken.nativebridge.JavaTouchBar;
import dev.kocken.nativebridge.common.Image;
import dev.kocken.nativebridge.item.TouchBarItem;
import dev.kocken.nativebridge.item.view.TouchBarButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TouchBarManager {

    private static final int TAB_BUTTONS_COUNT = 7;

    private boolean isTopRowActive = true;

    private final JavaTouchBar touchBar;

    private final List<TouchBarButton> tabButtons = new ArrayList<>();
    private final List<TouchBarItem> tabItems = new ArrayList<>();

    private final Robot robot;


    private final Map<String, Integer> topRowButtonsConfiguration = new LinkedHashMap<String, Integer>() {{
        put("combat", KeyEvent.VK_F1);
        put("skills", KeyEvent.VK_F2);
        put("quests", KeyEvent.VK_F3);
        put("inventory", KeyEvent.VK_ESCAPE);
        put("equipment", KeyEvent.VK_F4);
        put("prayer", KeyEvent.VK_F5);
        put("spellbook", KeyEvent.VK_F6);
    }};

    private final Map<String, Integer> bottomRowButtonsConfiguration = new LinkedHashMap<String, Integer>() {{
        put("chat", KeyEvent.VK_F7);
        put("friends", KeyEvent.VK_F8);
        put("account", KeyEvent.VK_F9);
        put("logout", null);
        put("settings", KeyEvent.VK_F10);
        put("emotes", KeyEvent.VK_F11);
        put("music", KeyEvent.VK_F12);
    }};

    public TouchBarManager() throws AWTException {
        this.touchBar = new JavaTouchBar();
        this.robot = new Robot();
        InitializeTabButtons();
    }

    public void RenderTouchBar() {

        touchBar.setItems(tabItems);

        for (Frame frame : Frame.getFrames())
            touchBar.show(frame);
    }

    private void SwitchRows() {
        isTopRowActive = !isTopRowActive;
        SetTabButtons();
    }

    private void InitializeTabButtons() {

        for (int i = 0; i < TAB_BUTTONS_COUNT; i++) {
            tabButtons.add(new TouchBarButton());
            tabItems.add(new TouchBarItem(String.valueOf(i), tabButtons.get(i)));
        }

        TouchBarButton rowSwitchButton = new TouchBarButton();
        rowSwitchButton.setTitle("↕︎");
        rowSwitchButton.setAction(view -> SwitchRows());

        tabItems.add(new TouchBarItem("switch", rowSwitchButton));

        SetTabButtons();
    }


    private void SetTabButtons() {

        Map<String, Integer> configuration = isTopRowActive ? topRowButtonsConfiguration : bottomRowButtonsConfiguration;

        int index = 0;
        for (Map.Entry<String, Integer> entry : configuration.entrySet()) {
            String iconName = entry.getKey();
            Integer keyCode = entry.getValue();

            try {
                tabButtons.get(index).setImage(new Image(getClass().getClassLoader().getResourceAsStream(String.format("images/%s.png", iconName))));
            } catch (IOException e) {
                e.printStackTrace();
            }

            tabButtons.get(index).setAction(view -> {
                if (keyCode != null)
                    robot.keyPress(keyCode);
            });

            index += 1;
        }

        RenderTouchBar();
    }
}
