import java.io.IOException;
import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {

        String dog = "@.";
        String number = "8";
        String numberPlus = "+";
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        String checkEmail = components[2].replaceAll("[^@.]", "");
        char inStr = components[3].charAt(0);
        String checkNumber = String.valueOf(inStr);

        if (checkEmail.equals(dog) && (checkNumber.equals(number) || checkNumber.equals(numberPlus))) {
            storage.put(name, new Customer(name, components[3], components[2]));
        } else if (checkEmail.equals(dog) != true) {
            throw new Exception("Wrong at input email. Example: mu@gmail.com");
        } else {
            throw new Exception("Wrong at input number phone. Example: +79277252628 or 89277252628");
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws Exception {
        if (storage.get(name) != null) {
            storage.remove(name);
        } else {
            throw new Exception("Wrong. This name not the list");
        }
    }

    public int getCount() {
        return storage.size();
    }
}