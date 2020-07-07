import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController
{
    // homework done
    private static double passengerCarMaxWeight = 3500.0; // kg //переменная типа double
    private static int passengerCarMaxHeight = 2000; // mm (максимальная высота машины) //переменная типа int
    private static int controllerMaxHeight = 3500; // mm (максимальная высота контроллера) //переменная типа int

    private static int passengerCarPrice = 100; // RUB (пассажирская машина)//переменная типа int
    private static int cargoCarPrice = 250; // RUB (грузовая машина)//переменная типа int
    private static int vehicleAdditionalPrice = 200; // RUB (прицеп) //переменная типа int

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);
        int carsCount = scanner.nextInt(); /**
     *переменная типа int с дальнейшем присвоением числа, который введет пользователь
        **/

        for(int i = 0; i < carsCount; i++)
        {
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car);
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        int carHeight = car.height; //переменная типа int
        int price = 0; //переменная типа int
        double carWeight =car.weight;
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight) //проверка по высоте
        {      price = cargoCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice; }
        }
         else if (carWeight > passengerCarMaxWeight){ //проверка по массе
                price =cargoCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice; }
            }
        else {
            price =passengerCarPrice;
            if (car.hasVehicle) {
                price = price + vehicleAdditionalPrice; }
        }


        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }

}