import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExerciseInfo{
    public static double userWeightInKG;
    public static String userName;
    public static double timeInMinutes;
    public static String strDate;
    public static Date date=null;
    public String exerciseTypeAnswer;
    public Map<String, String> exerciseType;
    public Map<String, Integer> exerciseMETS;
    public String exerciseName;
    public int exerciseMETVal;
    public String addNew = "Add New Exercise?";
    String check ="d";
    Scanner sc= new Scanner(System.in);

    ExerciseInfo() {

        exerciseType = new HashMap<String, String>();
        exerciseType.put("a","Walking");
        exerciseType.put("b","Cycling");
        exerciseType.put("c","Running");
        exerciseType.put("d", "Add New Exercise?");

        exerciseMETS=new HashMap<String, Integer>();
        exerciseMETS.put("a", 5);
        exerciseMETS.put("b", 8);
        exerciseMETS.put("c", 10);
    }
    public void getUserInfo(){

        System.out.print("Enter your name : ");
        userName = sc.nextLine();

        System.out.print("Enter your weight in KG: ");
        userWeightInKG = sc.nextDouble();

        System.out.print("Enter the date(mm-dd-yyyy):");
        strDate = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        try {
            //Parsing the String
            date = dateFormat.parse(strDate);
            strDate = dateFormat.format(date);
        } catch (ParseException e) {
            System.out.println("Incorrect date format, taking current date as date.");
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            strDate = formatter.format(date);
        }

    }
    public String getExerciseInfo(){

        System.out.println("Enter exercise type ");
        for (Map.Entry mapElement : exerciseType.entrySet()) {
            String key = (String) mapElement.getKey();
            String value = (String)mapElement.getValue();
            System.out.println(key + ") " + value);
        }
        System.out.print("Answer: ");
        exerciseTypeAnswer = CaloriesCalculator.checkValid();


        if(exerciseTypeAnswer.equals(check)){
            addNewExercise();
            check = incrementVal(check);
        }
        System.out.print("Enter time duration in minutes : ");
        timeInMinutes = sc.nextDouble();
        return exerciseTypeAnswer;
    }
    public void addNewExercise(){
        System.out.print("Enter the name of exercise : ");
        exerciseName = sc.next();
        System.out.print("Enter the MET value of exercise : ");
        exerciseMETVal = sc.nextInt();
        exerciseType.replace(exerciseTypeAnswer, exerciseName);
        exerciseMETS.put(exerciseTypeAnswer,exerciseMETVal);

        String newKeyForAdd = incrementVal(exerciseTypeAnswer);
        exerciseType.put(newKeyForAdd,"Add New Exercise?");

    }
    public String incrementVal(String oldValue){
        //increment value for key
         String newCheckValue=new String();
        for(int i=0;i<oldValue.length();i++){
                newCheckValue+=(char)(oldValue.charAt(i)+1);
            }
        return newCheckValue;
    }
}
