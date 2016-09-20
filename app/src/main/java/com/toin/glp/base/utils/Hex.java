package com.toin.glp.base.utils;

/**
 * 进行不同进制字符的相互转换
 */
public class Hex {
    /**
     * 字符转换成16进制
     * 
     * @param bytes
     * @return
     */
    public static String bytes2Hex(byte[] bytes) {
        if (bytes == null)
            return null;
        StringBuilder result = new StringBuilder();
        String tmp = "";
        for (int n = 0; n < bytes.length; n++) {
            tmp = (java.lang.Integer.toHexString(bytes[n] & 0XFF));
            if (tmp.length() == 1)
                result.append("0").append(tmp);
            else
                result.append(tmp);
        }
        return result.toString().toUpperCase();
    }

    /**
     * 16进制转换成字符
     * 
     * @param hexStr
     * @return
     */
    public static byte[] hex2Bytes(String hexStr) {
        byte[] b = hexStr.getBytes();
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException("length need to be even");
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
}
