package org.example;

import java.util.*;

public class PhoneBook {
    TreeMap<String, String> phoneBook = new TreeMap<>();

    public int add(String name, String phone) {
        if(!phoneBook.containsKey(name) && !phoneBook.containsValue(phone)) {
            phoneBook.putIfAbsent(name, phone);
        }
        return phoneBook.size();
    }

    public String findByNumber(String phone) {
        return phoneBook.entrySet()
                .stream()
                .filter(x -> x.getValue().equals(phone))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }

    public List<String> printAllNames() {
        return new ArrayList<>(phoneBook.keySet());
    }
}