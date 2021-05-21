package com.addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Address {
    List<PersonDetails> list = new ArrayList<PersonDetails>();
    Scanner scan = new Scanner(System.in);

    public void insertContact() {
        for (int i=0; i<2; i++) {
            System.out.println("Enter first name");
            String firstName = scan.nextLine();
            System.out.println("Enter last name");
            String lastName = scan.nextLine();
            System.out.println("Enter address");
            String address = scan.nextLine();
            System.out.println("Enter city");
            String city = scan.nextLine();
            System.out.println("Enter state");
            String state = scan.nextLine();
            System.out.println("Enter zip");
            String zip = scan.nextLine();
            System.out.println("Enter phoneNo");
            String phoneNo = scan.nextLine();
            System.out.println("Enter email");
            String email = scan.nextLine();
            PersonDetails persondetails = new PersonDetails(firstName, lastName, address, city, state, zip, phoneNo, email);
            list.add(persondetails);
        }
    }

    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name which you want to edit");
        String editname = sc.nextLine();
        PersonDetails details = null;
        for (int i= 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getFirstName().equals(editname)) {
                System.out.println("Enter the new first name");
                String newFirstName = sc.nextLine();
                details.setFirstName(newFirstName);
                System.out.println("Enter the new last name");
                String newLastName = sc.nextLine();
                details.setLastName(newLastName);
                System.out.println("Enter new address");
                String newAddress = sc.nextLine();
                details.setAddress(newAddress);
                System.out.println("Enter new city");
                String newCity = sc.nextLine();
                details.setCity(newCity);
                System.out.println("Enter new state");
                String newState = sc.nextLine();
                details.setState(newState);
                System.out.println("Enter new zip");
                String newZip = sc.nextLine();
                details.setZip(newZip);
                System.out.println("Enter new phoneNo");
                String newPhoneNo = sc.nextLine();
                details.setPhoneNo(newPhoneNo);
                System.out.println("Enter new email");
                String newEmail = sc.nextLine();
                details.setEmail(newEmail);
                break;
            }
        }
        System.out.println(list);
    }

    public void deleteContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name which you want to delete");
        String name = sc.nextLine();
        PersonDetails details = null;
        for (int i= 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getFirstName().equals(name)) {
                list.remove(i);
            }
            System.out.println(list);
        }
    }

    public void display() {
        for (PersonDetails person: list) {
            System.out.println(person);
        }
    }

    public void displayPersonInState() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the state name which you want to view from adress detail");
        String statename = sc.nextLine();
        PersonDetails details = null;
        for (int i= 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getState().equals(statename)) {
                System.out.println(list.get(i));
            }
        }
    }

    public void searchPersonInCity() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name which you want to view from address detail");
        String cityname = sc.nextLine();
        PersonDetails details = null;
        for (int i= 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getCity().equals(cityname)) {
                System.out.println(list.get(i));
            }
        }
    }

    public void sortByName() {
        List<PersonDetails> sortedList = list.stream()
                .sorted(Comparator.comparing(PersonDetails::getFirstName))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public void sortCity() {
        List<PersonDetails> sortedList = list.stream()
                .sorted(Comparator.comparing(PersonDetails::getCity))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public void sortState() {
        List<PersonDetails> sortedList = list.stream()
                .sorted(Comparator.comparing(PersonDetails::getState))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }
}


