import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase {
    public static void main(String[] args) {
        ArrayList<Movie> MovieDatabase = new ArrayList<Movie>();
        MovieDatabase.add(new Movie("Movie1", "Director1", 2000, 123));
        MovieDatabase.add(new Movie("Movie2", "Director2", 2013, 345));

        printDatabase(MovieDatabase);

        MovieDatabase.remove(1);

        printDatabase(MovieDatabase);
    }

    static <Movie>  void printDatabase(ArrayList<Movie> MovieDatabase){
        Iterator it  = MovieDatabase.iterator();
        while (it.hasNext()) System.out.println(it.next());
        System.out.println("-----------------------");
    }

}
