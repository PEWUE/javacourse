import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cellphone extends Telephone {
    protected List<String> callsHistory = new ArrayList<>();

    public Cellphone(String communicationInterface, Color color) {
        super(communicationInterface, color);
    }

    @Override
    public void call(String number) {
        super.call(number);
        callsHistory.addFirst(number);
        if (callsHistory.size() > 10) {
            callsHistory.removeLast();
        }
    }

    @Override
    public void showCallsHistory() {
        callsHistory.forEach(System.out::println);
    }
}
