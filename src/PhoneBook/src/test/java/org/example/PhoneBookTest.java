package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    private final String nameExample = "Иван";
    private final String phoneExample = "8-900-011-33-55";

    @BeforeEach
    void setUp() {
        phoneBook.add(nameExample, phoneExample);
    }

    @Test
    void add() {
        int act = phoneBook.add(nameExample, phoneExample);
        Assertions.assertEquals(1, act);
    }

    @Test
    void findByNumber() {
        String name = phoneBook.findByNumber(phoneExample);
        Assertions.assertEquals(nameExample, name);
        String badPhoneExample = "1";
        Assertions.assertNull(phoneBook.findByNumber(badPhoneExample));
    }

    @Test
    void findByName() {
        String name = phoneBook.findByName(nameExample);
        Assertions.assertEquals(phoneExample, name);
        String badNameExample = "1";
        Assertions.assertNull(phoneBook.findByName(badNameExample));
    }

    @Test
    void printAllNames() {
        phoneBook.add("Андрей", "23-11-23");
        phoneBook.add("Костя", "22-11-22");
        phoneBook.add("Максим", "24-11-23");
        List<String> listNames = phoneBook.printAllNames();
        List<String> ex = new ArrayList<>(Arrays.asList("Андрей", "Иван", "Костя", "Максим"));
        Assertions.assertEquals(ex, listNames);
    }
}