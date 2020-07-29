import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Quiz {
    static int pointsCount = 0;
    static int negativeCount =0;
    public static void main(String[] args){

        System.out.println("***JAVA QUIZ***");
        //Questions
        //answers-a,c,b,a,c
        String q1 = "Who is known as father of Java Programming Language?\n"+"a)James Gosling\nb)M. P Java\nc)Charel Babbage\nd)Blais Pascal\n";
        String q2 = "In java control statements break, continue, return, try-catch-finally and assert belongs to?\n"+"a)Selection statements\nb)Loop statements\nc)Transfer statements\nd)Pause Statement\n";
        String q3 = "Which provides runtime environment for java byte code to be executed?\n"+"a)JRE\nb)JVM\nc)JDK\nd)JAVAC\n";
        String q4 = "What is byte code in Java?\n"+"a)Code generated by a Java compiler\nb)Code generated by a Java Virtual Machine\nc)Name of Java source code file\nd)Block of code written inside a class\n";
        String q5 = "Which of the following are not Java keywords ?\n"+"a)double\nb)switch\nc)then\nd)instaceof\n";

        //answers-a,c,b,b,d
        String q6 = "Which of these have highest precedence?\n"+"a) ()\nb) ++\nc)*\nd)>>\n";
        String q7 = "Java language was initially called as ________?\n"+"a)Sumatra\nb)J++\nc)Oak\nd)Pine\n";
        String q8 = "Which one is a template for creating different objects ?\n"+"a)An Array\nb)A Class\nc)Interface\nd)Method\n";
        String q9 = "Which symbol is used to contain the values of automatically initialized arrays?\n"+"a)Brackets\nb)Braces\nc)Parentheses\nd)Comma\n";
        String q10 = "Which of these operators is used to allocate memory to array variable in Java?\n"+"a)alloc\nb)malloc\nc)new malloc\nd)new\n";

        //answers-b,c,a,d,c
        String q11 = "Which statement transfer execution to different parts of your code based on the value of an expression?\n"+"a)If\nb)Switch\nc)Nested-if\nd)if-else-if\n";
        String q12 = "Modulus operator (%) can be applied to which of these?\n"+"a)Integers\nb)Floating - point numbers\nc)Both a and b\nd)None of These\n";
        String q13 = "What feature of OOP has a super-class sub-class concept?\n"+"a)Hierarchical inheritance\nb)Single inheritance\nc)Multiple inheritances\nd)Multilevel inheritance\n";
        String q14 = "What is the full form of JVM ?\n"+"a)Java Very Large Machine\nb)Java Verified Machine\nc)Java Very Small Machine\nd)Java Virtual Machine\n";
        String q15 = "Which of the following are not Java modifiers?\n"+"a)public\nb)private\nc)friendly\nd)transient\n";

        //answers- a,c,b,a,b
        String q16 = "In Java code, the line that begins with /* and ends with */ is known as?\n"+"a)Multiline comment\nb)Single line comment\nc)Both a & b\nd)None of these\n";
        String q17 = "Division operator has ____ precedence over multiplication operator.\n"+"a)Highest\nb)Least\nc)Equal\nd)None of these\n";
        String q18 = "What is the name of the method used to start a thread execution?\n"+"a)init();\nb)start();\nc)run();\nd)resume();\n";
        String q19 = "Which of the following will directly stop the execution of a Thread?\n"+"a)wait()\nb)notify()\nc)notifyall()\nd)exits synchronized code\n";
        String q20 = "Which method must be defined by a class implementing the java.lang.Runnable interface?\n"+"a)void run()\nb)public void run()\nc)public void start()\nd)void run(int priority)\n";

        //String  = "?\n"+"a)\n b)\nc)\n d)\n";
        //answers-answers-a,c,b,a,c answers-a,c,b,b,d answers-b,c,a,d,c answers- a,c,b,a,b
        Question [] questions = {
                new Question(q1,"a"),
                new Question(q2,"c"),
                new Question(q3,"b"),
                new Question(q4,"a"),
                new Question(q5,"c"),

                new Question(q6,"a"),
                new Question(q7,"c"),
                new Question(q8,"b"),
                new Question(q9,"b"),
                new Question(q10,"d"),

                new Question(q11,"b"),
                new Question(q12,"c"),
                new Question(q13,"a"),
                new Question(q14,"d"),
                new Question(q15,"c"),

                new Question(q16,"a"),
                new Question(q17,"c"),
                new Question(q18,"b"),
                new Question(q19,"a"),
                new Question(q20,"b")
        };
        shuffleArray(questions);
        takeQuiz(questions);

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

                if (!valid || a.length>1)
                {
                    System.out.println("Invalid answer. Please re-enter");
                    System.out.print("Answer: ");
                }


        }while(valid==false || a.length>1 );
        return answer;
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
                answer = checkValid();
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






