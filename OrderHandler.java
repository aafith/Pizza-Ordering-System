public abstract class OrderHandler {
    protected OrderHandler nextHandler;

    // Sets the next handler in the chain
    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Abstract method to handle the order
    public abstract boolean handle(Order order);
}
