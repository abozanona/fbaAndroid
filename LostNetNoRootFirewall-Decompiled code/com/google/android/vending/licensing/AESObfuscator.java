package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESObfuscator implements Obfuscator {
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] IV = new byte[]{(byte) 16, (byte) 74, (byte) 71, (byte) -80, (byte) 32, (byte) 101, (byte) -47, (byte) 72, (byte) 117, (byte) -14, (byte) 0, (byte) -29, (byte) 70, (byte) 65, (byte) -12, (byte) 74};
    private static final String KEYGEN_ALGORITHM = "PBEWITHSHAAND256BITAES-CBC-BC";
    private static final String UTF8 = "UTF-8";
    private static final String header = "com.android.vending.licensing.AESObfuscator-1|";
    private Cipher mDecryptor;
    private Cipher mEncryptor;

    public AESObfuscator(byte[] bArr, String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance(KEYGEN_ALGORITHM).generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, Policy.LICENSED)).getEncoded(), "AES");
            this.mEncryptor = Cipher.getInstance(CIPHER_ALGORITHM);
            this.mEncryptor.init(1, secretKeySpec, new IvParameterSpec(IV));
            this.mDecryptor = Cipher.getInstance(CIPHER_ALGORITHM);
            this.mDecryptor.init(2, secretKeySpec, new IvParameterSpec(IV));
        } catch (Throwable e) {
            throw new RuntimeException("Invalid environment", e);
        }
    }

    public String obfuscate(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encode(this.mEncryptor.doFinal((header + str2 + str).getBytes(UTF8)));
        } catch (Throwable e) {
            throw new RuntimeException("Invalid environment", e);
        } catch (Throwable e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    public String unobfuscate(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            String str3 = new String(this.mDecryptor.doFinal(Base64.decode(str)), UTF8);
            if (str3.indexOf(header + str2) == 0) {
                return str3.substring(header.length() + str2.length(), str3.length());
            }
            throw new ValidationException("Header not found (invalid data or key):" + str);
        } catch (Base64DecoderException e) {
            throw new ValidationException(e.getMessage() + ":" + str);
        } catch (IllegalBlockSizeException e2) {
            throw new ValidationException(e2.getMessage() + ":" + str);
        } catch (BadPaddingException e3) {
            throw new ValidationException(e3.getMessage() + ":" + str);
        } catch (Throwable e4) {
            throw new RuntimeException("Invalid environment", e4);
        }
    }
}
