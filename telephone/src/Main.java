import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> friends = List.of(
                new Person("Jan", "Kowalski", "123-456-789"),
                new Person("Anna", "Nowak", "987-654-321"),
                new Person("Piotr", "Wiśniewski", "555-666-777")
        );

        Telephone[] telephones = {
                new Telephone("Analogowy", Color.BLACK),
                new Cellphone("GSM", Color.BLUE),
                new Smartphone("LTE", Color.RED, friends)
        };

        String[] numbers = {
                "123-456-789", "111-222-333", "987-654-321", "444-555-666", "555-666-777",
                "777-888-999", "123-456-789", "222-333-444", "987-654-321", "666-777-888"
        };

        for (Telephone telephone : telephones) {
            for (int i = 0; i < 10; i++) {
                telephone.call(numbers[i]);
            }
        }

        for (Telephone telephone : telephones) {
            telephone.showCallsHistory();
            System.out.println();
        }
    }
}