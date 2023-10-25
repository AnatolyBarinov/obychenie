package org.example.test;

import org.example.PhoneBook;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @Before
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAdd() {
        assertEquals(1, phoneBook.add("Путин", "123456"));
        assertEquals(2, phoneBook.add("Олежек", "789012"));
        assertEquals(2, phoneBook.add("Олежек", "345678")); // повторяющееся имя, добавлять не будем
    }

    @Test
    public void testFindByNumber() {
        phoneBook.add("Путин", "123456");
        phoneBook.add("Олежек", "789012");
        assertNull(phoneBook.findByNumber("999999")); // несуществующий номер
        assertEquals("Путин", phoneBook.findByNumber("123456"));
    }

    @Test
    public void testFindByName() {
        phoneBook.add("Путин", "123456");
        phoneBook.add("Олежек", "789012");
        assertNull(phoneBook.findByName("ТемныйЛорд")); // несуществующий имя
        assertEquals("789012", phoneBook.findByName("Олежек"));
    }

    @Test
    public void testPrintAllNames() {
        phoneBook.add("Путин", "123456");
        phoneBook.add("Олежек", "789012");
        phoneBook.add("ТемныйЛорд", "345678");
        phoneBook.printAllNames(); // Вывод имен
    }
}