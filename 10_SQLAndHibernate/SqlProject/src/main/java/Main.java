import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "12344321Qmnio";

        try {
            Connection connection = DriverManager.getConnection(url,user,pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select purchaselist.course_name as course_name, count(subscription_date)/12 as average\n" +
                    "from purchaselist \n" +
                    "where month(purchaselist.subscription_date) \n" +
                    "group by course_name ");
            while (resultSet.next()){
                String courseName = resultSet.getString("course_name");
                String average = resultSet.getString("average");
                System.out.println(courseName + "  :  "  + average);
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
