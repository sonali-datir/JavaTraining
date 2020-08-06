import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CaloriesCalculator extends ExerciseInfo implements PrintData{

    public static double caloriesBurnedAfterExercise;
    public Map<String, Double> caloriesBurnedData= new HashMap<String, Double>();;
    double totalCaloriesBurned = 0;

    public void caloriesBurned(String metVal){
        caloriesBurnedAfterExercise= 0.0175 * exerciseMETS.get(metVal) * userWeightInKG * timeInMinutes;
        caloriesBurnedData.put(exerciseType.get(metVal),caloriesBurnedAfterExercise);
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
            valid = ((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'z'));
            if (!valid || a.length>1 )
            {
                System.out.println("Invalid answer. Please re-enter");
                System.out.print("Answer: ");
            }
        }while(valid==false || a.length>1 );
        return answer;
    }

    @Override
    public void printExerciseData() {
        for (Map.Entry mapElement : caloriesBurnedData.entrySet()) {
            totalCaloriesBurned += (Double) mapElement.getValue();
        }
        System.out.println(userName + " you burned " + totalCaloriesBurned + " calories on " + strDate );
    }

    @Override
    public void printExerciseData(String mode) {
        System.out.println(mode);
        System.out.print(userName + " you burned ");
        for (Map.Entry mapElement : caloriesBurnedData.entrySet()) {
            String key = (String) mapElement.getKey();
            double value = (Double) mapElement.getValue();
            System.out.print(value +" calories while " + key + " ");
        }
        System.out.print("on " + strDate + "." );
    }
}
