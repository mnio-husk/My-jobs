
public class Concatenation
{
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();


        StringBuilder str = new StringBuilder();
//        String str = "";
        for(int i = 0; i < 20_000; i++)
        {
            str.append("some text some text some text");
            str.append("\n");
//            str += "some text some text some text";
//            str += "\n";
        }

        System.out.println(str);
        System.out.println((System.currentTimeMillis() - start) + " ms");

    }
}
