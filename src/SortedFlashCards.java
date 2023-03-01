public class SortedFlashCards extends FlashCards {

    public void addCard(String question, String answer) {
        if (numCards == myQuestions.length){ // checking to see if you have to grow the array
            doubleArrayLengths();
        }
        int index = numCards; // creating an index variable for the number of cards
        for(int i = 0; i < numCards; i++){ // creating a for loop to see if question is before of after the questino at the index of i
            if (myQuestions[i].compareTo(question) > 0){ // comparing myQuestions to question
                index = i; break;// setting index to i
            }
        }for(int i = numCards; i > index; i--){ // creating a for loop to run through and
            myQuestions[i] = myQuestions[i-1]; // taking the index of myQuestions and moving it to one index above
            myAnswers[i] = myAnswers[i-1]; // taking the index of myAnswers
        }
        myQuestions[index] = question; // setting the new index of myQuestions to question
        myAnswers[index] = answer; // setting the new index of myAnswers to answer

        numCards++; // updating the number of cards
    }

    public void print(){
        for (int i = 0; i < 50; i++){
            System.out.println(myQuestions[i]);
        }
    }
}