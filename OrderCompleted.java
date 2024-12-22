public class OrderCompleted implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("The order is already completed.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new OrderDelivered());
    }

    @Override
    public void printStatus() {
        System.out.println("Order completed. Thank you!");
    }
}
