package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {

    public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException {

        MessageDigest ms = MessageDigest.getInstance("MD5");
        ms.update(plainPassword.getBytes());

        byte[] encrypt = ms.digest();

        StringBuilder sb = new StringBuilder();

        for (byte b : encrypt) {
            sb.append(b);
        }

        return sb.toString();
    }
}
