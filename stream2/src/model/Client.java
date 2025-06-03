package model;

import java.util.Objects;

public record Client(String firstName, String lastName) {

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(lastName, client.lastName) && Objects.equals(firstName, client.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
