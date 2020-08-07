import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExerciseInfo{
    public static double userWeightInKG;
    public static String userName;
    public static double timeInMinutes;
    public static String strDate;
    public static Date date=null;
    public String exerciseTypeAnswer,exerciseName;
    public int exerciseMETVal;
    Object obj, newObj;
    Deque<Exercise> items;
    boolean incorrectDate;
    Exercise a,b,c,d;
    public String addNew = "Add New Exercise?";
    String check ="d";
    Scanner sc= new Scanner(System.in);

    ExerciseInfo() {
        //Default exercise types with MET value
        a = new Exercise("a","Walking",5);
        b = new Exercise("b","Cycling",8);
        c = new Exercise("c","Running",10);
        d = new Exercise("d","Add New Exercise?", 0);

        items = new ArrayDeque<Exercise>();
        items.add(a);
        items.add(b);
        items.add(c);
        items.add(d);
    }
    public void getUserInfo(){

        System.out.print("\nPlease enter your name : ");
        userName = sc.nextLine();

        System.out.print("\nPlease enter your weight in KG: ");
        userWeightInKG = sc.nextDouble();

        System.out.println("\nPlease enter your choice for date:");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println("a)Take Current date. \nb) Enter date manually(mm-dd-yyyy)\n");
        String dateAnswer = sc.next();
        if(dateAnswer.equals("b")){
            do {
                System.out.print("Date : ");
                strDate = sc.next();
                try {
                    //Parsing the String
                    date = dateFormat.parse(strDate);
                    strDate = dateFormat.format(date);
                    incorrectDate = false;
                } catch (ParseException e) {
                    incorrectDate = true;
                    System.out.println("Incorrect date format. Please re-enter the date in this format mm-dd-yyyy.");
                }
            }while (incorrectDate);
            System.out.println("Correct Date. \n");
        }
        else{
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
            strDate = formatter.format(date);
        }
    }
    public String getExerciseInfo(){

        System.out.println("\nPlease enter exercise type ");
        for(Exercise exercise : items) {
            System.out.println(exercise.getAlpha()+")"+exercise.getExName());
        }
        System.out.print("Answer: ");
        exerciseTypeAnswer = CaloriesCalculator.checkValid();


        if(exerciseTypeAnswer.equals(check)){
            addNewExercise();
            check = incrementVal(check);
        }
        System.out.print("\nPlease enter time duration in minutes : ");
        timeInMinutes = sc.nextDouble();
        return exerciseTypeAnswer;
    }
        //Adding new exercise
    public void addNewExercise(){
        System.out.print("Please enter the name of exercise : ");
        exerciseName = sc.next();
        System.out.print("Please enter the MET value of exercise(Metabolic Equivalent of Task) : ");
        exerciseMETVal = sc.nextInt();
        items.removeLast();
        String currentExerciseTypeAns = exerciseTypeAnswer;
        obj = currentExerciseTypeAns;
        Exercise obj = new Exercise(exerciseTypeAnswer,exerciseName,exerciseMETVal);
        items.addLast(obj);

        //Giving last option add new exercise
        String newKeyForAdd = incrementVal(exerciseTypeAnswer);
        newObj = newKeyForAdd;
        Exercise newObj = new Exercise(newKeyForAdd,addNew,0);
        items.addLast(newObj);
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
