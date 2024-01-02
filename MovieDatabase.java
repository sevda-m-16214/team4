import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase extends User {

    static ArrayList<Movie> MovieDatabase = new ArrayList<Movie>();

    public static void printMovie(ArrayList<Movie> MovieDatabase, int index){ //prints one selected Movie from the ArrayLiat
        System.out.println("----------------------------------------------\n" + MovieDatabase.get(index).toString()
                + "\n----------------------------------------------");
    }


    public static void printDatabase(ArrayList<Movie> MovieDatabase){ //prints all the Movies in the ArrayList
        Iterator it  = MovieDatabase.iterator();
        while (it.hasNext()){
            System.out.println("----\n" + it.next());
        }
        System.out.println("-----------------------");
    }

}
