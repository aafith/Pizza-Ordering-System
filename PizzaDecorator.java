public abstract class PizzaDecorator extends Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        super(pizza.size, pizza.crust, pizza.sauce, pizza.name, pizza.toppings);
        this.pizza = pizza;
    }

    public abstract void addTopping(String topping);
}