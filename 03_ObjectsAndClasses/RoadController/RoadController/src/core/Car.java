package core;

public class Car
{
    public String number; //переменная типа String
    public int height; //переменная типа int
    public double weight; //переменная типа double
    public boolean hasVehicle; //переменная типа boolean
    public boolean isSpecial; //переменная типа boolean

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
//=============================================================
    public void setName_number(String number){
    this.number = number;
}
    public String getName_number(){
        return number;
    }

    //=============================================================
    public void setName_height(int height){
        this.height = height;
    }
    public double getName_height(){
        return height;
    }

    //=============================================================
    public void setName_weight(double weight){
        this.weight = weight;
    }
    public double getName_weight(){
        return weight;
    }

    //=============================================================
    public void setName_hasVehicle(boolean hasVehicle){
        this.hasVehicle = hasVehicle;
    }
    public boolean getName_hasVehicle(){
        return hasVehicle;
    }

    //=============================================================
    public void setName_isSpecial(boolean isSpecial){
        this.isSpecial = isSpecial;
    }
    public boolean getName_isSpecial(){
        return isSpecial;
    }
}