import java.math.BigDecimal;
import java.math.RoundingMode;

public enum TicketType {
    CHILD(new BigDecimal("0.7")),
    ADULT(new BigDecimal("1")),
    SENIOR(new BigDecimal("0.8"));

    private final BigDecimal priceMultiplier;

    TicketType(BigDecimal priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public BigDecimal calculatePrice(BigDecimal basePrice) {
        return basePrice.multiply(priceMultiplier).setScale(2, RoundingMode.HALF_UP);
    }
}
