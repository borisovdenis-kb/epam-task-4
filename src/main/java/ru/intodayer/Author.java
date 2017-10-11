package ru.intodayer;

import java.time.LocalDate;


public class Author {
    private String name;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private boolean gender;     // TODO: через enum?

    public Author(String name, LocalDate birthDay, boolean gender) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
