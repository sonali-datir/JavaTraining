import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Question {
    String prompt;
    String answer;
    public Question(String prompt,String answer){
        this.prompt = prompt;
        this.answer = answer;
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

            valid = ((c >= 'a') && (c <= 'd')) || ((c >= 'A') && (c <= 'D'));

            if (!valid || a.length>1 )
            {
                System.out.println("Invalid answer. Please re-enter");
                System.out.print("Answer: ");
            }


        }while(valid==false || a.length>1 );
        return answer;
    }

    //Shuffle the questions
    static void shuffleArray(Question[] ar)
    {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Question a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
