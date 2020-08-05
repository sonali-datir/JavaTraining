import java.util.Scanner;

public class ExerciseSystem extends GetInformation{
    public static  double totalCaloriesBurned=0;
    public static void main(String[] args)
    {
        char choice;

        Scanner sc = new Scanner(System.in);
        System.out.println("****EXERCISE SYSTEM****");
        getUserInfo();

        do {
            getExerciseInfo(); //Get user information like name, weight and date
            CaloriesCalculator.caloriesBurned();
            totalCaloriesBurned += CaloriesCalculator.caloriesBurnedAfterExercise;
            System.out.println("Do you want to enter other exercise information?(y/n)");
            choice = sc.next().charAt(0);
        }while((choice == 'y') || (choice == 'Y') );

        printAllInfo();
        //GetInformation.printDetailInfo();

    }

}
