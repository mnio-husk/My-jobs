import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        double[] array = new double[30];
        double middleTemperature = 0.0;
        int healthy = 0;
        double min = 36.2;
        double max = 36.9;

        for (int ill = 0; ill < array.length; ill++) {
            array[ill] = (Math.random() * (40 - 32)) + 32;
            String numberDouble = new DecimalFormat("#0.0").format(array[ill]);
            System.out.println(numberDouble);
            middleTemperature += array[ill];
            if (array[ill] <= max && array[ill] >= min) {
                healthy++;
            }
        }

        //Создаю формат, с одним знаком после плавающей запятой.
        double result = (middleTemperature / array.length);
        String formattedDouble = new DecimalFormat("#0.0").format(result);

        //Вывод на экран средней температуры у больных в больницы и число здоровых.
        System.out.println("Средняя температура у больных в больнице: " + formattedDouble);
        System.out.println("Число здоровых в больнице равна: " + healthy);
    }
}

