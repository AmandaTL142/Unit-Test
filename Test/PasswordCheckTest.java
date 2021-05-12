import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckTest {

    @Test
    void isValidPassword() {
        // Arrange
        PasswordCheck validator = new PasswordCheck();

        // Act

        //----Test for password med 4 tal----

        //Skal bestå af 4 tal

        boolean pwFireTestFalse1 = validator.isValidPassword("193","0101211039");

        boolean pwFireTestFalse2 = validator.isValidPassword("19304","0101211039");

        boolean pwFireTestTrue1 = validator.isValidPassword("1930","0101211039");


        //Må ikke bestå af 4 ens tal

        boolean pwFireTestFalse3 = validator.isValidPassword("1111","0101211039");


        //Må ikke bestå af en talrække fx 1234 eller 5678
        boolean pwFireTestFalse4 = validator.isValidPassword("1234","0101211039");


        //Må ikke være en del af dit cpr-nummer
        boolean pwFireTestFalse5 = validator.isValidPassword("0101","0101211039");



        //----Test for password med 6-40 tegn----



        /*
        ✔ Skal være mellem 6 og 40 tegn
✔ Skal indeholde både bogstaver og tal
✔ ️Må ikke indeholde visse specialtegn, herunder æ, ø og å
✔ Må ikke indeholde det samme tegn 4 gange i træk
✔ Må hverken starte eller slutte med et blanktegn
✔ Må ikke indeholde dit cpr- eller NemID-nummer
✔ Der skelnes ikke mellem store og små bogstaver.
✔ Tilladte specialtegn er: { } ! # " $ ’ % ^ & , * ( ) _ + - = : ; ? . og @.
         */



        // Assert

        //Password på 4 tal
        assertEquals(false,pwFireTestFalse1);
        assertEquals(false,pwFireTestFalse2);
        assertEquals(true,pwFireTestTrue1);
        assertEquals(false,pwFireTestFalse3);
        assertEquals(false,pwFireTestFalse4);
        assertEquals(false,pwFireTestFalse5);

        //Password på 6-40 tegn
    }
}