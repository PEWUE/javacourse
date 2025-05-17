import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal basePrice = new BigDecimal("19.99");

        BigDecimal childTicketPrice = TicketType.CHILD.calculatePrice(basePrice);
        BigDecimal adultTicketPrice = TicketType.ADULT.calculatePrice(basePrice);
        BigDecimal seniorTicketPrice = TicketType.SENIOR.calculatePrice(basePrice);

        System.out.println(childTicketPrice);
        System.out.println(adultTicketPrice);
        System.out.println(seniorTicketPrice);

        System.out.println("git test");
    }
}