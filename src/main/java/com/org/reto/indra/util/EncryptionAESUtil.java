package com.org.reto.indra.util;


import com.org.reto.indra.constants.ConstantsUtil;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncryptionAESUtil {

    public static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ConstantsUtil.AES);
        keyGen.init(ConstantsUtil.AES_KEY_SIZE);
        return keyGen.generateKey();
    }

    public static SecretKey getAESKey() {
        byte[] decodedKey = Base64.getDecoder().decode(ConstantsUtil.AES_KEY_BASE64);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, ConstantsUtil.AES);
    }


    public static String encryptAES(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ConstantsUtil.AES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decryptAES(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ConstantsUtil.AES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
