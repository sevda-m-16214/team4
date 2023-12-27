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

    public MovieDatabaseApp() {
        setTitle("Movie Database App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        
        getContentPane().setBackground(new Color(70, 70, 70));
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(139, 164, 67));
        JButton addMoviesButton = new JButton("Add Movies");
        JButton browseMoviesButton = new JButton("Browse Movies");

        mainPanel = new JPanel(new BorderLayout());

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

        headerPanel.add(addMoviesButton);
        headerPanel.add(browseMoviesButton);

        add(headerPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        movieDatabase = new ArrayList<>();

        setVisible(true);
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
        addButton.setBackground(new Color(142, 75, 174)); // #8E4BAE in RGB
       addButton.setOpaque(true);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMovie(titleField.getText(), directorField.getText(), releaseYearField.getText(), runningTimeField.getText());
                titleField.setText("");
                directorField.setText("");
                releaseYearField.setText("");
                runningTimeField.setText("");
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

    private void addMovie(String title, String director, String releaseYear, String runningTime) {
        try {
            int releaseYearInt = Integer.parseInt(releaseYear);
            int runningTimeInt = Integer.parseInt(runningTime);
            Movie newMovie = new Movie(title, director, releaseYearInt, runningTimeInt);
            movieDatabase.add(newMovie);

            if (mainPanel.getComponentCount() > 0) {
                browseMoviesPanel(); // Refresh the browse movies panel
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid release year and running time.");
        }
    }

    private void clearMainPanel() {
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MovieDatabaseApp();
        });
    }
}
