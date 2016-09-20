package com.toin.glp.base.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by hb on 16/9/16.
 */
public class SHA256 {

    /**
     * test tvMD5.setText(encryptPassword(textToGetTheHashesFor, "MD5"));
     * tvSHA1.setText(encryptPassword(textToGetTheHashesFor, "SHA-1"));
     * tvSHA256.setText(encryptPassword(textToGetTheHashesFor, "SHA-256"));
     * tvSHA512.setText(encryptPassword(textToGetTheHashesFor, "SHA-512"));
     * 
     * @param password
     * @param hashingFormat
     * @return
     */
    public static String encryptPassword(String password, String hashingFormat) {
        String hashedValue = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance(hashingFormat);
            System.out.print(hashingFormat + " (" + Integer.toString(crypt.getDigestLength() * 8)
                    + ") bits" + "\t" + " : ");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            hashedValue = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hashedValue;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
