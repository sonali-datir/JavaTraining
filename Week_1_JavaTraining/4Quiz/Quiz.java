import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Quiz {
    static int pointsCount = 0;
    static int negativeCount =0;
    public static void main(String[] args){

        System.out.println("***JAVA QUIZ***");
        QuestionData d1 = new QuestionData();
        //answers-answers-a,c,b,a,c answers-a,c,b,b,d answers-b,c,a,d,c answers- a,c,b,a,b
        Question [] questions = {
                new Question(d1.q1,"a"),
                new Question(d1.q2,"c"),
                new Question(d1.q3,"b"),
                new Question(d1.q4,"a"),
                new Question(d1.q5,"c"),

                new Question(d1.q6,"a"),
                new Question(d1.q7,"c"),
                new Question(d1.q8,"b"),
                new Question(d1.q9,"b"),
                new Question(d1.q10,"d"),

                new Question(d1.q11,"b"),
                new Question(d1.q12,"c"),
                new Question(d1.q13,"a"),
                new Question(d1.q14,"d"),
                new Question(d1.q15,"c"),

                new Question(d1.q16,"a"),
                new Question(d1.q17,"c"),
                new Question(d1.q18,"b"),
                new Question(d1.q19,"a"),
                new Question(d1.q20,"b")
        };
        Question.shuffleArray(questions);
        takeQuiz(questions);

    }

    public static void takeQuiz(Question[] questions){
        String answer;
        //Call 10 questions for quiz
        for(int i = 1; i<11; i++){

            //If user gets 4 questions wrong in first 6 attempt fails
            if(i==7 && negativeCount>=4){
                break;
            }
            //All questions
            else {

                System.out.print("\nQ-"+i+" "+questions[i].prompt);
                System.out.print("Answer: ");
                answer = Question.checkValid();
                //Checking correct answer
                if (answer.equals(questions[i].answer)) {
                    System.out.println("Correct Answer");
                    pointsCount++;
                } else {
                    System.out.println("Incorrect Answer");
                    negativeCount++;
                }
            }
        }
        //if points more than 4
        if(pointsCount>=4) {
            System.out.println("\nCONGRATULATIONS!!!\nYou passed the quiz and got " + pointsCount + "/10" );
        }
        //if points less than or equal 4
        else{
            System.out.println("\nSORRY!!!\nYou failed the quiz and got only "+ pointsCount + " points for first six questions. \nYou cannot continue. \nBETTER LUCK NEXT TIME!!!!!" );
        }
    }

}







