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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class JavaTouchBarJNI {

	static {
		try {
			System.loadLibrary("JavaTouchBar");
		}
		catch(UnsatisfiedLinkError e) {
			loadLibraryFromJar("/lib/libJavaTouchBar.dylib");
		}
	}

	public static native void setTouchBar0(long viewPointer, JavaTouchBar touchBar);

	public static native void updateTouchBarItem(long nativeInstancePointer);

	public static native void callObjectSelector(long nativeInstancePointer, String selector, boolean onMainThread);

	public static native int callIntObjectSelector(long nativeInstancePointer, String selector);

	public static native long getAWTViewPointer0(Component c);

	private static void loadLibraryFromJar(String path) throws UnsatisfiedLinkError {
		try (InputStream inputStream = JavaTouchBarJNI.class.getResourceAsStream(path)) {
			File tempLib = File.createTempFile(path, "");

		    byte[] buffer = new byte[1024];
		    int read;

		    try(FileOutputStream fileOutputStream = new FileOutputStream(tempLib)) {
			    	while(true) {
						assert inputStream != null;
						if ((read = inputStream.read(buffer)) == -1) break;
						fileOutputStream.write(buffer, 0, read);
			    	}
		    }

		    System.load(tempLib.getAbsolutePath());
		}
		catch(Exception e) {
			throw new UnsatisfiedLinkError("Unable to open "+ path +" from jar file.");
		}
	}
}
