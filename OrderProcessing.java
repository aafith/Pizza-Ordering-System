public class OrderProcessing implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new OrderDelivered());
    }

    @Override
    public void prev(Order order) {
        order.setState(new OrderCreated());
    }

    @Override
    public void printStatus() {
        System.out.println("Order is being processed.");
    }
}
