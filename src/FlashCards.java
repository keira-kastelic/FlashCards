/**
 * Flash cards
 * Author: Keira
 * Collaborator(s): Megan
 * On My Honor, I confirm that I followed all collaboration policy guidelines and that the work I am submitting is my own: KAK
 **/

public class FlashCards {
	protected String[] myQuestions;
	protected String[] myAnswers;
	protected int numCards;

	/* initialize instance data: arrays with a length of 1, and numCards to 0 */
	public FlashCards() {
		this.myQuestions = new String[1]; // creating a new array and setting the length to one
		this.myAnswers = new String[1]; // creating a new array and setting the length to one
		this.numCards = 0; // setting numCards to 0 to start
	}

	/* helper method that doubles the two arrays (myQuestions and myAnswers) in size to hold more data */
	public void doubleArrayLengths() { // creating a method to grow the array
		if(myAnswers.length == numCards){ // creating an if statement for if the answers are the number of cards created has passed the arrays length
			String[] myNewAnswers =  new String[2 * myAnswers.length]; // creating a new string that has double the length of the first one
			for(int i = 0; i < myAnswers.length; i++){ // creating a for statement to update the string created
				myNewAnswers[i] = myAnswers[i];
			}myAnswers = myNewAnswers; // setting the new array to the old one
		}
		if(myQuestions.length == numCards){ // repeating the process to update the questions array
			String[] myNewQuestions =  new String[2 * myQuestions.length];
			for(int i = 0; i < myQuestions.length; i++){
				myNewQuestions[i] = myQuestions[i];
			}myQuestions = myNewQuestions;
		}
	}

	/* Adds the question and answer as a flashcard
	Hint: remember to check to see if the arrays need to double in size */
	public void addCard(String question, String answer) {
		if(numCards == myAnswers.length || numCards == myQuestions.length){ // creating an if statement to see if you need to grow the array
			doubleArrayLengths(); // calling the method
		}
		myQuestions[numCards] = question; // setting the card number to the array and setting it equal to the string
		myAnswers[numCards] = answer; // repeating
		numCards++; // updating the number cards variable
	}
	/* returns the question at the given index */
	public String getQuestion(int i) {
		return myQuestions[i]; // returning the card at the index of what the user entered
	}
	/* returns the answer at the given index */
	public String getAnswer(int i) {
		return myAnswers[i]; // repeating
	}
	/* returns the number of flash cards */
	public int getNumCards() {
		return numCards; // returning the value of what the user entered
	}
	/* prints all the flashcards, you may want to use this method for testing!!*/
	public void printFlashCards() {
		for(int i=0; i<numCards; i++) {
			System.out.println("Q: " + getQuestion(i));
			System.out.println("A: " + getAnswer(i));
		}
	}
	public void deleteCard(int index){ // creating a method to delete note cards
		for(int i = index; i < numCards - 1; i++){ // creating a for loop to loop from the index to the end of the array
			myQuestions[i] = myQuestions[i+1]; // moving the instance data forward
			myAnswers[i] = myAnswers[i+1]; // moving the instance data forward
			if(i == numCards - 1){ // creating an if statement for the last array index to return null
				myQuestions[i] = null; // setting it equal to null
				myAnswers[i] = null; // setting it equal to null
			}
		}
	}

}
