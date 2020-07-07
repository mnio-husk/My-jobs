
public class Loader {
    public static void main(String[] args) {
       //
        Cat murka = new Cat("Мурка");
        while (murka.getStatus() != "Exploded")
        {
            murka.waihtfood(350);
        }
        System.out.println("Мурка очень много ела, поэтому " + murka.getStatus());

        Cat durka = new Cat("Дурка");
        while (durka.getStatus() != "Dead")
        {
          durka.meow();
        }
          System.out.println("Durka meow very more and " + durka.getStatus());


        //=============================================================================
        //Task 3 (redo)
        Cat barsik = new Cat();
        barsik.setColorCat(Color.GREEN);

        //=============================================================================
        Cat dusia = new Cat(1100.00);
        System.out.println(dusia.getKitten());



        //=============================================================================
        //Task 4 (redo)
        Cat obilisk = new Cat(5550.0,"Обилиск",55 );
        Cat io1 = new Cat();
        io1.setName(obilisk.Name());
        io1.setWeight(obilisk.getWeight());
        io1.setHeight(obilisk.getHeight());
        obilisk.printAll();
        io1.printAll();





        //=============================================================================
        Cat zhurka = new Cat();
        System.out.println("Вес Журки: " + zhurka.getWeight());
        zhurka.waihtfood(350);
        System.out.println("Вес Журки после того как поела: " + zhurka.getWeight());
        zhurka.bathroom();
        System.out.println("Вес Журки после того как сходила в туалет: " + zhurka.getWeight());

        Cat.getCount();


        //==================================================================================
        Cat omur = new Cat(2500.0, "Омур", 200);
        Cat io = new Cat(omur);
        Cat copyOmur = omur.copy();
        omur.printAll();
        io.printAll();
        copyOmur.printAll();





    }
}



