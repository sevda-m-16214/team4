import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase {
    public static void main(String[] args) {
        ArrayList<Movie> MovieDatabase = new ArrayList<Movie>();
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
    }

    static void printMovie(ArrayList<Movie> MovieDatabase, int index){ //prints one selected Movie from the ArrayLiat
        System.out.println("----------------------------------------------\n" + MovieDatabase.get(index).toString()
                + "\n----------------------------------------------");
    }


    static void printDatabase(ArrayList<Movie> MovieDatabase){ //prints all the Movies in the ArrayList
        Iterator it  = MovieDatabase.iterator();
        while (it.hasNext()){
            System.out.println("----\n" + it.next());
        }
        System.out.println("-----------------------");
    }

}
