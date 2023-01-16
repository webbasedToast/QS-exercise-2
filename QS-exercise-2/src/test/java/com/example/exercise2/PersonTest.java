package com.example.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;

public class PersonTest {

    @Test
    void testcase_1a() {
        Person tomAdler = new Person("Tom", "Adler", "11-08-1996");
        assertEquals("Tom", tomAdler.getName());
    }

    @Test
    void testcase_1b() {
        Person tomAdler = new Person("Tom", "Adler", "11-08-1996");
        assert tomAdler.getAge() > 18;
    }


    @Test
    @DisplayName("Should throw an Exception here")
    void testCase_2() {
        Person adamSmith = new Person("Adam", "Smith");
        assertThrows(RuntimeException.class, () -> adamSmith.setBirthDay("29/02/1993"));
    }

    @Disabled
    void testcase_3_toBeIgnored() { assertTrue(true);}

    @Test
    void testcase_5a() {
        Person p1 = new Person("Anne", "Dallas");
        assertAll("p1", () -> assertEquals("Anne", p1.getName()),
                                () -> assertEquals("Dallas", p1.getSurname())
        );
    }

    @Test
    void testcase_5b() {
        Person p2 = new Person("Andy", "Doe", "03-11-1756");
        assertAll("p2", () -> assertEquals("Andy", p2.getName()),
                () -> assertEquals("Doe", p2.getSurname()),
                () -> assertEquals("03-11-1756", p2.getBirthDay())
        );
    }

    @Test
    void testcase_8() {
        Person p1 = new Person("Anne", "Dallas");
        assertThrows(RuntimeException.class, () -> p1.getAge());
    }
}
