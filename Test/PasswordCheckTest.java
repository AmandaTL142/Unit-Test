import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckTest {

    @Test
    void isValidPassword() {
        // Arrange
        PasswordCheck validator = new PasswordCheck();

        // Act

        //----Test for password med 4 tal----


        //Opfylder alle krav
        boolean pwFourTestTrue1 = validator.isValidPassword("1930","0101211039");

        //Skal bestå af 4 tal
        boolean pwFourTestFalse1 = validator.isValidPassword("193","0101211039");

        boolean pwFourTestFalse2 = validator.isValidPassword("19304","0101211039");


        //Må ikke bestå af 4 ens tal
        boolean pwFourTestFalse3 = validator.isValidPassword("1111","0101211039");


        //Må ikke bestå af en talrække fx 1234 eller 5678
        boolean pwFourTestFalse4 = validator.isValidPassword("1234","0101211039");


        //Må ikke være en del af dit cpr-nummer
        boolean pwFourTestFalse5 = validator.isValidPassword("0101","0101211039");



        //----Test for password med 6-40 tegn----

        //Opfylder alle krav
        boolean pwLongTestTrue1 = validator.isValidPassword("193npa","0101211039");


        //Skal være mellem 6 og 40 tegn
        boolean pwLongTestFalse1 = validator.isValidPassword("193eo","0101211039"); //5 tegn

        boolean pwLongTestFalse2 = validator.isValidPassword("193mreurnf8192749201yehdbsneu28eyrbfhtie1","0101211039"); //41 tegn


        //Må ikke indeholde visse specialtegn, herunder æ, ø og å
        boolean pwLongTestFalse3 = validator.isValidPassword("193æqiw","0101211039"); //Indeholder æ

        boolean pwLongTestFalse4 = validator.isValidPassword("193mak€","0101211039"); //Indeholder €


        //Må ikke indeholde det samme tegn 4 gange i træk
        boolean pwLongTestFalse5 = validator.isValidPassword("nsorne8888","0101211039"); //Fire tal i træk

        boolean pwLongTestFalse6 = validator.isValidPassword("nkkeoooo1092","0101211039"); //Fire bogstaver i træk


        //Må hverken starte eller slutte med et blanktegn
        boolean pwLongTestFalse7 = validator.isValidPassword(" 193m2f","0101211039"); //Starter med mellemrum

        boolean pwLongTestFalse8 = validator.isValidPassword("193m2f ","0101211039"); //Slutter med mellemrum


        //Må ikke indeholde dit cpr- eller NemID-nummer
        boolean pwLongTestFalse9 = validator.isValidPassword("0101211039aed ","0101211039"); //Indeholder CPR-nummer


        //Der skelnes ikke mellem store og små bogstaver
        boolean pwLongTestTrue2 = validator.isValidPassword("193NPA","0101211039"); //Tester, om store bogstaver også godkendes


        //Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @
        boolean pwLongTestTrue3 = validator.isValidPassword("an19{}!#\"$’%^&,*()_+-=:;?.@","0101211039"); //Indeholder alle de listede specialtegn


        // Assert

        //Password på 4 tal
        assertEquals(false,pwFourTestFalse1);
        assertEquals(false,pwFourTestFalse2);
        assertEquals(true,pwFourTestTrue1);
        assertEquals(false,pwFourTestFalse3);
        assertEquals(false,pwFourTestFalse4);
        assertEquals(false,pwFourTestFalse5);

        //Password på 6-40 tegn
        assertEquals(false,pwLongTestFalse1);
        assertEquals(false,pwLongTestFalse2);
        assertEquals(false,pwLongTestFalse3);
        assertEquals(false,pwLongTestFalse4);
        assertEquals(false,pwLongTestFalse5);
        assertEquals(false,pwLongTestFalse6);
        assertEquals(false,pwLongTestFalse7);
        assertEquals(false,pwLongTestFalse8);
        assertEquals(false,pwLongTestFalse9);
        assertEquals(true,pwLongTestTrue1);
        assertEquals(true,pwLongTestTrue2);
        assertEquals(true,pwLongTestTrue3);
    }
}