package com.example.exercise2;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

public class Person {

    private String name;
    private String surName;
    private String birthDay;

    public Person(String name, String surName, String birthDay) {
        this.name = name;
        this.surName = surName;
        setBirthDay(birthDay);
    }

    public Person(String name, String surname) {

        this.name = name;
        this.surName = surname;
    }

    public String getBirthDay() {

        return birthDay;
    }

    public int getAge() {
        if(getBirthDay() == null) {
            throw new RuntimeException("Birthday not set!");
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date now = new Date();
            Date birth = format.parse(getBirthDay());
            Calendar a = getCalendar(birth);
            Calendar b = getCalendar(now);
            int diff = b.get(YEAR) - a.get(YEAR);
            if (a.get(MONTH) > b.get(MONTH) ||
                    (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
                diff--;
            }
            return diff;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.GERMAN);
        cal.setTime(date);
        return cal;
    }

    public void setBirthDay(String birthDay) {

        if (!isLegalDate(birthDay)) {

            throw new RuntimeException("Date is not valid. Please use valid date of format dd-MM-yyyy");
        }
        this.birthDay = birthDay;
    }

    private boolean isLegalDate(String birthDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        return sdf.parse(birthDay, new ParsePosition(0)) != null;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surName;
    }

    public void setSurname(String surname) {

        this.surName = surname;
    }

}
