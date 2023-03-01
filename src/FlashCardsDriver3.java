import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FlashCardsDriver3 {
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

        int numTries = fc.getNumCards(); // creating a variable to track how many tries they have
        for(int i=0;i<numTries;i++) { // creating a for loop to reprint the questions
            int questionNum=rand.nextInt(fc.getNumCards()); // storing a random array value in questionNum
            System.out.println("Question: " + fc.getQuestion(questionNum)); // prompting the user
            String guess=console.nextLine(); // reading in their input
            if(guess.equals(fc.getAnswer(questionNum))) { // creating an if statement to see if they answered correct
                System.out.println("You're correct!!"); // printing correct
                fc.deleteCard(questionNum); // removing the card
            } else { // reating an else statement for if they got it wrong
                System.out.println("Sorry, that is wrong, try this question again later"); // printing wrong
                numTries++; // adding to the number of tries so they can try again
            }
        }
    }
}
