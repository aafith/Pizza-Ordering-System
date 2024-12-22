import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, UserProfile> userDatabase = new HashMap<String, UserProfile>();
    private static UserProfile currentUser = null;
    private static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\n--------------------------");
        System.out.println("      THE PIZZA SHOP      ");
        System.out.println("--------------------------");
        while (true) {
            showMainMenu();
        }
    }

    // Main Menu
    private static void showMainMenu() {
        System.out.println("\n1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Register a new user
    private static void register() {
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userDatabase.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return;
        }

        UserProfile newUser = new UserProfile(name, username, password);
        userDatabase.put(username, newUser);
        System.out.println("Registration successful. You can now log in.");
    }

    // Login a user
    private static void login() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        UserProfile user = userDatabase.get(username);
        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Invalid username or password.");
            return;
        }

        currentUser = user;
        System.out.println("Login successful!");
        showUserMenu();
    }

    // User Menu after successful login
    private static void showUserMenu() {
        while (true) {
            System.out.println("\n--------------------------");
            System.out.println("    Welcome, " + currentUser.getName());
            System.out.println("--------------------------");
            System.out.println("\n1. Create a Pizza");
            System.out.println("2. View Favorite Pizzas");
            System.out.println("3. View Loyalty Points");
            System.out.println("4. View Orders");
            System.out.println("5. Log Out");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createPizza();
                    break;
                case 2:
                    viewFavorites();
                    break;
                case 3:
                    viewLoyaltyPoints();
                    break;
                case 4:
                    viewOrders();
                    break;
                case 5:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Pizza creation with Builder Pattern
    private static void createPizza() {
        System.out.println("\nCreating a custom pizza...");

        // Get pizza size choice
        System.out.println("Choose a size: ");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.print("Enter your choice (1-3): ");
        int sizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String size = "Medium"; // Default size

        switch (sizeChoice) {
            case 1:
                size = "Small";
                break;
            case 2:
                size = "Medium";
                break;
            case 3:
                size = "Large";
                break;
            default:
                System.out.println("Invalid choice, defaulting to Medium.");
        }

        // Get pizza crust choice
        System.out.println("\nChoose a crust: ");
        System.out.println("1. Thin Crust");
        System.out.println("2. Thick Crust");
        System.out.println("3. Gluten-Free");
        System.out.print("Enter your choice (1-3): ");
        int crustChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String crust = "Thin Crust"; // Default crust

        switch (crustChoice) {
            case 1:
                crust = "Thin Crust";
                break;
            case 2:
                crust = "Thick Crust";
                break;
            case 3:
                crust = "Gluten-Free";
                break;
            default:
                System.out.println("Invalid choice, defaulting to Thin Crust.");
        }

        // Get pizza sauce choice
        System.out.println("\nChoose a sauce: ");
        System.out.println("1. Tomato Sauce");
        System.out.println("2. Barbecue Sauce");
        System.out.println("3. Alfredo Sauce");
        System.out.print("Enter your choice (1-3): ");
        int sauceChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String sauce = "Tomato Sauce"; // Default sauce

        switch (sauceChoice) {
            case 1:
                sauce = "Tomato Sauce";
                break;
            case 2:
                sauce = "Barbecue Sauce";
                break;
            case 3:
                sauce = "Alfredo Sauce";
                break;
            default:
                System.out.println("Invalid choice, defaulting to Tomato Sauce.");
        }

        // Get pizza topping choices
        System.out.println("\nChoose toppings:");
        System.out.println("1. Cheese");
        System.out.println("2. Mushrooms");
        System.out.println("3. Pepperoni");
        System.out.println("4. Olives");
        System.out.println("5. Onions");
        System.out.print("Enter your choices (comma separated): ");
        String toppingsInput = scanner.nextLine();
        List<String> toppings = new ArrayList<>();

        for (String topping : toppingsInput.split(",")) {
            switch (topping.trim()) {
                case "1":
                    toppings.add("Cheese");
                    break;
                case "2":
                    toppings.add("Mushrooms");
                    break;
                case "3":
                    toppings.add("Pepperoni");
                    break;
                case "4":
                    toppings.add("Olives");
                    break;
                case "5":
                    toppings.add("Onions");
                    break;
                default:
                    System.out.println("Invalid topping choice: " + topping);
            }
        }

        // create pizza name customer
        System.out.print("Enter a name for your pizza or press Enter to skip: ");
        String pizzaName = scanner.nextLine();

        // Build the pizza with the selected options
        Pizza pizza = new PizzaBuilder()
                .setSize(size)
                .setCrust(crust)
                .setSauce(sauce)
                .setName(pizzaName.isEmpty() ? "Custom Pizza" : pizzaName) // Default name
                .setToppings(toppings)
                .build();

        // Add extra cheese if user wants
        System.out.print("Do you want to add extra cheese? (yes/no): ");
        String extraCheeseResponse = scanner.nextLine();
        if (extraCheeseResponse.equalsIgnoreCase("yes")) {
            pizza = new ExtraCheeseDecorator(pizza);
        }

        pizza.displayPizzaDetails();

        // Add pizza to favorites if user wants
        System.out.print("Do you want to save this pizza as your favorite? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            currentUser.addFavoritePizza(pizza);
            System.out.println("Pizza added to favorites! Loyalty points rewarded.");
            currentUser.addLoyaltyPoints(100); // Reward loyalty points for creating a pizza
        }

        System.out.print("\nDo you want to place an order for this pizza? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            placeOrder(pizza);
        }
    }

    // View Favorite Pizzas
    private static void viewFavorites() {
        List<Pizza> favoritePizzas = currentUser.getFavoritePizzas();
        if (favoritePizzas.isEmpty()) {
            System.out.println("No favorite pizzas yet.");
            return;
        }

        for (int i = 0; i < favoritePizzas.size(); i++) {
            System.out.println((i + 1) + ". " + favoritePizzas.get(i).getName());
        }
        System.out.print("Select a pizza to view details or 0 to go back: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= favoritePizzas.size()) {
            Pizza selectedPizza = favoritePizzas.get(choice - 1);
            selectedPizza.displayPizzaDetails();
            System.out.print("Do you want to order this pizza? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                placeOrder(selectedPizza);
            }
        }
    }

    // View Loyalty Points
    private static void viewLoyaltyPoints() {
        System.out.println("Your current loyalty points: " + currentUser.getLoyaltyPoints());
    }

    // View Orders
    private static void viewOrders() {
        if (orderList.isEmpty()) {
            System.out.println("No orders have been placed yet.");
            return;
        }

        for (Order order : orderList) {
            order.displayOrderDetails();
        }
    }

    private static void placeOrder(Pizza pizza) {
        // Create the handler chain
        OrderHandler validationHandler = new OrderValidationHandler();
        OrderHandler paymentHandler = new PaymentValidationHandler();
        OrderHandler completionHandler = new OrderCompletionHandler();
    
        validationHandler.setNextHandler(paymentHandler);
        paymentHandler.setNextHandler(completionHandler);

        String customerName = currentUser.getName();
        String orderId = UUID.randomUUID().toString(); // Generate a unique order ID
    
        // Input: Order type
        System.out.println("\nChoose an order type: ");
        System.out.println("1. Pickup");
        System.out.println("2. Delivery");
        System.out.print("Enter your choice (1-2): ");
        int orderTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline


        String orderType;
        
        if (orderTypeChoice == 1) {
            orderType = "Pickup";
        } else if (orderTypeChoice == 2) {
            orderType = "Delivery";
        } else {
            System.out.println("Invalid choice. Order not placed.");
            return;
        }

        // payment method
        System.out.println("\nChoose a payment method: ");
        System.out.println("1. Card");
        System.out.println("2. Cash");
        System.out.print("Enter your choice (1-2): ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine();

        PaymentStrategy paymentStrategy = paymentChoice == 1 ? new CreditCardPayment() : new DigitalWalletPayment();

        // pay amount Enter
        System.out.print("Enter the amount to pay: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        paymentStrategy.pay(amount);

        // discount
        System.out.println("\n---- Available Discounts ----");
        System.out.println("1. Promo Code: PIZZA10 (10% off)");

        System.out.print("\nDo you have a promo code? (yes/no): ");
        String promoResponse = scanner.nextLine();
        final double promoDiscount; // Initialize discount variable
        double totalAmount = pizza.calculateOrderAmount();
        
        DiscountStrategy discountStrategy;

        if (promoResponse.equalsIgnoreCase("yes")) {
            System.out.print("Enter promo code: ");
            String promoCode = scanner.nextLine();
            discountStrategy = new PromoCodeDiscount(promoCode); // Use PromoCodeDiscount
        } else if (promoResponse.equalsIgnoreCase("no")) {
            discountStrategy = new NoDiscount(); // Use NoDiscount
        } else {
            System.out.println("Invalid input. No promo code applied.");
            discountStrategy = new NoDiscount();
        }

        // Apply the discount strategy
        DiscountContext discountContext = new DiscountContext(discountStrategy);
        promoDiscount = discountContext.calculateDiscount(totalAmount);

        // Simulate feedback
        System.out.print("\nLeave feedback for your order: ");
        String feedback = scanner.nextLine();
        Command feedbackCommand = new FeedbackCommand(feedback);
        feedbackCommand.execute();

        currentUser.addLoyaltyPoints(100);
        System.out.println("Loyalty points added! Total: " + currentUser.getLoyaltyPoints());
        
        Order newOrder = new Order(orderId, customerName, pizza) {
            @Override
            public void displayOrderDetails() {
                System.out.println("\n--------------------------");
                System.out.println("       ORDER DETAILS       ");
                System.out.println("--------------------------");
                System.out.println("Order ID: " + orderId);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Order Type: " + orderType);
                System.out.println("Feedback: " + feedback);
                System.out.println("Paid: LKR" + amount);
                System.out.println("Discount: LKR" + promoDiscount);
                System.out.println("--------------------------");
                System.out.println("Total: LKR" + (totalAmount - promoDiscount));
                System.out.println("--------------------------");
                getPizza().displayPizzaDetails();
                System.out.println("--------------------------");
            }
        };
    
        // Process the order through the handler chain
        boolean orderSuccess = validationHandler.handle(newOrder);
    
        if (orderSuccess) {
            orderList.add(newOrder);
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order processing failed. Please try again.");
        }
    }

}
