import java.util.ArrayList;
import java.util.List;

public class MovieDatabase_2 {
    private List<Movie> movies;

    public MovieDatabase_2() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        if (!movies.contains(movie)) {
            movies.add(movie);
            System.out.println("Movie added to the database: " + movie.getTitle());
        } else {
            System.out.println("Movie already exists in the database.");
        }
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
        System.out.println("Movie removed from the database: " + movie.getTitle());
    }

    public Movie getMovieDetails(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null; // Movie not found
    }

   
    public static void main(String[] args) {
        User user1 = new User("john_doe", "password123");
        User user2 = new User("jane_smith", "pass456");

        Movie movie1 = new Movie("Movie A", "null", 2023, 0);
        Movie movie2 = new Movie("Movie B", "null", 2022, 0);
        Movie movie3 = new Movie("Movie C", "null", 2021, 0);


        MovieDatabase_2 movieDatabase = new MovieDatabase_2();

        movieDatabase.addMovie(movie1);
        movieDatabase.addMovie(movie2);
        movieDatabase.addMovie(movie3);

        Movie retrievedMovie = movieDatabase.getMovieDetails("Movie B");
        if (retrievedMovie != null) {
            System.out.println("Retrieved Movie Details: " + retrievedMovie.getTitle() + " - " + retrievedMovie.getReleaseYear());
        } else {
            System.out.println("Movie not found in the database.");
        }

        movieDatabase.removeMovie(movie3);
    }
}
