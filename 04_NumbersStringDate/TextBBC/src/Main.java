public class Main {
    public static void main(String[] args) {

        String text = "In the initial stages of the outbreak, it was the worried well who would be turning up in this poor neighbourhood, Elmhurst. Now everyone is sick. Really sick. Half of the patients are undocumented, and don't speak English - they work in restaurants and are hotel chambermaids. They are not \"plugged in\". The calls for social distancing have passed them by.\n" +
                "\n" +
                "And this medic, in her early 30s, tells me the stress is intense. Nearly everyone who arrives at the ER needs to be intubated and put on a ventilator. That would normally be a job done in the Intensive Care Unit. But they are overloaded.\n" +
                "\n" +
                "These people need \"pressors\" - meds that will keep blood pressure up. And that is a job normally done by specialist nurses. But there aren't the nurses to do it. So people who are untrained are having to do it. \"How can I not worry when there are patients not getting the care that they need?\"";

        String[] block = text.split("\\s+");
        for (int i = 0; i < block.length; i++){
            System.out.println(block[i]);
        }

    }
}
