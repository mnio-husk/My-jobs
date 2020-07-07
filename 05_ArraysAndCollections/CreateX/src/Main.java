public class Main {
    public static void main(String[] args) {
        String text = "х";
        String space = " ";
        int N = 7;
        String[][] array = new String[N][N];
        //Первая диагональ
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    array[i][j] = text;
                } else {
                    array[i][j] = space;
                }
            }
        }
        //Обратная диагональ
        for (int i = 0; i < N; i++) {
            for (int j = N; j >= 0; j--) {
                if (j == (N - 1 - i)) {
                    array[i][j] = text;
                } else {
                }
            }
        }
        //Вывод на экран
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}

