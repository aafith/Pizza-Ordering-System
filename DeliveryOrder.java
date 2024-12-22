public class DeliveryOrder extends Order {
    private String deliveryAddress;

    public DeliveryOrder(String orderId, String customerName, String deliveryAddress, Pizza pizza) {
        super(orderId, customerName, pizza);
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = "Out for Delivery";
    }

    @Override
    public void displayOrderDetails() {
        System.out.println("- Delivery Order: " + orderId + " for " + customerName + " - " + orderStatus + " to " + deliveryAddress);
    }
}