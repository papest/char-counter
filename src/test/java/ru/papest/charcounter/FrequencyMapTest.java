package ru.papest.charcounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyMapTest {

    public static Object[][] data() {
        return new Object[][]{
                {"abcdefgABCDEFG", """
"a": 1, "A": 1, "b": 1, "B": 1, "c": 1, "C": 1, "d": 1, "D": 1, "e": 1, "E": 1, "f": 1, "F": 1, "g": 1, "G": 1"""},
                {"""
?>}{}[]\\\\*?^|&""", """
                "\\": 2, "}": 2, "?": 2, "&": 1, "*": 1, "{": 1, "[": 1, "|": 1, "]": 1, ">": 1, "^": 1"""},
                {"АБВГДЕФЮЯЙЫЁабвгдефюяйыё", """
"Ё": 1, "Ф": 1, "ф": 1, "Ы": 1, "ы": 1, "Ю": 1, "ю": 1, "Я": 1, "я": 1, "А": 1, "а": 1, "Б": 1, "б": 1, "ё": 1, "В": 1, "в": 1, "Г": 1, "г": 1, "Д": 1, "д": 1, "Е": 1, "е": 1, "Й": 1, "й": 1"""}
        };
    }

    @ParameterizedTest
    @MethodSource("data")
    void getMapToString(String original, String charFrequency) {
        assertEquals(charFrequency, new FrequencyMap(original).getMapToString());
    }
}