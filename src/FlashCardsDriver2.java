import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FlashCardsDriver2 {
        public static void main(String[] args) throws FileNotFoundException {
            Scanner console;
            Scanner inFile;
            String question;
            String fileName;
            String answer;
            Random rand;
            FlashCards fc;
            fc=new SortedFlashCards();
            console=new Scanner(System.in);
            rand=new Random();

            //load the question file
            System.out.print("Enter the Question File: ");
            fileName=console.nextLine();
            inFile = new Scanner(new File(fileName));
            while(inFile.hasNextLine()) {
                question = inFile.nextLine();
                answer = inFile.nextLine();
                fc.addCard(question, answer);
            }
            //Ask the questions and compare the answers
            for(int i=0;i<50;i++) {
                String guess;
                System.out.println("Question: " + fc.getQuestion(i));
                guess=console.nextLine();
                if(guess.equals(fc.getAnswer(i)))
                    System.out.println("You're correct!!");
                else System.out.println("Sorry, the answer is: " + fc.getAnswer(i));
            }


        }
}
