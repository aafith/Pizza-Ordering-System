public class CustomerObserver implements OrderStatus {
    private String customerName;

    public CustomerObserver(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void updateOrderStatus(String status) {
        System.out.println("Hello " + customerName + ", your order status is: " + status);
    }
}