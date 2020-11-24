import java.util.regex.Pattern;

public class Matcher {


    public static boolean matchingNumber(String splittedString) {
        String regExp = "-?\\d*\\.?\\d+";
        Pattern prtn = Pattern.compile(regExp);
        java.util.regex.Matcher matcher = prtn.matcher(splittedString);
        return matcher.matches();

    }

    public static boolean matchingSign(String splittedString) {
        String regExp = "[\\u002d\\u002b\\u002a\\u002f]?";
        Pattern prtn = Pattern.compile(regExp);
        java.util.regex.Matcher matcher = prtn.matcher(splittedString);
        return matcher.matches();

    }
}
