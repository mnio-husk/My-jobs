public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.registration("189",50000);
        bank.registration("289",100000);
        bank.registration("389",20000);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.transfer("189","389",10000);
                bank.transfer("289","389",60000);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                bank.transfer("289","189",10000);
                bank.transfer("189","289",60000);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
