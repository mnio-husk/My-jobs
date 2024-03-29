package OpenCode.Webapp.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
//    private int numberAttempts;


    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public int getNumberAttempts() {
//        return numberAttempts;
//    }
//
//    public void setNumberAttempts(int numberAttempts) {
//        this.numberAttempts = numberAttempts;
//    }
}
