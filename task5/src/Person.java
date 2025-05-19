import java.time.Year;

public class Person {
    private String name;
    private int year;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public Person(String name) {
        this.name = name;
        this.year = 1990;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return Year.now().getValue() - year;
    }

    public static Person getOlder(Person person1, Person person2) {
        return person1.year < person2.year ? person1 : person2;
    }

    public static Person getTheOldest(Person[] people) {
        Person theOldest = people[0];
        for (Person person : people) {
            if (person.year < theOldest.year) {
                theOldest = person;
            }
        }
        return theOldest;
    }

    @Override
    public String toString() {
        return name + " (" + year + ")";
    }
}
