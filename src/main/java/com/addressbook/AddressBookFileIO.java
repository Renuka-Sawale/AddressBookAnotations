package com.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookFileIO {
    public static String FILE = "addressBook.txt";

    public void writeData(List<PersonDetails> arrayOfAddressBook) {
        StringBuffer stringbuffer = new StringBuffer();
        arrayOfAddressBook.forEach(address -> {
            String personDetailsString = address.toString().concat("\n");
            stringbuffer.append(personDetailsString);
        });

        try {
            Files.write(Paths.get(FILE), stringbuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File("addressBook.txt").toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File("addressBook.txt").toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Entries are:" + entries);
        return entries;
    }
}
