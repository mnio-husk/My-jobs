
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;


public class Main {
    private static final String  url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
    private static final String pass = "12344321Qmnio";
    private static final String user = "root";
    public static void main(String[] args) throws SQLException {

//        ResultSet resultSet = statement(url,user,pass).executeQuery("select courses.id as course_id, students.id as student_id from subscriptions\n" +
//                "join Courses on courses.id = subscriptions.course_id\n" +
//                "join Students on students.id = subscriptions.student_id");
//
//        while (resultSet.next()){
//            String see = resultSet.getString("course_name");
//            String soo = resultSet.getString("student_name");
//            System.out.println("курс: " + see);
//            System.out.println("студенты: " + soo);
//        }

//        Session session = valueSessionFactory().openSession();
//       String hql = "select courses.id as course_id, students.id as student_id from subscriptions\n" +
//                "join Courses on courses.id = subscriptions.course_id\n" +
//                "join Students on students.id = subscriptions.student_id";
//        Query query = session.createQuery(hql);
//        List<Course> coursesId = query.list();
//        System.out.println(coursesId);
//
//
//        valueSessionFactory().close();


        Session session = valueSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

        String query = "From " + Purchaselist.class.getSimpleName();
        List<Purchaselist> purchases = session.createQuery(query).getResultList();
        for (Purchaselist purchase : purchases) {
            session.save(getLinkedPurchaseClass(purchase,session));
        }
        transaction.commit();
        valueSessionFactory().close();

    }




    private static SessionFactory valueSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory;
        return sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    private static Statement statement (String url, String user, String pass) throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,pass);
        Statement statement = connection.createStatement();
        return statement;
    }

    public static LinkedPurchaseList getLinkedPurchaseClass(Purchaselist purchase, Session session) {
        LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
        try{
            String query2 = "From " + Course.class.getSimpleName() + " where name = '" + purchase.getCourseName() + "'";
            List<Course> courses = session.createQuery(query2).getResultList();
            String query3 = "From " + Student.class.getSimpleName() + " where name = '" + purchase.getStudentName() + "'";
            List<Student> students = session.createQuery(query3).getResultList();

            //только вам нужно будет создать объект композитного ключа и сеттить туда
            linkedPurchaseList.setCourseId(courses.get(0));
            linkedPurchaseList.setStudentId(students.get(0));

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return linkedPurchaseList;
    }
}
