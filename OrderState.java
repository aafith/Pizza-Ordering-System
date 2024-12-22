public interface OrderState {
    void next(Order order);  // Move to the next state
    void prev(Order order);  // Move to the previous state
    void printStatus();      // Display the current state
}
