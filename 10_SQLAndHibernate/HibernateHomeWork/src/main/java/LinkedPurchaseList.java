import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "LinkedPurchaseList")
@IdClass(LinkedPurchaseListKey.class)
public class LinkedPurchaseList {
//    @EmbeddedId
//    private LinkedPurchaseListKey id;

    @Id
    @Column(name = "student_id", insertable = false, updatable = false)
    private Student studentId;

    @Id
    @Column(name = "course_id", insertable = false, updatable = false)
    private Course courseId;

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
}
