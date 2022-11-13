import java.util.Arrays;

public class Calculations {

    public static void parseWebData(String info, String startingCurrency, String endingCurrency, double amount){

        double result;

        String[] temp1 = info.split(",|\\{|:|}");
        Arrays.toString(temp1).trim();

        for (int i = 0; i < temp1.length; i++) {

            if (temp1[i].equals("1")) {

                double rate = Double.parseDouble(temp1[i + 5]);
                result = rate * amount;
                System.out.println();
                System.out.println(amount + " " + startingCurrency + " => " + result + " " + endingCurrency);

            }

        }


    }

}
