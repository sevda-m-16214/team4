import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class User implements Serializable{
    @Serial
    private static final long serialVersionUID = 973704275480954654L;
    private String username;
    private String password;

    static ArrayList <User> userArrayList = new ArrayList<>(); //initialize an Array List of Users

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }  

    public User(){
        String username;
        String password;
    }

    public String getUsername(){
        return username;
    }
   
    public void setUsername(String username){
        this.username=username;
    }


    public String getPassword(){
        return password;
    }


    public void setPassword(String password){
        this.password=password;
    }


    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }

    public static void Register(){
        User test = new User();
        Scanner myObj = new Scanner(System.in);

        //get user information
        System.out.println("Create a username: ");
        test.setUsername(myObj.nextLine());
        System.out.println("Create a password: ");
        test.setPassword(myObj.nextLine());

        //add username to userbase ArrayList
        userArrayList.add(test);

        try {
            // create an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("UserDatabase.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);
            // write user information into file
            oout.writeObject(userArrayList);
            System.out.println("Account successfully created");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void LogIn(){
        InputStream is = null;
        Scanner myObj = new Scanner(System.in);
        User test = new User();

        //get user information
        System.out.println("Insert your username: ");
        test.setUsername(myObj.nextLine());
        System.out.println("Insert your password: ");
        test.setPassword(myObj.nextLine());

        try { //create an ObjectInputStream
            is = new FileInputStream("UserDatabase.txt");
            ObjectInputStream ois = new ObjectInputStream(is);
            //read information from the file
            ArrayList<User> std = (ArrayList<User>) ois.readObject();
            //compare info given from a user to logs in database
            for (User s:
                 std) {
                if(test.username.equals(s.getUsername()) && test.password.equals(s.getPassword())){
                    System.out.println("Login successfully");
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}


