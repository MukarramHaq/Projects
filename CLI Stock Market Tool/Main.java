import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        String ticker = "";

        try {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter to get a ticker information: ");
            ticker = input.nextLine();


            while(ticker != "EXIT"){

                URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + ticker + "&apikey=2QWFMRDRH55PQWMI");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while((inputLine = in.readLine()) != null){

                    content.append(inputLine);

                }

                String temp = content.toString();
                String[] temp1 = temp.split("}|,|\\{");
                Arrays.toString(temp1);

                for(int i = 20; i <= 24; i++){

                    if(i == 24){

                        System.out.println(temp1[i+1].replace("\"", "").trim());

                    }else{

                        System.out.println(temp1[i].replace("\"", "").trim());

                    }

                }

                System.out.print("Enter to get a ticker information: ");
                ticker = input.nextLine();

            }


        } catch (Exception e){

            e.printStackTrace();

        }
    }

}



