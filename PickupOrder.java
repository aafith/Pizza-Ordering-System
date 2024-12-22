public class PickupOrder extends Order {
    public PickupOrder(String orderId, String customerName, Pizza pizza) {
        super(orderId, customerName, pizza);
        this.orderStatus = "Ready for Pickup";
    }

    @Override
    public void displayOrderDetails() {
        System.out.println("- Pickup Order: " + orderId + " for " + customerName + " - " + orderStatus);
    }
}