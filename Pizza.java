import java.util.List;

public class Pizza {
    protected String size;
    protected String crust;
    protected String sauce;
    protected String name;
    protected List<String> toppings;

    // Constructor
    public Pizza(String size, String crust, String sauce, String name, List<String> toppings ) {
        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.name = name;
        this.toppings = toppings;
    }

    // Display pizza details
    public void displayPizzaDetails() {
        System.out.println("\n- " + name + "(" + "Size: " + size + ", Crust: " + crust + ", Sauce: " + sauce + ", Toppings: " + toppings + ", Amount: " + calculateOrderAmount() + ")");
    }

    public String getName() {
        return name;
    }

    public double calculateOrderAmount() {
        // Example implementation
        double basePrice = 150.0;
        double sizePrice = 0.0;
        double crustPrice = 0.0;
        double toppingsPrice = 0.0;

        // Calculate size price
        switch (size.toLowerCase()) {
            case "small":
                sizePrice = 500.0;
                break;
            case "medium":
                sizePrice = 700.0;
                break;
            case "large":
                sizePrice = 900.0;
                break;
        }

        // Calculate crust price
        switch (crust.toLowerCase()) {
            case "thin":
                crustPrice = 200.0;
                break;
            case "thick":
                crustPrice = 300.0;
                break;
        }

        // Calculate toppings price
        toppingsPrice = toppings.size() * 150.0;


        double totalAmount = basePrice + sizePrice + crustPrice + toppingsPrice;
        return totalAmount;
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }
}
