import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Booklava extends JFrame {
    // Data management
    private UserManager userManager = new UserManager();
    private ListingManager listingManager = new ListingManager();
    
    // UI Components
    private JTabbedPane tabbedPane;
    private JPanel loginPanel;
    private JPanel registerPanel;
    private JPanel listingsPanel;
    private JPanel createListingPanel;
    
    // Shared components
    private JTextField currentUsernameField;
    private JLabel statusLabel;

    public Booklava() {
        setTitle("Booklava - Secondhand Marketplace");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create the tabbed interface
        tabbedPane = new JTabbedPane();
        
        // Create panels for each section
        createLoginPanel();
        createRegisterPanel();
        createListingsPanel();
        createListingFormPanel();
        
        // Only show login/register tabs initially
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Register", registerPanel);
        
        // Status bar at bottom
        statusLabel = new JLabel("Welcome to Booklava. Please login or register.");
        statusLabel.setBorder(BorderFactory.createEtchedBorder());
        
        add(tabbedPane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }
    
    private void createLoginPanel() {
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("Login to Booklava");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel userLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        
        JButton loginButton = new JButton("Login");
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        loginPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        loginPanel.add(userLabel, gbc);
        
        gbc.gridx = 1;
        loginPanel.add(usernameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(passLabel, gbc);
        
        gbc.gridx = 1;
        loginPanel.add(passwordField, gbc);
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(loginButton, gbc);
        
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            if (userManager.login(username, password)) {
                currentUsernameField = new JTextField(username);
                currentUsernameField.setEditable(false);
                switchToLoggedInView();
                statusLabel.setText("Logged in as: " + username);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void createRegisterPanel() {
        registerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("Register New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel userLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(15);
        
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);
        
        JButton registerButton = new JButton("Register");
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        registerPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        registerPanel.add(userLabel, gbc);
        
        gbc.gridx = 1;
        registerPanel.add(usernameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(passLabel, gbc);
        
        gbc.gridx = 1;
        registerPanel.add(passwordField, gbc);
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(registerButton, gbc);
        
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both username and password", "Registration Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (userManager.register(username, password)) {
                JOptionPane.showMessageDialog(this, "Registration successful! Please login.", "Success", JOptionPane.INFORMATION_MESSAGE);
                usernameField.setText("");
                passwordField.setText("");
                tabbedPane.setSelectedIndex(0); // Switch to login tab
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists", "Registration Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void createListingsPanel() {
        listingsPanel = new JPanel(new BorderLayout());
        
        // User info panel at top
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        userPanel.add(new JLabel("Logged in as:"));
        if (currentUsernameField == null) {
            currentUsernameField = new JTextField(10);
            currentUsernameField.setEditable(false);
        }
        userPanel.add(currentUsernameField);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> switchToLoggedOutView());
        userPanel.add(logoutButton);
        
        listingsPanel.add(userPanel, BorderLayout.NORTH);
        
        // Listings display
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> listingsList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listingsList);
        
        // Refresh button
        JButton refreshButton = new JButton("Refresh Listings");
        refreshButton.addActionListener(e -> {
            listModel.clear();
            for (Product product : listingManager.getProducts()) {
                listModel.addElement(product.toString());
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(refreshButton);
        
        listingsPanel.add(scrollPane, BorderLayout.CENTER);
        listingsPanel.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void createListingFormPanel() {
        createListingPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel titleLabel = new JLabel("Create New Listing");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel nameLabel = new JLabel("Product Name:");
        JTextField nameField = new JTextField(15);
        
        JLabel descLabel = new JLabel("Description:");
        JTextArea descArea = new JTextArea(3, 15);
        descArea.setLineWrap(true);
        JScrollPane descScroll = new JScrollPane(descArea);
        
        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(15);
        
        JLabel categoryLabel = new JLabel("Category:");
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Books", "Electronics", "Clothing", "Furniture", "Other"});
        
        JLabel conditionLabel = new JLabel("Condition:");
        JComboBox<String> conditionBox = new JComboBox<>(new String[]{"New", "Used - Like New", "Used - Good", "Used - Fair"});
        
        JButton submitButton = new JButton("Submit Listing");
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        createListingPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        createListingPanel.add(nameLabel, gbc);
        
        gbc.gridx = 1;
        createListingPanel.add(nameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        createListingPanel.add(descLabel, gbc);
        
        gbc.gridx = 1;
        createListingPanel.add(descScroll, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        createListingPanel.add(priceLabel, gbc);
        
        gbc.gridx = 1;
        createListingPanel.add(priceField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        createListingPanel.add(categoryLabel, gbc);
        
        gbc.gridx = 1;
        createListingPanel.add(categoryBox, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        createListingPanel.add(conditionLabel, gbc);
        
        gbc.gridx = 1;
        createListingPanel.add(conditionBox, gbc);
        
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 6;
        createListingPanel.add(submitButton, gbc);
        
        submitButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String description = descArea.getText();
                double price = Double.parseDouble(priceField.getText());
                String category = (String) categoryBox.getSelectedItem();
                String condition = (String) conditionBox.getSelectedItem();
                
                Product product = new Product(name, description, price, category, condition);
                listingManager.addProduct(product);
                
                JOptionPane.showMessageDialog(this, "Listing created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                descArea.setText("");
                priceField.setText("");
                
                // Switch to listings view and refresh
                tabbedPane.setSelectedIndex(2);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid price", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    private void switchToLoggedInView() {
        tabbedPane.removeAll();
        tabbedPane.addTab("Listings", listingsPanel);
        tabbedPane.addTab("Create Listing", createListingPanel);
        tabbedPane.addTab("Logout", loginPanel); // Keep login panel accessible for logout
    }
    
    private void switchToLoggedOutView() {
        currentUsernameField.setText("");
        tabbedPane.removeAll();
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Register", registerPanel);
        statusLabel.setText("Logged out successfully");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Booklava app = new Booklava();
            app.setVisible(true);
        });
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Product {
    private String name;
    private String description;
    private double price;
    private String category;
    private String condition;

    public Product(String name, String description, double price, String category, String condition) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (%s, %s) - %s", name, price, category, condition, 
                           description.length() > 30 ? description.substring(0, 30) + "..." : description);
    }
}

class UserManager {
    private HashMap<String, User> users = new HashMap<>();
    
    public boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, new User(username, password));
        return true;
    }
    
    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}

class ListingManager {
    private ArrayList<Product> products = new ArrayList<>();
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
}
