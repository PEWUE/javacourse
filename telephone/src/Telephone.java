import java.awt.*;

public class Telephone {
    private final String communicationInterface;
    private final Color color;

    public Telephone(String communicationInterface, Color color) {
        this.communicationInterface = communicationInterface;
        this.color = color;
    }

    public void call(String number) {
        System.out.println("Dzwonie do: " + number);
    }

    public void showCallsHistory() {
        System.out.println("Brak historii");
    }
}
