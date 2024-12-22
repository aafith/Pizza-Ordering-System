public class OrderDelivered implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new OrderCompleted());
    }

    @Override
    public void prev(Order order) {
        order.setState(new OrderProcessing());
    }

    @Override
    public void printStatus() {
        System.out.println("Order delivered to the customer.");
    }
}
