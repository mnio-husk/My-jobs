import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    @Column(name = "registration_date", columnDefinition = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable (name = "Subscriptions",
    joinColumns = {@JoinColumn (name = "student_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Course> courses;


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
