import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class User{
    private String username;
    private String password;

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

    public static void SignUp(User test) {
        Scanner myObj = new Scanner(System.in);
        //get user information
        System.out.println("Create a username: ");
        test.setUsername(myObj.nextLine());
        System.out.println("Create a password: ");
        test.setPassword(myObj.nextLine());
        try {
            // create an ObjectOutputStream
            FileOutputStream out = new FileOutputStream("UserDatabase.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // write user information into file
            oout.writeObject(test);
            System.out.println("Account successfully created");

            // close the file
            oout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void SignIn(User test){
        Scanner myObj = new Scanner(System.in);

        //get user information
        System.out.println("Insert your username: ");
        test.setUsername(myObj.nextLine());
        System.out.println("Insert your password: ");
        test.setPassword(myObj.nextLine());
        try {
            FileInputStream fileInputStream = new FileInputStream("UserDatabase.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            User temp = (User) objectInputStream.readObject();
            if(test.username.equals(temp.username) && test.password.equals(temp.password)){
                System.out.println("Login successful");
            }
            else {
                System.out.println("Wrong username or password. Try again");
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


