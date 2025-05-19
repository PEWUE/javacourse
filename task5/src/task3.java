public class task3 {
    public static void main(String[] args) {
        Person p1 = new Person("Adam", 1990);
        Person p2 = new Person("Ewa", 1995);
        Person p3 = new Person("Jan", 2000);
        Person p4 = new Person("Paweł", 1999);

        System.out.println("Starsza: " + Person.getOlder(p1, p2));

        System.out.println(p2.getAge());

        Person[] people = {p1, p2, p3, p4};
        System.out.println("Najstarsza: " + Person.getTheOldest(people));
    }
}
