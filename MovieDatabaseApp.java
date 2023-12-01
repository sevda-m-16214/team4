import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MovieDatabaseApp extends JFrame {
    
    private JTextField titleField, directorField, releaseYearField, runningTimeField;
    private JTextArea movieDisplayArea;
    private JComboBox<String> movieSelector;
    private ArrayList<Movie> movieDatabase;

    public MovieDatabaseApp() {
        setTitle("Movie Database App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        JPanel entryPanel = new JPanel(new GridLayout(5, 2));
        titleField = new JTextField();
        directorField = new JTextField();
        releaseYearField = new JTextField();
        runningTimeField = new JTextField();
        entryPanel.add(new JLabel("Title:"));
        entryPanel.add(titleField);
        entryPanel.add(new JLabel("Director:"));
        entryPanel.add(directorField);
        entryPanel.add(new JLabel("Release Year:"));
        entryPanel.add(releaseYearField);
        entryPanel.add(new JLabel("Running Time (minutes):"));
        entryPanel.add(runningTimeField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Movie");
        JButton displayButton = new JButton("Display Movies");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        JPanel displayPanel = new JPanel(new BorderLayout());
        movieDisplayArea = new JTextArea(10, 40);
        movieDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(movieDisplayArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        movieSelector = new JComboBox<>();
        displayPanel.add(movieSelector, BorderLayout.SOUTH);

        add(entryPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.SOUTH);

        movieDatabase = new ArrayList<>();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String director = directorField.getText();
                int releaseYear = Integer.parseInt(releaseYearField.getText());
                int runningTime = Integer.parseInt(runningTimeField.getText());

                Movie newMovie = new Movie(title, director, releaseYear, runningTime);
                movieDatabase.add(newMovie);
                titleField.setText("");
                directorField.setText("");
                releaseYearField.setText("");
                runningTimeField.setText("");
                populateMovieSelector();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMovies();
            }
        });

        movieSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = movieSelector.getSelectedIndex();
                if (selectedIndex >= 0) {
                    displaySelectedMovie(selectedIndex);
                }
            }
        });

        setVisible(true);
    }

    private void populateMovieSelector() {
        movieSelector.removeAllItems();
        for (Movie movie : movieDatabase) {
            movieSelector.addItem(movie.getTitle());
        }
    }

    private void displayMovies() {
        StringBuilder displayText = new StringBuilder();
        for (Movie movie : movieDatabase) {
            displayText.append(movie.toString()).append("\n-----------------\n");
        }
        movieDisplayArea.setText(displayText.toString());
    }

    private void displaySelectedMovie(int index) {
        movieDisplayArea.setText(movieDatabase.get(index).toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MovieDatabaseApp();
        });
    }
}
