

public class User {
    private String username;
    private String password;

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


}
