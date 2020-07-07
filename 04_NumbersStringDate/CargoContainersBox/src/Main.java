public class Main {
    public static void main(String[] args) {

        // Грузовик >= 12 контейнеров
        // Контейнер >= 27 ящиков

        Cargo truck = new Cargo(500);
        System.out.println(truck.getBox());
        System.out.println(truck.getContainers());
        System.out.println(truck.getTruck());
        truck.result();




    }
}
