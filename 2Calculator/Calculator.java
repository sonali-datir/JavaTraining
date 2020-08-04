import java.util.*;

public class Calculator {
    public static void main(String[] args){

        char ans;
        int result = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("*****CALCULATOR*****");
        System.out.print("How many numbers? ");
        int count = reader.nextInt();
        int[] numbersArray = new int[count];
        for(int i=0; i<count;i++){
            System.out.print("Enter number " +(i+1) + " ");
            numbersArray[i]=reader.nextInt();
        }

        do {
            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = reader.next().charAt(0);
            switch (operator) {
                case '+':
                    result=0;
                    for(int i=0; i<count;i++){
                        result+=numbersArray[i];
                    }
                    System.out.println("Addition = " +result);
                    break;

                case '-':
                    result=numbersArray[0];
                    for(int i=0; i<count-1;i++){
                        result=result-numbersArray[i+1];
                    }
                    System.out.println("Subtraction = " +result);
                    break;

                case '*':
                    result = numbersArray[0] * numbersArray[1];
                    System.out.println("Multiplication of first two numbers = " +result);
                    break;

                case '/':
                    result = numbersArray[0] / numbersArray[1];
                    System.out.println("Division of first two numbers = " +result);
                    break;

                // operator doesn't match any case constant (+, -, *, /)
                default:
                    System.out.printf("Error! operator is not correct");
                    break;
            }

          
            System.out.println("\nDo you want to continue with same numbers?(y/n)");
            ans = reader.next().charAt(0);
        }while (ans=='y');

    }
}
