import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class Main {

    // Запуск докер-контейнера:
    // docker run --rm --name skill-redis -p 127.0.0.1:6379:6379/tcp -d redis
    // Всего на сайт зарегистрировалось 20 различных пользователей
    private static final int USERS = 21;

    // Задержка между подсчетом
    private static final int SLEEP = 1000; // 1 секунда

    //Регистрация на сайте
    private static void log(int numberUser) {
        String log = String.format(" На главной странице показываем пользователя %d", numberUser);
        out.println(log);
    }

    //Олпата услуги
    private static void pay(int numberUser) {
        String log = String.format(" Пользователь %d оплатил платную услугу", numberUser);
        out.println(log);
    }

    public static void main(String[] args) {

        int payment = 1;
        RedisStorage redis = new RedisStorage();
        redis.init();
        while (true) {
            for (int regist = 1; regist < USERS; regist++) {
                redis.logRegUser(regist);
                if (payment == 10) {
                    int count = new Random().nextInt(regist);
                    pay(count);
                    log(count);
                    payment = 1;
                }
                if (payment != 10) {
                    log(regist);
                }
                payment++;
            }
            try {
                Thread.sleep(SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redis.deleteAllUsers();
        }

}
}
