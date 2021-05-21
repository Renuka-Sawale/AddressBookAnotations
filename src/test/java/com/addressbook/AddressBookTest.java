package com.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AddressBookTest {
    @Test
    public void givenFiveDataWhenWrittenToFileShouldMatchTheEntries() {
        PersonDetails[] arrayOfAddressBook = {
                new PersonDetails("Renuka", "Sawale", "Seawood", "Pune", "560056", "1100", "9191912512", "renu11@gmail.com"),
                new PersonDetails("Reena", "Sawales", "Hinjewadi", "Mumbai", "5133332", "1222", "9191912513", "bridegelabz11@gmail.com"),
                new PersonDetails("Rani", "Shinde", "Marunji", "Latur", "58012", "1240", "9191912518","abc123@gmail.com"),
                new PersonDetails("Renu", "Surya", "pimpri", "solapur", "58012", "1240", "9191912518","abc123@gmail.com"),
                new PersonDetails("Rain", "Sighaniya", "chinchwad", "Latur", "58012", "1240", "9191912518","abc123@gmail.com")
        };

        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeData(Arrays.asList(arrayOfAddressBook));
        addressBookFileIO.printData();
        long entries = addressBookFileIO.countEntries();
        Assertions.assertEquals(5,entries);
    }
}
