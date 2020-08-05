import java.util.Scanner;

public class CaloriesCalculator extends GetInformation{
    public static double caloriesBurnedAfterExercise;
    public static double caloriesBurnedAfterWalking;
    public static double caloriesBurnedAfterCycling;
    public static double caloriesBurnedAfterRunning;

    public static void caloriesBurned(){
        caloriesBurnedAfterExercise= 0.0175
                * METS * userWeightInKG
                * timeInMinutes;
        if(METS == WALKING_METS){
            caloriesBurnedAfterWalking = caloriesBurnedAfterExercise;
        } else if(METS == CYCLING_METS){
            caloriesBurnedAfterCycling = caloriesBurnedAfterExercise;
        }else{
            caloriesBurnedAfterRunning = caloriesBurnedAfterExercise;
        }

        System.out.println("Number of calories burned for running:    " + caloriesBurnedAfterExercise );
    }

    public static String checkValid(){
        boolean valid = true;
        String answer;
        char[] a;
        Scanner sc = new Scanner(System.in);
        do{
            answer = sc.nextLine();

            //Checking valid input

            a = answer.toCharArray();

            char c = a[0];

            valid = ((c >= 'a') && (c <= 'c')) || ((c >= 'A') && (c <= 'C'));

            if (!valid || a.length>1 )
            {
                System.out.println("Invalid answer. Please re-enter");
                System.out.print("Answer: ");
            }


        }while(valid==false || a.length>1 );
        return answer;
    }
}
