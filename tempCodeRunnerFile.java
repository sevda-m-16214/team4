import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieDatabaseApp extends JFrame {

    private JTextArea movieDisplayArea;
    private JComboBox<String> movieSelector;
    private JPanel mainPanel;
    private ArrayList<Movie> movieDatabase;
    private boolean isLoggedIn = false;

    public MovieDatabaseApp() {
        setTitle("Movie Database App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(70, 70, 70));
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        movieDatabase = new ArrayList<>();

        displayLoginPanel();

        setVisible(true);
    }

    private void displayLoginPanel() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to check login credentials
                // For simplicity, let's assume a hardcoded username and password
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("example") && password.equals("password")) {
                    isLoggedIn = true;
                    clearMainPanel();
                    displayMovieButtons();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });

        JButton registerButton = new JButton("Register if you're not registered");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMainPanel();
                displayRegistrationPanel();
            }
        });

        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(loginButton, BorderLayout.SOUTH);
        mainPanel.add(registerButton, BorderLayout.NORTH);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void displayRegistrationPanel() {
        JPanel registerPanel = new JPanel(new GridLayout(4, 2));
        JTextField newUsernameField = new JTextField();
        JPasswordField newPasswordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        registerPanel.add(new JLabel("New Username:"));
        registerPanel.add(newUsernameField);
        registerPanel.add(new JLabel("New Password:"));
        registerPanel.add(newPasswordField);
        registerPanel.add(new JLabel("Confirm Password:"));
        registerPanel.add(confirmPasswordField);

        JButton registerConfirmButton = new JButton("Register");
        registerConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle registration
                String newUsername = newUsernameField.getText();
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (newPassword.equals(confirmPassword)) {
                    // For simplicity, just display a success message for registration
                    JOptionPane.showMessageDialog(null, "Registration Successful!");
                    isLoggedIn = true;
                    clearMainPanel();
                    displayMovieButtons();
                    // You might want to handle the registration data here or in a separate function
                    // For example, you can create a User class and store the registered users
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords do not match!");
                }
            }
        });

        mainPanel.add(registerPanel, BorderLayout.CENTER);
        mainPanel.add(registerConfirmButton, BorderLayout.SOUTH);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void displayMovieButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addMoviesButton = new JButton("Add Movies");
        JButton browseMoviesButton = new JButton("Browse Movies");

        addMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMainPanel();
                addMoviesPanel();
            }
        });

        browseMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearMainPanel();
                browseMoviesPanel();
            }
        });

        buttonPanel.add(addMoviesButton);
        buttonPanel.add(browseMoviesButton);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void addMoviesPanel() {
        JPanel addMoviesPanel = new JPanel(new GridLayout(5, 2));
        JTextField titleField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField releaseYearField = new JTextField();
        JTextField runningTimeField = new JTextField();
        addMoviesPanel.add(new JLabel("Title:"));
        addMoviesPanel.add(titleField);
        addMoviesPanel.add(new JLabel("Director:"));
        addMoviesPanel.add(directorField);
        addMoviesPanel.add(new JLabel("Release Year:"));
        addMoviesPanel.add(releaseYearField);
        addMoviesPanel.add(new JLabel("Running Time (minutes):"));
        addMoviesPanel.add(runningTimeField);

        JButton addButton = new JButton("Add Movie");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement adding a movie to the database
                // Retrieve data from text fields and create a Movie object
                // Add the movie to the movieDatabase ArrayList
                // Refresh the display or take necessary actions
            }
        });

        mainPanel.add(addMoviesPanel, BorderLayout.CENTER);
        mainPanel.add(addButton, BorderLayout.SOUTH);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void browseMoviesPanel() {
        movieDisplayArea = new JTextArea(10, 40);
        movieDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(movieDisplayArea);

        // Populate movieDisplayArea with movies from movieDatabase
        populateMovieDisplay();

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void populateMovieDisplay() {
        StringBuilder displayText = new StringBuilder();
        for (Movie movie : movieDatabase) {
            displayText.append(movie.toString()).append("\n-----------------\n");
        }
        movieDisplayArea.setText(displayText.toString());
    }

    private void clearMainPanel() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MovieDatabaseApp();
            }
        });
    }
}
