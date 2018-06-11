package com.pofy.chqty.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * function - MD5工具类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-06-11
 **/
public class Md5Utils {

    private final static String[] STRDIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String encrypt32(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    public static String encrypt32Up(String strObj) {
        return encrypt32(strObj).toUpperCase();
    }

    public static String encrypt16(String strObj) {
        return encrypt32(strObj).substring(8, 24);
    }

    public static String encrypt16Up(String strObj) {
        return encrypt32Up(strObj).substring(8, 24);
    }


    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return STRDIGITS[iD1] + STRDIGITS[iD2];
    }

}