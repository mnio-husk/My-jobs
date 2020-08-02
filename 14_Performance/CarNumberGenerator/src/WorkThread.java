import java.io.PrintWriter;

public class WorkThread implements Runnable {
    @Override
    public void run() {
        for (int number = 1; number < 1000; number++) {
            writer.write(work(letters, number, regionCode).toString());
        }
        writer.flush();
        writer.close();
    }


    private PrintWriter writer;
    private char letters[];
    private int regionCode;

    public WorkThread(PrintWriter writer, char[] letters, int regionCode) {
        this.writer = writer;
        this.letters = letters;
        this.regionCode = regionCode;
    }

    private static synchronized StringBuilder work(char letters[], int number, int regionCode) {
        StringBuilder builder = new StringBuilder();
        for (char firstLetter : letters) {
            for (char secondLetter : letters) {
                for (char thirdLetter : letters) {
                    builder.append(firstLetter);
                    builder.append(padNumber(number));
                    builder.append(secondLetter);
                    builder.append(thirdLetter);
                    builder.append(padNumber(regionCode));
                    builder.append("\n");
                }
            }
        }
        return builder;
    }

    private static String padNumber(int number) {
        StringBuilder builder = new StringBuilder();
        String str = Integer.toString(number);
        if (str.length() == 1) {
            builder.append("00" + str);
        }
        if (str.length() == 2) {
            builder.append("0" + str);
        }
        if (str.length() == 3) {
            builder.append(number);
        }


        return builder.toString();
    }

}

