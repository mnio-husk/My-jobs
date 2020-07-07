package response;

public class Task {
    private int id;
    private String name;
    private String dateCompletion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCompletion() {
        return dateCompletion;
    }

    public void setDateCompletion(String dateCompletion) {
        this.dateCompletion = dateCompletion;
    }
}
