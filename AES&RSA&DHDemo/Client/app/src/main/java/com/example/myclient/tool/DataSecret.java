package com.example.myclient.tool;

//import org.apache.commons.codec.binary.Base64;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class DataSecret {


    public static byte[] encode(byte[] txt) throws UnsupportedEncodingException {

        return Base64.encode(txt, Base64.DEFAULT | Base64.NO_WRAP);
    }

    public static byte[] decode(String txt){

        return Base64.decode(txt, Base64.DEFAULT | Base64.NO_WRAP);
    }

    public static byte[] int2Byte(int data){

        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        byteBuffer.putInt(data);
        return byteBuffer.array();
    }

    public static int byte2Int(byte[] data){

        ByteBuffer byteBuffer = ByteBuffer.wrap(data);
        return byteBuffer.getInt();
    }
}
