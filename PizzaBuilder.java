import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private String name;
    private String size;
    private String crust;
    private String sauce;
    private List<String> toppings;

    public PizzaBuilder() {
        this.toppings = new ArrayList<>();
    }

    public PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }
    

    public PizzaBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    public PizzaBuilder setToppings(List<String> toppings) {
        this.toppings = toppings;
        return this;
    }
    
    public Pizza build() {
        return new Pizza(size, crust, sauce, name, toppings);
    }

    
}
