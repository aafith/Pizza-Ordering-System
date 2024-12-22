public abstract class Order {
    private UserProfile user;
    public Pizza pizza;
    protected String orderId;
    protected String customerName;
    protected String orderStatus;

    // Constructor
    public Order(String orderId, String customerName, Pizza pizza) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public UserProfile getUser() {

        return user;
    }

    // Abstract method to display order details
    public abstract void displayOrderDetails();

    // Getter methods
    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    // Setter methods (optional, based on requirements)
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setState(OrderDelivered orderDelivered) {
        this.orderStatus = "Delivered";
    }

    public void setState(OrderProcessing orderProcessing) {
        this.orderStatus = "Processing";
    }

    public void setState(OrderCompleted orderCompleted) {
        this.orderStatus = "Completed";
    }

    public void setState(OrderCreated orderCreated) {
        this.orderStatus = "Created";
    }
}
