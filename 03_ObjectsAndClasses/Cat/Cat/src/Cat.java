
public class Cat {
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    static int countCat;


    static final int NUMBER_EYES = 2;
    static final double MIN_WEIGHT = 1000;
    static final double MAX_WEIGHT = 9000;


    private String name;
    private double height;

    private boolean condition;


    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

        countCat++;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
    }

    public double getKitten() {
        return this.weight;
    }


    public Cat(double weight, String name, double height) {
        this.name = name;
        this.weight = weight;
        this.height = height;
    }
    public Cat (Cat other){
        this.name = other.name;
        this.weight = other.weight;
        this.height = other.height;
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat copy ()
    {
     return new Cat (this.weight, this.name, this.height);
    }

    public boolean isAlive() {
        if (this.weight > maxWeight)
            return false;
        else if (this.weight < minWeight)
            return false;
        else
            return true;
    }

    public void meow() {
        if(isAlive() == true)
        {
        weight = weight - 50;
        System.out.println("Meow");
        }
    }

    public void waihtfood(double amount) {
        if(isAlive() == true)
        {
        weight = weight + amount;
        System.out.println(this.name + " съела " + amount + " граммов корма");
        }
    }

    public void bathroom() {
        if(isAlive() == true)
        {
        weight = weight - 500.0;
        System.out.println("Сходила в туалет");
        }
    }

    public void feed(Double amount) {
        weight = weight + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
        System.out.println("Drink");
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public static void getCount() {
        System.out.println(countCat);
    }

    public void setColorCat(Color type) {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String Name() {
        return this.name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void printAll() {
        System.out.println("Кошку зовут: " + name);
        System.out.println("Вес кошки: " + weight);
        System.out.println("Рост кошки: " + height);
    }

    public String getStatus() {
        if (weight < minWeight) {
            countCat--;
            return "Dead";
        } else if (weight > maxWeight) {
            countCat--;
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}