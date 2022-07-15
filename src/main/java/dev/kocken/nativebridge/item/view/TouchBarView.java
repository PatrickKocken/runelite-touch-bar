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
package dev.kocken.nativebridge.item.view;

import dev.kocken.nativebridge.NativeLinkObject;

public abstract class TouchBarView extends NativeLinkObject {

	void update() {
		setChanged();
		notifyObservers();
	}
}
