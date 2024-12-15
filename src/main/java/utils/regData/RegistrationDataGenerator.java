package utils.regData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RegistrationDataGenerator {

    public static String createUsername() {
        return new SimpleDateFormat("SSS").format(new Date()) + "User";
    }

    public static String createEmail() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "@abv.bg";
    }

    public static String createInvalidEmail() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date()) + "!";
    }

    public static String createPassword() {
        return new SimpleDateFormat("hhmmssSSS").format(new Date())
                + (char) ('A' + new Random().nextInt(26))
                + (char) ('0' + new Random().nextInt(10))
                + "@abv.bg";
    }

    public static String createPasswordFor() {
        return new SimpleDateFormat("mmssSSS").format(new Date()) + "_user";
    }
}