public class OrderCreated implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new OrderProcessing());
    }

    @Override
    public void prev(Order order) {
        System.out.println("The order is in its initial state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order created. Waiting for processing.");
    }
}
