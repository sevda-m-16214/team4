import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase {
    public static void main(String[] args) {
        ArrayList<Movie> MovieDatabase = new ArrayList<Movie>();
        MovieDatabase.add(new Movie("Lilja 4ever", " Lukas Moodysson",
                2002, 109));
        MovieDatabase.add(new Movie("Girl Interrupted", "James Mangold",
                1999, 127));
        MovieDatabase.add(new Movie("The piano teacher", "Michael Haneke",
                2001, 131));
        MovieDatabase.add(new Movie("Manchester By The Sea", "Kenneth Lonergan",
                2016, 137));

        printDatabase(MovieDatabase);
    }

    static <Movie>  void printDatabase(ArrayList<Movie> MovieDatabase){
        Iterator it  = MovieDatabase.iterator();
        while (it.hasNext()) System.out.println("----\n" + it.next());
        System.out.println("-----------------------");
    }

}
