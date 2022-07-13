/**
 * JTouchBar
 *
 * Copyright (c) 2018 - 2019 thizzer.com
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 *
 * @author  	M. ten Veldhuis
 */
package dev.kocken.nativebridge;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import dev.kocken.nativebridge.awt.AWTUtils;
import dev.kocken.nativebridge.item.TouchBarItem;

public class JavaTouchBar {

	private String _customizationIdentifier;
	private String _principalItemIdentifier;

	private List<TouchBarItem> _items;

	public String getCustomizationIdentifier() {
		return _customizationIdentifier;
	}

	public void setCustomizationIdentifier( String customizationIdentifier ) {
		_customizationIdentifier = customizationIdentifier;
	}

	public String getPrincipalItemIdentifier() {
		return _principalItemIdentifier;
	}

	public void setPrincipalItemIdentifier( String principalItemIdentifier ) {
		_principalItemIdentifier = principalItemIdentifier;
	}

	public List<TouchBarItem> getItems() {
		if(_items == null) { _items = new ArrayList<>(); }
		return _items;
	}

	public void setItems( List<TouchBarItem> items ) {
		_items = items;
	}

	public void addItem(TouchBarItem touchBarItem) {
		getItems().add(touchBarItem);
	}

	public void show(Component c) {
		long viewPointer = AWTUtils.getViewPointer(c);
		JavaTouchBarJNI.setTouchBar0(viewPointer, this);
	}

	public void show(long window) {
		JavaTouchBarJNI.setTouchBar0(window, this);
	}

	public void hide(Component c) {
		if(c == null) {
			return;
		}
		long viewPointer = AWTUtils.getViewPointer(c);
		JavaTouchBarJNI.setTouchBar0(viewPointer, null);
	}

	public void hide(long window) {
		JavaTouchBarJNI.setTouchBar0(window, null);
	}
}
