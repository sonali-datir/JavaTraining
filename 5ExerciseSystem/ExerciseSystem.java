import java.util.Scanner;

public class ExerciseSystem extends GetInformation{
    public static  double totalCaloriesBurned=0;
    public static void main(String[] args)
    {
        char choice;
        char modeChoice;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("****EXERCISE SYSTEM****");
        System.out.println("a) Aggregate Mode \nb) Detail Mode");
        modeChoice = sc.next().charAt(0);

        getUserInfo();

        do {
            getExerciseInfo(); //Get user information like name, weight and date
            CaloriesCalculator.caloriesBurned();
            totalCaloriesBurned += CaloriesCalculator.caloriesBurnedAfterExercise;
            System.out.println("Do you want to enter other exercise information?(y/n)");
            choice = sc.next().charAt(0);
        }while((choice == 'y') || (choice == 'Y') );

        if(modeChoice == 'b'){
            System.out.println("Detail Mode");
            printDetailInfo();

        }else{
            System.out.println("Aggregate Mode");
            printAllInfo();
        }

    }

}
