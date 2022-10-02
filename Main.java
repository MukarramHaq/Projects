import java.text.spi.DecimalFormatSymbolsProvider;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("0.00");

        Scanner input = new Scanner(System.in);
        Calculations calc = new Calculations();

        System.out.println("\n\nWelcome to CLI Calculator\n\n");
        System.out.println("Operations: \na: Addition\ns: Subtraction\nm: Multiplication\nd: Division\ne: Exit\n");
        //System.out.println("a: Addition\ns: Subtraction\nm: Multiplication\nd: Division\ne: Exit\n");
        System.out.print("Choose your operation: ");
        char choice = input.next().charAt(0);
        System.out.println();

        while(choice != 'a' && choice != 's' && choice != 'm' && choice != 'd' && choice != 'e'){

            System.out.print("\nInvalid Input! Choose from the options above: ");
            choice = input.next().charAt(0);
            System.out.println();

        }

        while(choice != 'e'){

            System.out.print("\nEnter the first number: ");
            double firstNumber = input.nextDouble();
            System.out.println();
            System.out.print("\nEnter the second number: ");
            double secondNumber = input.nextDouble();
            System.out.println();

            if(choice == 'a'){

                System.out.println("The result is: " + df.format(calc.sum(firstNumber, secondNumber)));
                System.out.println();

            }

            else if(choice == 's'){

                System.out.println("The result is: " + df.format(calc.subtraction(firstNumber, secondNumber)));
                System.out.println();

            }

            else if(choice == 'm'){

                System.out.println("The result is: " + df.format(calc.multiplication(firstNumber, secondNumber)));
                System.out.println();

            }

            else{

                if(secondNumber <= 0){

                    System.out.println("Cannot divide by 0\n");

                }else{

                    System.out.println("The result is: " + df.format(calc.division(firstNumber, secondNumber)));
                    System.out.println();

                }

            }

            System.out.print("Choose your operation: ");
            choice = input.next().charAt(0);

            while(choice != 'a' && choice != 's' && choice != 'm' && choice != 'd' && choice != 'e'){

                System.out.print("\nInvalid Input! Choose from the options above: ");
                choice = input.next().charAt(0);

            }

        }

        System.out.println("\n\nGoodbye!");

    }

}
