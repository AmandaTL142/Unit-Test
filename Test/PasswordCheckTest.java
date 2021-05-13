import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckTest {

    @Test
    void isValidPassword() {
        // Act

        //----Test for password med 4 tal----


        //Opfylder alle krav
        boolean pwFourTestTrue1 = PasswordCheck.isValidPassword("1930","0101211039");

        //Skal bestå af 4 tal
        boolean pwFourTestFalse1 = PasswordCheck.isValidPassword("193","0101211039");

        boolean pwFourTestFalse2 = PasswordCheck.isValidPassword("19304","0101211039");


        //Må ikke bestå af 4 ens tal
        boolean pwFourTestFalse3 = PasswordCheck.isValidPassword("1111","0101211039");


        //Må ikke bestå af en talrække fx 1234 eller 5678
        boolean pwFourTestFalse4 = PasswordCheck.isValidPassword("1234","0101211039");


        //Må ikke være en del af dit cpr-nummer
        boolean pwFourTestFalse5 = PasswordCheck.isValidPassword("0101","0101211039");



        //----Test for password med 6-40 tegn----

        //Opfylder alle krav
        boolean pwLongTestTrue1 = PasswordCheck.isValidPassword("193npa","0101211039");


        //Skal være mellem 6 og 40 tegn
        boolean pwLongTestFalse1 = PasswordCheck.isValidPassword("193eo","0101211039"); //5 tegn

        boolean pwLongTestFalse2 = PasswordCheck.isValidPassword("193mreurnf8192749201yehdbsneu28eyrbfhtie1","0101211039"); //41 tegn


        //Må ikke indeholde visse specialtegn, herunder æ, ø og å
        boolean pwLongTestFalse3 = PasswordCheck.isValidPassword("193æqiw","0101211039"); //Indeholder æ

        boolean pwLongTestFalse4 = PasswordCheck.isValidPassword("193mak€","0101211039"); //Indeholder €


        //Må ikke indeholde det samme tegn 4 gange i træk
        boolean pwLongTestFalse5 = PasswordCheck.isValidPassword("nsorne8888","0101211039"); //Fire tal i træk

        boolean pwLongTestFalse6 = PasswordCheck.isValidPassword("nkkeoooo1092","0101211039"); //Fire bogstaver i træk


        //Må hverken starte eller slutte med et blanktegn
        boolean pwLongTestFalse7 = PasswordCheck.isValidPassword(" 193m2f","0101211039"); //Starter med mellemrum

        boolean pwLongTestFalse8 = PasswordCheck.isValidPassword("193m2f ","0101211039"); //Slutter med mellemrum


        //Må ikke indeholde dit cpr- eller NemID-nummer
        boolean pwLongTestFalse9 = PasswordCheck.isValidPassword("0101211039aed ","0101211039"); //Indeholder CPR-nummer


        //Der skelnes ikke mellem store og små bogstaver
        boolean pwLongTestTrue2 = PasswordCheck.isValidPassword("193NPA","0101211039"); //Tester, om store bogstaver også godkendes. Jeg kan dog ikke rent faktisk teste, om programmet ikke vil skelne.


        //Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @
        boolean pwLongTestTrue3 = PasswordCheck.isValidPassword("an19{}!#\"$’%^&,*()_+-=:;?.@","0101211039"); //Indeholder alle de listede specialtegn


        // Assert

        //Password på 4 tal
        assertFalse(pwFourTestFalse1);
        assertFalse(pwFourTestFalse2);
        assertTrue(pwFourTestTrue1);
        assertFalse(pwFourTestFalse3);
        assertFalse(pwFourTestFalse4);
        assertFalse(pwFourTestFalse5);

        //Password på 6-40 tegn
        assertFalse(pwLongTestFalse1);
        assertFalse(pwLongTestFalse2);
        assertFalse(pwLongTestFalse3);
        assertFalse(pwLongTestFalse4);
        assertFalse(pwLongTestFalse5);
        assertFalse(pwLongTestFalse6);
        assertFalse(pwLongTestFalse7);
        assertFalse(pwLongTestFalse8);
        assertFalse(pwLongTestFalse9);
        assertTrue(pwLongTestTrue1);
        assertTrue(pwLongTestTrue2);
        assertTrue(pwLongTestTrue3);
    }
}