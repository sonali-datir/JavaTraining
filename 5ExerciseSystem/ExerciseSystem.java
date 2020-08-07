import java.util.Scanner;

public class ExerciseSystem extends CaloriesCalculator{

    public static void main(String[] args)
    {
        char choice;
        char modeChoice;

        ExerciseSystem c1 = new ExerciseSystem();
        Scanner sc = new Scanner(System.in);

        System.out.println("****EXERCISE SYSTEM****");
        System.out.println("a) Aggregate Mode \nb) Detail Mode");
        modeChoice = sc.next().charAt(0);

        c1.getUserInfo(); //get user information like Name, Age, Date

        do {
            String exerciseTypeAns = c1.getExerciseInfo();//Get user information like exercise name, time duration.
            c1.caloriesBurned(exerciseTypeAns); //calculates calories burned based user input
            System.out.println("\nDo you want to enter other exercise information?(y/n)");
            choice = sc.next().charAt(0);
        }while((choice == 'y') || (choice == 'Y') );
        if(modeChoice == 'b'){
           c1.printExerciseData("***EXERCISE INFORMATION IN DETAIL MODE***"); // prints detail information about every exercise and calories burned
        }else{
            System.out.println("\n***EXERCISE INFORMATION IN AGGREGATE MODE***");
            c1.printExerciseData(); // prints total calories burned.
        }

    }
}
