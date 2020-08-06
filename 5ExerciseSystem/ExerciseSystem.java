import java.util.Scanner;

public class ExerciseSystem extends CaloriesCalculator{

    public static void main(String[] args)
    {
        char choice;
        char modeChoice;

        CaloriesCalculator c1 = new CaloriesCalculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("****EXERCISE SYSTEM****");
        System.out.println("a) Aggregate Mode \nb) Detail Mode");
        modeChoice = sc.next().charAt(0);
        c1.getUserInfo();

        do {
            String exerciseTypeAns = c1.getExerciseInfo();//Get user information like name, weight and date
            c1.caloriesBurned(exerciseTypeAns);
            System.out.println("Do you want to enter other exercise information?(y/n)");
            choice = sc.next().charAt(0);
        }while((choice == 'y') || (choice == 'Y') );
        if(modeChoice == 'b'){
            c1.printExerciseData("Detail Mode");

        }else{
            System.out.println("Aggregate Mode");
            c1.printExerciseData();
        }

    }
}
