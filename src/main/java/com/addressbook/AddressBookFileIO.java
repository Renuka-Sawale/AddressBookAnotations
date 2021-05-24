package com.addressbook;

import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookFileIO {
    public static String TEXT_FILE = "F:\\AddressBookAnnotations\\src\\main\\resources\\addressBook.txt";
    public static String CSV_FILE = "F:\\AddressBookAnnotations\\src\\main\\resources\\addressBook.csv";
    public static String JSON_FILE = "F:\\AddressBookAnnotations\\src\\main\\resources\\addressBook.json";

    public void writeDataToFile(List<PersonDetails> arrayOfAddressBook) {
        StringBuffer stringbuffer = new StringBuffer();
        arrayOfAddressBook.forEach(address -> {
            String personDetailsString = address.toString().concat("\n");
            stringbuffer.append(personDetailsString);
        });
        try {
            Files.write(Paths.get(TEXT_FILE), stringbuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            Files.lines(new File(TEXT_FILE).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try {
            entries = Files.lines(new File(TEXT_FILE).toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Entries are:" + entries);
        return entries;
    }

    public void writeDataToCsvFile(List<PersonDetails> personDetails) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        try (
            Writer writer = Files.newBufferedWriter(Paths.get(CSV_FILE));
        ) {
            StatefulBeanToCsv<PersonDetails> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                                                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                                                        .build();
            beanToCsv.write(personDetails);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataOfCsvFile() throws IOException {
        try {
            Files.lines(new File("address_book.csv").toPath()).forEach(System.out::println);
            //System.out.println("Csv file entries are: " + entries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataToJSON(List<PersonDetails> arrayOfAddressBook) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(arrayOfAddressBook);
            FileWriter fileWriter = new FileWriter(JSON_FILE);
            fileWriter.write(json);
            gson.toJson(arrayOfAddressBook, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataOfJsonFile() {
        try {
            Files.lines(new File(JSON_FILE).toPath()).forEach(System.out::println);
            //System.out.println("Csv file entries are: " + entries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
