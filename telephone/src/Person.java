public record Person(String firstName, String lastName, String number) {
    public String getPersonInfo() {
        return firstName + " " + lastName + " " + number;
    }
}
