public class OrderCompletionHandler extends OrderHandler {
    @Override
    public boolean handle(Order order) {
        System.out.println("Completing the order...");
        // Add the order to the system
        
        System.out.println("Order completed successfully!");
        order.displayOrderDetails();
        return true;
    }
}
