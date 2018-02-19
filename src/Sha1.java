import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Sha1 {
    public static MessageDigest getInstance(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hash(String data) {
        MessageDigest md = getInstance("SHA-1");
        return DatatypeConverter.printHexBinary(md.digest(data.getBytes())).toLowerCase();
    }
}
