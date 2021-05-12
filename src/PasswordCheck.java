import java.util.InputMismatchException;
import java.util.Locale;
import java.util.regex.Pattern;

public class PasswordCheck {

    /*
Din adgangskode med minimum seks tegn


Hvis du vælger en adgangskode med minimum 6 tegn, blandede tal og bogstaver og evt. specialtegn, skal opfylde følgende krav:

✔ Skal være mellem 6 og 40 tegn
✔ Skal indeholde både bogstaver og tal
✔ ️Må ikke indeholde visse specialtegn, herunder æ, ø og å
✔ Må ikke indeholde det samme tegn 4 gange i træk
✔ Må hverken starte eller slutte med et blanktegn
✔ Må ikke indeholde dit cpr- eller NemID-nummer
✔ Der skelnes ikke mellem store og små bogstaver.
Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @.

Din adgangskode med fire tal
Hvis du vælger en adgangskode med 4 tal skal opfylde følgende krav:

✔ Skal bestå af 4 tal.
✔ Må ikke bestå af 4 ens tal.
✔ Må ikke bestå af en talrække fx 1234 eller 5678.
✔ Må ikke være en del af dit cpr-nummer.
     */

    static boolean isValidPassword(String password, String cpr) {
        password = password.toLowerCase();                      //Der skelnes ikke mellem store og små bogstaver
        //Password på 4 tal
        if (    password.length() == 4 &&                       //Skal bestå af 4 tegn
                isNumeric(password) &&                          //Skal udelukkende bestå af tal
                isNotSequence(password) &&                      //Må ikke bestå af en talrække fx 1234 eller 5678
                sameFourCharacters(password) &&                 //Må ikke bestå af 4 ens tal
                !cpr.contains(password)                         //Må ikke være en del af dit cpr-nummer
        ) {
            return true;

            //Password på mindst 6 tegn
        } else if (
                        stringContainsNumber(password) &&       //Skal indeholde tal
                        stringContainsLetter(password) &&       //Skal indeholde bogstaver
                        !password.contains("æ") &&              //Må ikke indeholde æ
                        !password.contains("ø") &&              //Må ikke indeholde ø
                        !password.contains("å") &&              //Må ikke indeholde å
                        password.length() >= 6 &&               //Mindst 6 tegn
                        password.length() <= 40 &&              //Højst 40 tegn
                        password.startsWith(" ") &&             //Må ikke starte med et blanktegn
                        password.endsWith(" ") &&               //Må ikke slutte med et blanktegn
                        sameFourCharacters(password) &&         //Må ikke indeholde det samme tegn 4 gange i træk
                        !cpr.contains(password) &&              //En kode kortere end CPR må ikke være identisk med en del af CPR-nummeret
                        !password.contains(cpr) &&              //En kode længere end eller lig med CPR må ikke indeholde CPR

        ) {
            return true;
        } else {
            return false;
        }

    }

    //Denne metode bruges til at undersøge, om et string-input er et tal.
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotSequence(String str) {
        if (str.equals("1234") || str.equals("2345") || str.equals("3456") || str.equals("4567") || str.equals("5678") || str.equals("6789") || str.equals("7890")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean stringContainsNumber(String s) {
        return Pattern.compile("[0-9]").matcher(s).find();
    }

    //Jeg er skeprisk over, hvorvidt denne metode virker
    public static boolean stringContainsLetter(String s) {
        return Pattern.compile("[a-z]").matcher(s.toLowerCase(Locale.ROOT)).find();
    }

    public static boolean sameFourCharacters(String password) {
        char currentChar;
        int frequency;
        boolean isTrue = false;
        char[] chars = password.toCharArray();
        for (int i = 0; i < (chars.length - 1); i++) {
            currentChar = chars[i];
            frequency = 0;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == currentChar) {
                    frequency++;
                } else if (chars[j] != currentChar && frequency >= 4) {
                    isTrue = true;
                } else {
                    break;
                }
            }
        }
        if (isTrue == true) {
            return true;
        } else {
            return false;
        }


    }
}
