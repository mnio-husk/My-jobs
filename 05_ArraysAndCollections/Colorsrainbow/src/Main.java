public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] color = text.split(",?\\s+");
        for (String colorRainbow : color) {
            System.out.println(colorRainbow);
        }
        System.out.println("\nРасчет в обратном порядке:");
        for (int i = color.length - 1; i >= 0; i--) {
            System.out.println(color[i]);
        }
    }
}
