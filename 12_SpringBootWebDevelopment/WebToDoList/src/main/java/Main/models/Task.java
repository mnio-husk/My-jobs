package Main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String dateComplected;

    public Task() {
    }

    public Task(String name, String dateComplected) {
        this.name = name;
        this.dateComplected = dateComplected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateComplected() {
        return dateComplected;
    }

    public void setDateComplected(String dateComplected) {
        this.dateComplected = dateComplected;
    }
}
