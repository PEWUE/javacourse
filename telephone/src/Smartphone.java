import java.awt.*;
import java.util.List;
import java.util.Optional;

public class Smartphone extends Cellphone {
    private final List<Person> friends;

    public Smartphone(String communicationInterface, Color color, List<Person> friends) {
        super(communicationInterface, color);
        this.friends = friends;
    }

    @Override
    public void showCallsHistory() {
        callsHistory.stream()
                .map(number -> findByNumber(number)
                        .map(Person::getPersonInfo)
                        .orElse(number))
                .forEach(System.out::println);
    }

    private Optional<Person> findByNumber(String number) {
        return friends.stream()
                .filter(friend -> friend.number().equals(number))
                .findFirst();
    }
}
