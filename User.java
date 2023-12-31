import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class User {
    private String username;
    private String password;

    File UserDatabase = new File("\\team4\\inputs");


    public User(String username, String password){
    setUsername(username);
    setPassword(password);;
    }  


    public String getUsername(String username){
        return username;
    }
   
    public void setUsername(String username){
        this.username=username;
    }


    public String getPassword(String password){
        return password;
    }


    public void setPassword(String password){
        this.password=password;
    }


    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }



}


