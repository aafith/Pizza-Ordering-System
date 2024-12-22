public class DiscountContext {
    private DiscountStrategy discountStrategy;

    public DiscountContext(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}
