import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    // Fields
    private String name;
    private String username;
    private String password;
    private List<Pizza> favoritePizzas;
    private int loyaltyPoints;

    // Constructor
    public UserProfile(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.favoritePizzas = new ArrayList<>();
        this.loyaltyPoints = 0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Pizza> getFavoritePizzas() {
        return favoritePizzas;
    }

    public void addFavoritePizza(Pizza pizza) {
        this.favoritePizzas.add(pizza);
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public void deductLoyaltyPoints(int points) {
        if (points > loyaltyPoints) {
            throw new IllegalArgumentException("Not enough loyalty points");
        }
        this.loyaltyPoints -= points;
    }
}
