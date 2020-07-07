import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, 2017);
//        calendar.set(Calendar.MONTH, 0);
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        Date dateIn = calendar.getTime();
//        staff.stream().filter(employee -> employee.getWorkStart().compareTo(dateIn) > 0)
//                .max((m1, m2) -> m1.getSalary().compareTo(m2.getSalary())).ifPresent(System.out::println);

        List<Flight> list = new ArrayList<>();
        Airport air = Airport.getInstance();
        List<Terminal> terminals = new ArrayList<>();
        terminals.addAll(air.getTerminals());
        for (Terminal g : terminals) {
           System.out.println(g.getFlights());
           list.addAll(g.getFlights());
           }
//        list.stream().forEach(System.out::println);


        Calendar time = Calendar.getInstance();
        time.setTime(new Date());
        time.add(Calendar.HOUR, 2);
        Calendar timeBack = Calendar.getInstance();
        timeBack.setTime(new Date());
        timeBack.add(Calendar.HOUR, -2);

        list.stream().filter(t -> t.getDate().before(time.getTime()) && t.getDate().after(timeBack.getTime())).
               forEach(System.out::println);

    }


    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}