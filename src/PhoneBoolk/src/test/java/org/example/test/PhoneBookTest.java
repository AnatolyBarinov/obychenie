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
//Тест testAdd проверяет, что метод add добавляет контакты в телефонную книгу и возвращает правильное количество контактов.
    @Test
    public void testAdd() {
        assertEquals(1, phoneBook.add("Путин", "123456"));
        assertEquals(2, phoneBook.add("Олежек", "789012"));
        assertEquals(2, phoneBook.add("Олежек", "345678")); // повторяющееся имя, добавлять не будем
    }
//Тест testFindByNumber проверяет, что метод findByNumber находит правильное имя контакта по номеру
    @Test
    public void testFindByNumber() {
        phoneBook.add("Путин", "123456");
        phoneBook.add("Олежек", "789012");
        assertNull(phoneBook.findByNumber("999999")); // несуществующий номер
        assertEquals("Путин", phoneBook.findByNumber("123456"));
    }
    //Тест testFindByName проверяет, что метод findByName находит правильный номер телефона контакта по имени.
    @Test
    public void testFindByName() {
        phoneBook.add("Путин", "123456");
        phoneBook.add("Олежек", "789012");
        assertNull(phoneBook.findByName("ТемныйЛорд")); // несуществующий имя
        assertEquals("789012", phoneBook.findByName("Олежек"));
    }
   // Тест testPrintAllNames проверяет, что метод printAllNames печатает все имена контактов в алфавитном
    @Test
    public void testPrintAllNames() {
        phoneBook.add("Путин", "123456");
        phoneBook.add("Олежек", "789012");
        phoneBook.add("ТемныйЛорд", "345678");
        phoneBook.printAllNames(); // Вывод имен
    }
}