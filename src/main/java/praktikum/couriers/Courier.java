package praktikum.couriers;

import java.util.Random;

public class Courier {
    private final String login;
    private final String password;
    private final String firstName;

    public Courier(String login, String password, String firstName){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }
    public static Courier random(){
        int suff = new Random().nextInt(1000000);
        return new Courier("Kolia" + suff, "12345q", "Nikolai1");
    }
    public static Courier withoutLogin(){
        return new Courier("", "12345q", "Nikolai1");
    }
    public static Courier withoutPassword(){
        int suff = new Random().nextInt(1000000);
        return new Courier("Kolia" + suff, "", "Nikolai1");
    }
    public static Courier withoutFirstName(){
        int suff = new Random().nextInt(1000000);
        return new Courier("Kolia" + suff, "12345q", "");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }
}
