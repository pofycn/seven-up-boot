package com.pofy.chqty.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JCERSAPrivateKey;
import org.bouncycastle.jce.provider.JCERSAPublicKey;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;


/**
 * function - RSA加密解密工具类
 *
 * @author POFY
 * @version 1.0
 * @date 2018-05-27
 */
public class RSAUtils {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RSAUtils.class);

    private static KeyPair KEY_PAIR = null;

    /**
     * 加密的大小
     */
    private static int KEY_SIZE = 1024;

    private static BouncyCastleProvider bouncyCastleProvider = new BouncyCastleProvider();

    /**
     * function - 生成密钥对
     *
     * @return java.security.KeyPair
     * @author chenn001
     * @date 2018/05/25
     */
    public static KeyPair generateKeyPair() throws Exception {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA", bouncyCastleProvider);
            keyPairGen.initialize(KEY_SIZE, new SecureRandom());
            KeyPair keyPair = keyPairGen.generateKeyPair();
            KEY_PAIR = keyPair;
            return keyPair;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * function - 用私钥对数据进行加密
     *
     * @param data - 待加密的明文数据
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String encryptPrivate(String data) throws Exception {
        return encrypt(KEY_PAIR.getPrivate(), data);
    }

    /**
     * function - 用私钥对数据进行解密
     *
     * @param data - 加密数据
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String decryptPrivate(String data) throws Exception {
        return decrypt(KEY_PAIR.getPrivate(), data);
    }

    /**
     * function - 用私钥对数据加密
     *
     * @param pk - 私钥
     *           data - 待加密的明文数据
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    private static String encrypt(Key pk, String data) throws Exception {
        String encodeStr = URLEncoder.encode(data, "UTF-8");
        String encodeStr2 = encodeStr.replace("+", "%20");
        byte[] b1 = encodeStr2.getBytes();
        byte[] b2 = encrypt(pk, b1);
        String encryptedString = byteToString(b2);
        LOGGER.info("加密后数据:{}", encryptedString);
        return encryptedString;
    }

    /**
     * function - 用密钥对数据进行解密
     *
     * @param pk - 密钥
     *           data - 加密数据
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    private static String decrypt(Key pk, String data) throws Exception {
        byte[] b1 = hexStringToBytes(data);
        byte[] b2 = decrypt(pk, b1);
        String decryptedString = new String(b2);
        String reverseDecryptedString = new StringBuffer(decryptedString).reverse().toString();
        return URLDecoder.decode(reverseDecryptedString, "UTF-8");
    }

    /**
     * function - 返回公钥指数e
     *
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String getPublicExponent() {
        BigInteger b = ((JCERSAPublicKey) KEY_PAIR.getPublic()).getPublicExponent();
        return b.toString(16);
    }

    /**
     * function - 返回公钥模值n
     *
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String getModulus() {

        BigInteger b = ((JCERSAPublicKey) KEY_PAIR.getPublic()).getModulus();
        return b.toString(16);
    }

    /**
     * function - 返回私钥指数d
     *
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String getPrivateExponent() {
        BigInteger b = ((JCERSAPrivateKey) KEY_PAIR.getPrivate()).getPrivateExponent();
        return b.toString(16);
    }

    /**
     * function - 使用密钥对数据进行机密
     *
     * @param pk - 公钥或者私钥
     *           data - 待加密的明文数据
     * @return byte[] 加密后的数据
     * @author chenn001
     * @date 2018/05/25
     */
    private static byte[] encrypt(Key pk, byte[] data) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA", bouncyCastleProvider);
            cipher.init(Cipher.ENCRYPT_MODE, pk);
            // 获得加密块大小，如:加密前数据为128个byte，而key_size=1024
            int blockSize = cipher.getBlockSize();
            // 加密块大小为127
            // byte,加密后为128个byte;因此共有2个加密块，第一个127
            // byte第二个为1个byte
            // 获得加密块加密后块大小
            int outputSize = cipher.getOutputSize(data.length);
            int leavedSize = data.length % blockSize;
            int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
            byte[] raw = new byte[outputSize * blocksSize];
            int i = 0;
            while (data.length - i * blockSize > 0) {
                if (data.length - i * blockSize > blockSize) {
                    cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
                } else {
                    cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
                }
                // 这里doUpdate方法不可用，doUpdate后并没有什么实际动作除了把byte[]放到ByteArrayOutputStream中
                // ，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了OutputSize
                // 所以只能用dofinal方法。
                i++;
            }
            return raw;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 解密
     *
     * @param pk  解密的密钥 (也可以是公钥)
     * @param raw 已经加密的数据
     * @return 解密后的明文
     */
    private static byte[] decrypt(Key pk, byte[] raw) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA", bouncyCastleProvider);
            cipher.init(Cipher.DECRYPT_MODE, pk);
            int blockSize = cipher.getBlockSize();
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
            int j = 0;
            while (raw.length - j * blockSize > 0) {
                bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
                j++;
            }
            return bout.toByteArray();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || "".equals(hexString)) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte * @param c char * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * 把byte数组变换为16進数的字符串。
     *
     * @param bytes byte数组
     * @return 16進数的字符串
     */
    private static String byteToString(byte[] bytes) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            int d = bytes[i];
            if (d < 0) {
                d += 256;
            }
            if (d < 16) {
                buf.append("0");
            }
            buf.append(Integer.toString(d, 16));
        }
        return buf.toString();
    }

    /**
     * function - 用公钥加密
     *
     * @param data - 待加密的明文数据
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String encryptPublic(String data) throws Exception {

        return encrypt(KEY_PAIR.getPublic(), data);
    }

    /**
     * function - 用公钥解密
     *
     * @param data - 待解密的加密数据
     * @return java.lang.String
     * @author chenn001
     * @date 2018/05/25
     */
    public static String decryptPublic(String data) throws Exception {
        return decrypt(KEY_PAIR.getPublic(), data);
    }

}