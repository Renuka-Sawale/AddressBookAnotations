package com.addressbook;

import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Address addr = new Address();
        int option;
        System.out.println("Welcome to Address Book System");
        do {
            System.out.println("1. Add Person Details");
            System.out.println("2. Edit the Details");
            System.out.println("3. Delete the Details");
            System.out.println("4. Display the Details");
            System.out.println("5. Display Person in State");
            System.out.println("6. Search Person in City");
            System.out.println("7. Sort Person name");
            System.out.println("8. Sort City");
            System.out.println("9. Sort State");
            System.out.println("0. Exit");
            System.out.println("Please Choose proper option:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    addr.insertContact();
                break;

                case 2:
                    addr.editContact();
                break;

                case 3:
                    addr.deleteContact();
                break;

                case 4:
                    addr.display();
                break;

                case 5:
                    addr.displayPersonInState();
                break;

                case 6:
                    addr.searchPersonInCity();
                break;

                case 7:
                    addr.sortByName();
                    break;

                case 8:
                    addr.sortCity();
                break;

                case 9:
                    addr.sortState();
                break;

            }
        } while (option !=0);
    }
}


