package dataHolder;

import java.time.chrono.ChronoLocalDateTime;

public class Member {
    private String Name;
    private String phoneNumber;
    private String email;
    private ChronoLocalDateTime Age;
    private ChronoLocalDateTime StartDate;
    private Boolean Active;
    private Boolean Deficit;
    private Boolean Competitive;
    private int Balance;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ChronoLocalDateTime getAge() {
        return Age;
    }

    public void setAge(ChronoLocalDateTime age) {
        Age = age;
    }

    public ChronoLocalDateTime getStartDate() {
        return StartDate;
    }

    public void setStartDate(ChronoLocalDateTime startDate) {
        StartDate = startDate;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public Boolean getDeficit() {
        return Deficit;
    }

    public void setDeficit(Boolean deficit) {
        Deficit = deficit;
    }

    public Boolean getCompetitive() {
        return Competitive;
    }

    public void setCompetitive(Boolean competitive) {
        Competitive = competitive;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public Member(String name, String phoneNumber, String email, ChronoLocalDateTime age, ChronoLocalDateTime startDate, Boolean active, Boolean deficit, Boolean competitive, int balance) {
        Name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        Age = age;
        StartDate = startDate;
        Active = active;
        Deficit = deficit;
        Competitive = competitive;
        Balance = balance;
    }
}
