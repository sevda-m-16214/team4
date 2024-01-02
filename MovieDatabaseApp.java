import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieDatabaseApp extends JFrame {

    private ArrayList<Movie> movieDatabase;
    private boolean isLoggedIn = false;
    private JPanel headerPanel;
    private JPanel contentPanel;

    public MovieDatabaseApp() {
        setTitle("Movie Database App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.decode("#A365AD"));
        movieDatabase = new ArrayList<>();

        displayLoginRegisterWindow();
    }

    private void displayLoginRegisterWindow() {
        JFrame loginRegisterFrame = new JFrame("Login/Register");
        loginRegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginRegisterFrame.setSize(300, 400);
        loginRegisterFrame.setLayout(new BorderLayout());
    
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.decode("#A365AD"));
    
        JLabel titleLabel = new JLabel("Movie Database App");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        loginRegisterFrame.add(titlePanel, BorderLayout.NORTH);
    
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.setBackground(Color.decode("#8BA443"));
         loginPanel.setForeground(Color.WHITE);

         JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel emptyPanel1 = new JPanel(new FlowLayout()); // Empty panel for spacing
        emptyPanel1.setOpaque(false);

        JPanel emptyPanel2 = new JPanel(new FlowLayout()); // Empty panel for spacing
        emptyPanel2.setOpaque(false);
    
        loginPanel.add(new JLabel("Username:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
    
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 50));
    
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
    
                if (username.equals("example") && password.equals("password")) {
                    isLoggedIn = true;
                    loginRegisterFrame.dispose();
                    openMovieActionsWindow();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!");
                }
            }
        });
    
        JButton registerButton = new JButton("Register");
        // Set register button's size to match login button
        registerButton.setPreferredSize(loginButton.getPreferredSize());
        registerButton.setBackground(Color.decode("#464646"));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Registration Feature Not Implemented");
            }
        });
    
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.decode("#A365AD"));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
    
        loginRegisterFrame.add(loginPanel, BorderLayout.CENTER);
        loginRegisterFrame.add(buttonPanel, BorderLayout.SOUTH);
    
        loginRegisterFrame.setVisible(true);
    }

    public class Movie {
        private String title;
        private String director;
        private int releaseYear;
        private int runningTime;
    
        public Movie(String title, String director, int releaseYear, int runningTime) {
            this.title = title;
            this.director = director;
            this.releaseYear = releaseYear;
            this.runningTime = runningTime;
        }
    
        public String getTitle() {
            return title;
        }
    
        public String getDirector() {
            return director;
        }
    
        public int getReleaseYear() {
            return releaseYear;
        }
    
        public int getRunningTime() {
            return runningTime;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    
        public void setDirector(String director) {
            this.director = director;
        }
    
        public void setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
        }
    
        public void setRunningTime(int runningTime) {
            this.runningTime = runningTime;
        }
    
        @Override
        public String toString() {
            return "Title: " + title + ", Director: " + director + ", Release Year: " + releaseYear + ", Running Time: " + runningTime + " minutes";
        }
    }
    

    private void openMovieActionsWindow() {
        JFrame movieActionsFrame = new JFrame("Movie Actions");
        movieActionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        movieActionsFrame.setSize(800, 600);
        movieActionsFrame.setBackground(Color.decode("#A365AD"));
        movieActionsFrame.setLayout(new BorderLayout());

        headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addMoviesButton = new JButton("Add Movies");
        JButton browseMoviesButton = new JButton("Browse Movies");

        addMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearContentPanel();
                displayAddMovies();
            }
        });

        browseMoviesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearContentPanel();
                displayBrowseMovies();
            }
        });

        headerPanel.add(addMoviesButton);
        headerPanel.add(browseMoviesButton);
        headerPanel.setBackground(Color.decode("#8BA443"));

        movieActionsFrame.add(headerPanel, BorderLayout.NORTH);
        contentPanel = new JPanel();
        movieActionsFrame.add(contentPanel, BorderLayout.CENTER);

        movieActionsFrame.setVisible(true);
    }

    private void displayAddMovies() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout()); // Set layout to BorderLayout

        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBackground(Color.decode("#464646"));

        JTextField titleField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField releaseYearField = new JTextField();
        JTextField runningTimeField = new JTextField();

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setForeground(Color.WHITE); // Set text color for the Title label
        formPanel.add(titleLabel);
        formPanel.add(titleField);

        JLabel directorLabel = new JLabel("Director:");
        directorLabel.setForeground(Color.WHITE); // Set text color for the Director label
        formPanel.add(directorLabel);
        formPanel.add(directorField);

        JLabel releaseYearLabel = new JLabel("Release Year:");
        releaseYearLabel.setForeground(Color.WHITE); // Set text color for the Release Year label
        formPanel.add(releaseYearLabel);
        formPanel.add(releaseYearField);

        JLabel runningTimeLabel = new JLabel("Running Time (minutes):");
        runningTimeLabel.setForeground(Color.WHITE); // Set text color for the Running Time label
        formPanel.add(runningTimeLabel);
        formPanel.add(runningTimeField);

        contentPanel.add(formPanel, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Movie");
        addButton.setPreferredSize(new Dimension(contentPanel.getWidth(), 40)); 
        addButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        addButton.setBackground(Color.decode("#8BA443")); 
        addButton.setForeground(Color.WHITE);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String director = directorField.getText();
                int releaseYear = Integer.parseInt(releaseYearField.getText());
                int runningTime = Integer.parseInt(runningTimeField.getText());

                Movie newMovie = new Movie(title, director, releaseYear, runningTime);
                movieDatabase.add(newMovie);

                JOptionPane.showMessageDialog(null, "Movie added successfully!");
            }
        });

        contentPanel.add(addButton, BorderLayout.SOUTH);

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void displayBrowseMovies() {
        contentPanel.removeAll();
        contentPanel.setLayout(new BorderLayout());
    
        JPanel controlsPanel = new JPanel(new FlowLayout());
    
        String[] sortOptions = {"Title", "Director", "Release Year", "Running Time"};
        JComboBox<String> sortCriteriaDropdown = new JComboBox<>(sortOptions);
        controlsPanel.add(new JLabel("Sort By:"));
        controlsPanel.add(sortCriteriaDropdown);
    
        JButton sortButton = new JButton("Sort");
        controlsPanel.add(sortButton);
    
        JTextArea movieDisplayArea = new JTextArea(10, 40);
        movieDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(movieDisplayArea);
    
        StringBuilder displayText = new StringBuilder();
        for (Movie movie : movieDatabase) {
            displayText.append(movie.toString()).append("\n-----------------\n");
        }
        movieDisplayArea.setText(displayText.toString());
    
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCriteria = (String) sortCriteriaDropdown.getSelectedItem();
                sortMovies(selectedCriteria);
            }
        });
    
        contentPanel.add(controlsPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
    
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    private void sortMovies(String criteria) {
        switch (criteria) {
            case "Title":
                movieDatabase.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
                break;
            case "Director":
                movieDatabase.sort((m1, m2) -> m1.getDirector().compareToIgnoreCase(m2.getDirector()));
                break;
            case "Release Year":
                movieDatabase.sort((m1, m2) -> Integer.compare(m1.getReleaseYear(), m2.getReleaseYear()));
                break;
            case "Running Time":
                movieDatabase.sort((m1, m2) -> Integer.compare(m1.getRunningTime(), m2.getRunningTime()));
                break;
            default:
                break;
        }
    
        displayBrowseMovies(); 
    }
    

    private void clearContentPanel() {
        if (contentPanel != null) {
            contentPanel.removeAll();
            contentPanel.revalidate();
            contentPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MovieDatabaseApp();
            }
        });
    }
}
