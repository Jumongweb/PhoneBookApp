import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {
    @Test
    public void testToGetPhoneNumber(){
        Phonebook phonebook = new Phonebook();
        phonebook.setPhoneNumber("08133445566");
        String sample = phonebook.getPhoneNumber();
        assertEquals("08133445566", sample);
    }

    @Test
    public void testToGetFirstName(){
        Phonebook phonebook = new Phonebook();
        phonebook.setPhoneNumber("Ying");
        String sample = phonebook.getPhoneNumber();
        assertEquals("Ying", sample);
    }

    @Test
    public void testToGetLastName(){
        Phonebook phonebook = new Phonebook();
        phonebook.setPhoneNumber("08133445566");
        String sample = phonebook.getPhoneNumber();
        assertEquals("08133445566", sample);
    }

    @Test
    public void testThatMainMenuExist(){
        Phonebook phonebook = new Phonebook();
      //  assertTrue(phonebook.mainMenu());
    }
}