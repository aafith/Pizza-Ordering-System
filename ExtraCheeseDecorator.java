public class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addTopping(String topping) {
        pizza.addTopping(topping);
    }

    @Override
    public void displayPizzaDetails() {
        pizza.displayPizzaDetails();
        System.out.println(" -> Extra Cheese added!");
    }
}