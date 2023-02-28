package application;

import java.util.regex.Pattern;

public class InputChecker {
    public String BirthdayCheck( String date ) {
        String regex1 = "^[0-2][0-9]-[0][0-9]-(?:[0-2][0-9])?[0-9][0-9]$";
        String regex2 = "^[0-2][0-9]-[1][0-2]-(?:[0-2][0-9])?[0-9][0-9]$";
        String regex3 = "^[3][0-1]-[0-1][0-9]-(?:[0-2][0-9])?[0-9][0-9]$";
        String regex4 = "^[3][0-1]-[0-1][0-9]-(?:[0-2][0-9])?[0-9][0-9]$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        Pattern pattern4 = Pattern.compile(regex4);

        if (pattern1.matcher(date).matches()) {
            return date;
        }
        if (pattern2.matcher(date).matches()) {
            return date;
        }
        if (pattern3.matcher(date).matches()) {
            return date;
        }
        if (pattern4.matcher(date).matches()) {
            return date;
        }
        return null;
    }

    public String MailCheck( String mail ) {
        String regex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(regex);

        if (pattern.matcher(mail).matches()) {
            return mail;
        }
        return null;
    }
}