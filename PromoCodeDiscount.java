public class PromoCodeDiscount implements DiscountStrategy {
    private String promoCode;

    public PromoCodeDiscount(String promoCode) {
        this.promoCode = promoCode;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        if ("PIZZA10".equalsIgnoreCase(promoCode)) {
            return totalAmount * 0.10; // 10% discount for valid promo code
        } else {
            System.out.println("Invalid promo code.");
            return 0;
        }
    }
}
