package com.toin.work.base.utils;

import java.io.ByteArrayOutputStream;

/**
 * A class to encode/decode Base64 string/bytes. See RFC 1521 section 5.2 for
 * details of the Base64 algorithm. Replace Base64 encoder/decoder in
 * org.webmacro.util.Base64 and com.oreilly.servlet.util.Base64* because they
 * don't handle binary correctly (where 8-bit is set).
 */
public class Base64 {
    // map 6-bit int to char
    private static final char[] chars64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '+', '/'                   };

    // map char to 6-bit int
    private static final int[]  ints64  = new int[128];

    static {
        for (int i = 0; i < 64; i++) {
            ints64[chars64[i]] = i;
        }
    }

    public static final String encode(byte[] unencoded) {
        ByteArrayOutputStream out = new ByteArrayOutputStream((int) (unencoded.length * 1.37));
        int byteCount = 0;
        int carryOver = 0;

        for (int i = 0; i < unencoded.length; i++) {
            int bc = (byteCount % 3);
            byte b = unencoded[i];
            int lookup = 0;

            // First byte use first six bits, save last two bits
            if (bc == 0) {
                lookup = (b >> 2) & 0x3F;
                carryOver = b & 0x03; // last two bits
                out.write(chars64[lookup]);
            } else if (bc == 1) {
                // Second byte use previous two bits and first four new bits,
                // save last four bits
                lookup = ((carryOver << 4) | ((b >> 4) & 0x0F));
                carryOver = b & 0x0F; // last four bits
                out.write(chars64[lookup]);
            } else if (bc == 2) {
                // Third byte use previous four bits and first two new bits,
                // then use last six new bits
                lookup = ((carryOver << 2) | ((b >> 6) & 0x03));
                out.write(chars64[lookup]);

                lookup = b & 0x3F; // last six bits
                out.write(chars64[lookup]);
                carryOver = 0;
            }

            byteCount++;
        }

        if ((byteCount % 3) == 1) { // one leftover

            int lookup = (carryOver << 4) & 0xF0;
            out.write(chars64[lookup]);
            out.write('=');
            out.write('=');
        } else if ((byteCount % 3) == 2) { // two leftovers

            int lookup = (carryOver << 2) & 0x3C;
            out.write(chars64[lookup]);
            out.write('=');
        }

        return out.toString();
    }

    public static final byte[] decode(String encoded) {
        if (encoded == null || encoded.length() <= 0) {
            return null;
        }
        byte[] bytes = encoded.getBytes();

        ByteArrayOutputStream out = new ByteArrayOutputStream((int) (bytes.length * 0.67));
        int byteCount = 0;
        int carryOver = 0;

        DECODE_LOOP: for (int i = 0; i < bytes.length; i++) {
            int ch = bytes[i];

            if (ch == '=') {
                break DECODE_LOOP;
            }

            // Convert from raw form to 6-bit form
            int newbits = ints64[ch];

            int bc = (byteCount % 4);

            if (bc == 0) {
                // First char save all six bits, go for another
                carryOver = newbits & 0x3F;
            } else if (bc == 1) {
                // second char use 6 previous bits and first 2 new bits
                int data = ((carryOver << 2) + ((newbits >> 4) & 0x03));
                out.write(data);
                carryOver = newbits & 0x0F; // save 4 bits
            } else if (bc == 2) {
                // Third char use previous four bits and first four new bits,
                // save last two bits
                int data = ((carryOver << 4) + ((newbits >> 2) & 0x0F));
                out.write(data);
                carryOver = newbits & 0x03; // save 2 bits
            } else if (bc == 3) {
                // Fourth char use previous two bits and all six new bits
                int data = ((carryOver << 6) + (newbits & 0x3F));
                out.write(data);
                carryOver = 0;
            }

            byteCount++;
        }

        return out.toByteArray();
    }
}
