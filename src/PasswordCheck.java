public class PasswordCheck {

    //Løst uden Regex, den må jeg tage næste gang :)

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
✔ Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @.

Din adgangskode med fire tal
Hvis du vælger en adgangskode med 4 tal skal opfylde følgende krav:

✔ Skal bestå af 4 tal.
✔ Må ikke bestå af 4 ens tal.
✔ Må ikke bestå af en talrække fx 1234 eller 5678.
✔ Må ikke være en del af dit cpr-nummer.
     */

    //Metoden returnerer "true", hvis passwordet godkendes
    static boolean isValidPassword(String password, String cpr) {
        password = password.toLowerCase();                      //Der skelnes ikke mellem store og små bogstaver

        //Password på 4 tal
        if (    password.length() == 4 &&                       //Skal bestå af 4 tegn
                isNumeric(password) &&                          //Skal udelukkende bestå af tal
                isNotSequence(password) &&                      //Må ikke bestå af en talrække fx 1234 eller 5678
                notSameFourCharactersInARow(password) &&        //Må ikke bestå af 4 ens tal
                !cpr.contains(password)                         //Må ikke være en del af dit cpr-nummer
        ) {
            return true;


        //Password på mindst 6 tegn
        } else if (
                        stringContainsNumbersAndLetters(password) &&    //Tjekker at der er både tal og bogstaver
                        containsOnlyValidCharacters(password) &&        //Tjekker om alle karakterer er lovlige
                        !password.contains("æ") &&                      //Indeholder ikke æ, ø eller å
                        !password.contains("ø") &&
                        !password.contains("å") &&
                        password.length() >= 6 &&                       //Mindst 6 tegn
                        password.length() <= 40 &&                      //Højst 40 tegn
                        !password.startsWith(" ") &&                    //Må ikke starte med et blanktegn
                        !password.endsWith(" ") &&                      //Må ikke slutte med et blanktegn
                        notSameFourCharactersInARow(password) &&        //Må ikke indeholde det samme tegn 4 gange i træk
                        !cpr.contains(password) &&                      //En kode kortere end CPR må ikke være identisk med en del af CPR-nummeret
                        !password.contains(cpr)                         //En kode længere end eller lig med CPR må ikke indeholde CPR

        ) {
            return true;
        } else {
            return false;
        }

    }

    //Denne metode bruges til at undersøge, om et string-input kun indeholder tal.
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

    public static boolean stringContainsNumbersAndLetters(String password) {
        int checkerLetter = 0;
        int checkerNumber = 0;
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                checkerLetter++;

            } else if (Character.isDigit(chars[i])) {
                checkerNumber++;
            }
        }

        if(checkerLetter!=0 && checkerNumber!=0){
            return true;
        } else {
                return false;
        }
    }



    public static boolean notSameFourCharactersInARow(String password) {
        char currentChar;
        int frequency;
        boolean sameFourChar = false;
        char[] chars = password.toCharArray();
        for (int i = 0; i < (chars.length - 1); i++) {
            currentChar = chars[i];
            frequency = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == currentChar) {
                    frequency++;

                    if(j==(chars.length - 1) && frequency >= 4){
                        sameFourChar = true;
                    }
                } else if (chars[j] != currentChar && frequency >= 4) {
                    sameFourChar = true;
                    break;
                } else {
                    break;
                }
            }
        }
        if (sameFourChar == true) {
            return false;
        } else {
            return true;
        }


    }

    public static boolean containsOnlyValidCharacters(String password) {
        int checker = 0;
        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (    Character.isLetter(chars[i]) ||
                    Character.isDigit(chars[i]) ||
                    chars[i] == '{' ||
                    chars[i] == '}' ||
                    chars[i] == '!' ||
                    chars[i] == '#' ||
                    chars[i] == '"' ||
                    chars[i] == '$' ||
                    chars[i] == '’' ||
                    chars[i] == '%' ||
                    chars[i] == '^' ||
                    chars[i] == '&' ||
                    chars[i] == ',' ||
                    chars[i] == '*' ||
                    chars[i] == '(' ||
                    chars[i] == ')' ||
                    chars[i] == '_' ||
                    chars[i] == '+' ||
                    chars[i] == '-' ||
                    chars[i] == '=' ||
                    chars[i] == ':' ||
                    chars[i] == ';' ||
                    chars[i] == '?' ||
                    chars[i] == '.' ||
                    chars[i] == ' ' ||
                    chars[i] == '@') {
            } else {
                checker++;
            }
        }

        if(checker==0){
            return true;
        } else {
            return false;
        }

    }
}

