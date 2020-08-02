package OpenCode.Webapp.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Game {
    public void enterGame() {
        Random rand = new Random();
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int[] sys = new int[4];
        sys[0] = rand.nextInt(9) + 1;
        for (int i = 1; i < 4; i++) {
            sys[i] = rand.nextInt(10);
            for (int j = 0; i < i; j++) {
                if (sys[i] == sys[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("        \"Cows and mulls.\" ");
        System.out.println("    You need to guess the number from [1000..9999] without doubles.");
        System.out.println("    You have unlimited number of attempts. Let's go :)");
        System.out.println("    Sadly, the first number cant be \"0\"");
        int[] us = new int[4];
        int cows, mulls;
        for (int kol_tries = 1; ; kol_tries++) {
            cows = 0;
            mulls = 0;
            System.out.print(kol_tries + ") Please, enter your number: ");
            int user_num;
            try {
                String str = buff.readLine();
                user_num = Integer.parseInt(str);
            } catch (NumberFormatException | IOException err) {
                System.err.println("Error: non-int symbols. ");
                kol_tries--;
                continue;
            }
            if ((user_num < 1000 || user_num > 9999)) {
                System.out.println("Error: the number is belongs to [1000 .. 9999].");
                kol_tries--;
                continue;
            }
            for (int i = 0; i < 4; i++) {
                us[3 - i] = user_num % 10;
                user_num /= 10;
            }
            try {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < i; j++) {
                        if (us[i] == us[j] && i != j) {
                            System.out.println("Error: the number has no doubles.");
                            kol_tries--;
                            throw new Exception();
                        }
                    }
                }
            } catch (Exception err) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                if (us[i] == sys[i]) {
                    mulls++;
                }
                int j;
                for (j = 0; j < 4 && us[i] != sys[j]; j++) ;
                if (i != j && j < 4) {
                    cows++;
                }
            }
            System.out.println("cows = " + cows + ", mulls = " + mulls);
            if (mulls == 4) {
                break;
            }
        }
        System.out.println("You win!");
    }
}


