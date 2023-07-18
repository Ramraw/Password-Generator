import java.util.Random;
import java.util.*;

 class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;':,.<>?";

    public static void main(String[] args) {
        int length = getPasswordLengthFromUser();
        boolean useLowercase = getChoiceFromUser("Use lowercase characters (y/n)? ");
        boolean useUppercase = getChoiceFromUser("Use uppercase characters (y/n)? ");
        boolean useDigits = getChoiceFromUser("Use digits (y/n)? ");
        boolean useSpecialChars = getChoiceFromUser("Use special characters (y/n)? ");

        String password = generatePassword(length, useLowercase, useUppercase, useDigits, useSpecialChars);
        System.out.println("Generated password: " + password);
    }

    private static int getPasswordLengthFromUser() {
        System.out.print("Enter the desired password length: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static boolean getChoiceFromUser(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase();
        return choice.equals("y") || choice.equals("yes");
    }

    private static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useDigits, boolean useSpecialChars) {
        String allowedChars = "";
        if (useLowercase) {
            allowedChars += LOWERCASE_CHARS;
        }
        if (useUppercase) {
            allowedChars += UPPERCASE_CHARS;
        }
        if (useDigits) {
            allowedChars += DIGITS;
        }
        if (useSpecialChars) {
            allowedChars += SPECIAL_CHARS;
        }

        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
