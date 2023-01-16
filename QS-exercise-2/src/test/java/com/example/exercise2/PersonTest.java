package com.example.exercise2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.Random.class)
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
    void testcase_3_toBeIgnored() {
        assertTrue(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"02/12/1993", "32-02-9999", "29-02-1993", "11.12.2021"})
        // six numbers
    void testcase_4(String birthday) {
        Person adamSmith = new Person("Adam", "Smith");
        assertThrows(RuntimeException.class, () -> adamSmith.setBirthDay(birthday));
    }


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
    @EnabledOnOs({OS.MAC})
    public void testcase_6() {
        assertTrue(true);
    }

    @Test
    void testcase_8() {
        Person p1 = new Person("Anne", "Dallas");
        assertThrows(RuntimeException.class, () -> p1.getAge());
    }
}
