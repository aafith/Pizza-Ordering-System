public class OrderValidationHandler extends OrderHandler {
    @Override
    public boolean handle(Order order) {
        System.out.println("Validating the order...");
        boolean isValid = true; // Replace with actual validation logic

        if (isValid) {
            System.out.println("Order validation passed.");
            if (nextHandler != null) {
                return nextHandler.handle(order); // Pass to the next handler
            }
            return true;
        } else {
            System.out.println("Order validation failed.");
            return false;
        }
    }
}
