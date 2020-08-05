import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GetInformation {
    public static final int WALKING_METS = 5;
    public static final int CYCLING_METS = 8;
    public static final int RUNNING_METS = 10;
    public static int METS = 0;
    public static double userWeightInKG;
    public static String userName;
    public static double timeInMinutes;
    public static String exerciseType;
    public static String strDate;
    public static Date date=null;

    public static void getUserInfo(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter your name : ");
        userName = sc.nextLine();

        System.out.print("Enter your weight in KG: ");
        userWeightInKG = sc.nextDouble();

        System.out.println("Enter the date(mm-dd-yyyy):");
        strDate = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        try {
            //Parsing the String
            date = dateFormat.parse(strDate);
            strDate = dateFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Incorrect date format taking current date.");
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            strDate = formatter.format(date);
        }

    }
    public static void getExerciseInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Exercise type? \n a) Walking \n b) Cycling \n c) Running \n");
        System.out.print("Answer: ");
        exerciseType = CaloriesCalculator.checkValid();

        if(exerciseType.equals("a")){
            METS = WALKING_METS;
        } else if(exerciseType.equals("b")){
            METS = CYCLING_METS;
        }
        else {
            METS = RUNNING_METS;
        }
        System.out.print("Enter time duration in minutes : ");
        timeInMinutes = sc.nextDouble();

    }
    public static void printAllInfo(){
        System.out.println(userName + ", you burned " + ExerciseSystem.totalCaloriesBurned + " calories on " + strDate );
    }
    public static void printDetailInfo(){
        System.out.println(userName + ", you burned " + CaloriesCalculator.caloriesBurnedAfterWalking + " calories after walking, "
                + CaloriesCalculator.caloriesBurnedAfterCycling+ " calories after cycling, " + CaloriesCalculator.caloriesBurnedAfterRunning +" calories after running on" + strDate );
    }
}
