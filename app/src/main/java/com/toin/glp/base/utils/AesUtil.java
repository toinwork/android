package com.toin.glp.base.utils;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;






/**
 * 加密工具类
 * 
 * @author yuanzhen.zj
 */
public class AesUtil {
    private static final String SHA1PRNG = "SHA1PRNG";
    private static final String AES      = "AES";

    /**
     * 获取秘钥序列
     */
    public static byte[] getRawKey() {
        byte[] result = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom clientSecureRandom = SecureRandom.getInstance(SHA1PRNG, "Crypto");
            kgen.init(128, clientSecureRandom);
            SecretKey secKey = kgen.generateKey();
            result = secKey.getEncoded();
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * 客户端解密
     * 
     * @param cipherText
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String decodeClientText(byte[] rawKey, String cipherText)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decodeText(rawKey, cipherText);
    }

    public static String decodeClientText(byte[] rawKey, String cipherText, String charset)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return decodeText(rawKey, cipherText, charset);
    }

    /**
     * 客户端加密
     * 
     * @param text
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String encodeClientText(byte[] rawKey, String text) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException {
        return encodeText(rawKey, text);
    }

    public static String encodeClientText(byte[] rawKey, String text, String charset)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return encodeText(rawKey, text, charset);
    }

    /**
     * 解密文本
     * 
     * @param cipherText
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String decodeText(byte[] rawKey, String cipherText) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException {
        return decodeText(rawKey, cipherText, "UTF-8");
    }

    private static String decodeText(byte[] rawKey, String cipherText, String charset)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
        if (cipherText == null) {
            return null;
        }
        if ("".equals(cipherText)) {
            return "";
        }
        byte[] resultBytes = null;
        byte[] byteContent = Hex.hex2Bytes(cipherText);

        SecretKeySpec keySpec = new SecretKeySpec(rawKey, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        resultBytes = cipher.doFinal(byteContent);
        if (StringUtils.isBlank(charset)) {
            return new String(resultBytes);
        } else
            return new String(resultBytes, charset);
    }

    /**
     * 加密文本
     * 
     * @param text
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     */
    public static String encodeText(byte[] rawKey, String text) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException,
            NoSuchAlgorithmException, NoSuchPaddingException {
        return encodeText(rawKey, text, "UTF-8");
    }

    private static String encodeText(byte[] rawKey, String text, String charset)
            throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
        if (text == null) {
            return null;
        }
        if ("".equals(text)) {
            return "";
        }

        byte[] resultBytes = null;
        String result = null;
        byte[] byteContent = null;
        if (StringUtils.isBlank(charset)) {
            byteContent = text.getBytes();
        } else
            byteContent = text.getBytes(charset);

        SecretKeySpec keySpec = new SecretKeySpec(rawKey, AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        resultBytes = cipher.doFinal(byteContent);
        result = Hex.bytes2Hex(resultBytes);
        return result;
    }
}
