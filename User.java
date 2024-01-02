import java.io.*;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 973704275480954654L;
    private String username;
    private String password;

    static ArrayList<User> userArrayList = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + "]";
    }

    public static void Register(String username, String password) {
        User newUser = new User(username, password);
        userArrayList.add(newUser);
    
        try {
            FileOutputStream out = new FileOutputStream("UserDatabase.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(userArrayList);
            oout.close(); // Make sure to close the stream after writing
    
            System.out.println("Account successfully created");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }    

    public static void LogIn(String username, String password) throws Exception {
        InputStream is = null;

        try {
            is = new FileInputStream("UserDatabase.txt");
            ObjectInputStream ois = new ObjectInputStream(is);

            ArrayList<User> std = (ArrayList<User>) ois.readObject();

            for (User s : std) {
                if (username.equals(s.getUsername()) && password.equals(s.getPassword())) {
                    System.out.println("Login successfully");
                    return;
                }
            }
            throw new Exception("Invalid username or password");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
