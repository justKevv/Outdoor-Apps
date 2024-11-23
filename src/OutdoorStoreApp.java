import Controllers.CategoryController;
import Models.Category;
import Views.CategoryView;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OutdoorStoreApp extends JFrame {
    // DB Attributes
    private Connection dbConnection;

    // Main Attributes
    private JTabbedPane mainTabPane;
    private JPanel mainPanel;
    private JPanel salesPanel;
    private JPanel itemsPanel;
    private JPanel categoriesPanel;
    private JPanel revenuePanel;

    // Categories Tab Attributes
    private JLabel categoryFormTitle;
    private JLabel categoryNameLabel;
    private JTextField categoryNameField;
    private JTextField categoryIdField;
    private JButton submitCategoryButton;
    private JScrollPane categoriesTableSP;
    private JTable categoriesTable;
    private CategoryView categoryView;
    private CategoryController categoryController;

    public OutdoorStoreApp() {
        // Initialize database connection
        this.databaseConnection();

        // Initialize categories tab needs components
        this.categoryView = new CategoryView(categoryFormTitle, categoryNameLabel, categoryNameField, categoryIdField, submitCategoryButton, categoriesTableSP, categoriesTable);
        this.categoryController = new CategoryController(this.categoryView, new Category(this.dbConnection));
        this.categoryView.setCategoryController(this.categoryController);

        // Initialize setup GUI components
        this.initFont();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            // Set app frame
            OutdoorStoreApp outdoorStoreAppFrame = new OutdoorStoreApp();
            outdoorStoreAppFrame.setContentPane(outdoorStoreAppFrame.mainPanel);
            outdoorStoreAppFrame.setTitle("Outdoor Store Desktop");
            outdoorStoreAppFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            outdoorStoreAppFrame.setLocationRelativeTo(null);
            outdoorStoreAppFrame.setVisible(true);
            outdoorStoreAppFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }

    private void initFont() {
        this.categoryFormTitle.setFont(new Font("", Font.PLAIN, 14));
    }

    private void databaseConnection() {
        // Database connection data
        String dbUrl = "jdbc:mysql://outdoor-quiz-pbo.e.aivencloud.com:10813/outdoor";
        String dbUsername = "avnadmin";
        String dbPassword = "AVNS_nwGISMSemuzhPlsnkUf";

        // Connect to database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            this.dbConnection = connection;

            if (connection != null) {
                System.out.println("Database connection successfully!");
            } else {
                System.out.println("Database connection failed!");
            }

        } catch (ClassNotFoundException error) {
            System.err.println("JDBC Driver not found: " + error.getMessage());
        } catch (SQLException error) {
            System.err.println("Database connection error: " + error.getMessage());
        }
    }
}
