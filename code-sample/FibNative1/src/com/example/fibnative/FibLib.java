package com.example.fibnative;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Serializer {
    public static byte[] serialize(Object obj) throws IOException {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    	ObjectOutput out = null;
    	try {
    	  out = new ObjectOutputStream(bos);   
    	  out.writeObject(obj);
    	  byte[] yourBytes = bos.toByteArray();
    	  return yourBytes;
    	} finally {
    	  try {
    	    if (out != null) {
    	      out.close();
    	    }
    	  } catch (IOException ex) {
    	    // ignore close exception
    	  }
    	  try {
    	    bos.close();
    	  } catch (IOException ex) {
    	    // ignore close exception
    	  }
    	}
    }

    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
}


public class FibLib {
	  
	    private static final String TAG = "DD_JAVA";

		public static long fibJR(long n){
			return n<=0?0:n==1?1: fibJR(n-1)+fibJR(n-2);
		}
		public native static long fibNR(long n);
		
		public static long fibJI(long n){
			Log.d(TAG,"fibJI("+n+")");
			long f1 = 0;
			long f2 = 1;
			long fn;
			for(long i = 2;i<= n;i++){
				fn = f1 + f2;
				f1 = f2;
				f2 = fn;
			}
			return f2;
		}
		public native static long fibNI(long n);	
		
		public native static byte[] getFileData();
		public native static void setFileData(byte[] n);
		public native static byte[] abc(byte[] n);
		
		static{
			System.loadLibrary("allLib");
			//System.loadLibrary("com_example_fibnative_FileLib");
		}
}
