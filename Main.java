import java.io.*;
import java.util.ArrayList;

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


            printMovie(MovieDatabase, 2);
            printDatabase(MovieDatabase);

            User test1 = new User("Test1", "12345");
            User test2 = new User("Test2", "54321");
            userArrayList.add(test1);
            userArrayList.add(test2);

        }
}
