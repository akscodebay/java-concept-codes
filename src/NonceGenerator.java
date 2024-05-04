import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class NonceGenerator {

    public static String createNonce() {
        String nonce = "";

        try {
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
            String randomNum = String.valueOf(prng.nextInt());

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] result = sha.digest(randomNum.getBytes());
            nonce = Base64.getEncoder().
                    encodeToString(result);
        } catch (Exception e) {
        }

        return nonce;
    }

    public static void main(String[] args) {
        System.out.println(createNonce());

    }

} 