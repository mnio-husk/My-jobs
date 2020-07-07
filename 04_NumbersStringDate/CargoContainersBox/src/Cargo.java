public class Cargo {
    private double truck,containers,box;

    Cargo(int box){
        this.box=box;
        //случай если ящиков 0 или отрицательное число
        if (box <= 0)
        {
            return;
        }
        // случай если пользователь ввел отрицательное число
        else
        {
            this.containers = Math.ceil(this.box/27); // колличество контейнеров под ящики
            this.truck = Math.ceil(this.containers/12); // кол-во грузовиков под контейнеры
        }
    }

    public double getBox(){
        return this.box;
    }

    public double getContainers(){
        return this.containers;
    }

    public double getTruck(){
        return this.truck;
    }

    //окончательный результат, который будет выдавать кол-во машин, контейнеров и коробок.
    public void result(){
        int c = 1;
        int b = 1;

        for (int i=1 ; i <= this.truck; i++) //Цикл для расчёта грузовиков
        {
        System.out.println("Грузовик " + i + ": ");
            int x = 0;
          while (x < 12 && c <=this.containers) //Цикл для расчёта контейнеров
          {
              System.out.println("   Контейнер " + c + ": ");
              int y = 0;
               while ( y < 27 && b <= this.box) //Цикл для расчёта коробок
               {
                   System.out.println("     Ящик " + b);
                   y++;
                   b++;
               }
               x++;
               c++;
              System.out.println();
          }

        }


    }


}
