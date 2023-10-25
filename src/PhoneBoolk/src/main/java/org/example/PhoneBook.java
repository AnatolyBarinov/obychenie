package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }
    //Add method stub for add
    public int add(String name, String number) {
        if (!contactExists(name)) {
            contacts.add(new Contact(name, number));
        }
        return contacts.size();
    }
//
    public String findByNumber(String number) {
        for (Contact contact : contacts) {
            if (contact.getNumber().equals(number)) {
                return contact.getName();
            }
        }
        return null;
    }

    public String findByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact.getNumber();
            }
        }
        return null;
    }

    public void printAllNames() {
        List<String> names = new ArrayList<>();
        for (Contact contact : contacts) {
            names.add(contact.getName());
        }
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }

    private boolean contactExists(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private class Contact {
        private String name;
        private String number;

        public Contact(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }
    }
}