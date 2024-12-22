public class PaymentValidationHandler extends OrderHandler {
    @Override
    public boolean handle(Order order) {
        System.out.println("Validating payment...");
        boolean paymentValid = true; // Replace with actual payment validation logic

        if (paymentValid) {
            System.out.println("Payment validation successful.");
            if (nextHandler != null) {
                return nextHandler.handle(order); // Pass to the next handler
            }
            return true;
        } else {
            System.out.println("Payment validation failed.");
            return false;
        }
    }
}
