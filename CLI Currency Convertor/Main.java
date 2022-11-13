import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String startingCurrency = "";
        String endingCurrency = "";
        double amount, result;
        Scanner input = new Scanner(System.in);

        try {

            System.out.print("Enter the starting currency: ");
            startingCurrency = input.nextLine();

            while (!startingCurrency.equals("EXIT")) {

                System.out.print("Enter the ending currency: ");
                endingCurrency = input.nextLine();
                System.out.print("What is the amount: ");
                amount = input.nextInt();

                URL url = new URL("https://api.exchangerate.host/convert?from=" + startingCurrency + "&to=" + endingCurrency);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {

                    content.append(inputLine);

                }

                String temp = content.toString();
                String[] temp1 = temp.split(",|\\{|:|}");
                Arrays.toString(temp1).trim();

                for (int i = 0; i < temp1.length; i++) {

                    if (temp1[i].equals("1")) {

                        double rate = Double.parseDouble(temp1[i + 5]);
                        result = rate * amount;
                        System.out.println();
                        System.out.println(amount + " " + startingCurrency + " => " + result + " " + endingCurrency);

                    }

                }

                //startingCurrency = "";
                System.out.print("\nEnter the starting currency: ");
                startingCurrency = input.next();

            }

        }catch(Exception e){

            e.printStackTrace();

        }


    }

}
