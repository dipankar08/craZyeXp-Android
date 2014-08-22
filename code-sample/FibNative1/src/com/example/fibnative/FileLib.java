/* generate header 
C:\Users\didutta\workspace\FibNative>javah -classpath bin/classes/ -d jni/ com.example.fibnative.FibLib
*/
package com.example.fibnative;

public class FileLib {
	     
		public native static byte[] getFileData();
		public native static void setFileData(byte[] n);		
		
		static{
			System.loadLibrary("allLib");
			System.loadLibrary("hxcomm");
		}
}
