import java.util.ArrayList;
import java.io.FileWriter;
public class Main extends MovieDatabase{
     static ArrayList<Movie> MovieDatabase = new ArrayList<Movie>();

    public static void main(String[] args) {

        MovieDatabase.add(new Movie("Lilja 4ever", " Lukas Moodysson",
                2002, 109));
        MovieDatabase.add(new Movie("Girl Interrupted", "James Mangold",
                1999, 127));
        MovieDatabase.add(new Movie("The Piano Teacher", "Michael Haneke",
                2001, 131));
        MovieDatabase.add(new Movie("Manchester By The Sea", "Kenneth Lonergan",
                2016, 137));

        User test = new User("Test", "12345");

        User test2 = new User("Test2", "54321");

        try {
            // Creates a FileWriter
            FileWriter UserDatabase
                    = new FileWriter("UserDatabase.txt");

            // Writes user to the file
            UserDatabase.write(test.toString());
            UserDatabase.write(test2.toString());


            // Closes the writer
            UserDatabase.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }

        //printMovie(MovieDatabase, 2);
        //printDatabase(MovieDatabase);
    }
}
