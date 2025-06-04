package model;

import java.util.List;

public class User {
    private final String firstName;
    private final String lastName;
    private final Sex sex;
    private final int age;
    private final List<Account> accounts;
    private final List<Permit> permits;

    public User(String firstName, String lastName, Sex sex, int age, List<Account> accounts, List<Permit> permits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.accounts = accounts;
        this.permits = permits;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Permit> getPermits() {
        return permits;
    }

    public boolean hasPermit(Permit permit) {
        return permits.contains(permit);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + sex + " - " + age;
    }
}
