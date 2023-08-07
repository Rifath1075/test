import javax.swing.*; 
import java.util.*;
import java.io.*;

//use getters

class impossibleQuizL7 { 

	public static void main (String[] args) {
		String name = JOptionPane.showInputDialog("Enter your name: \n");
		startQuestion();
		int firstScore = firstQuestion();
		int secondScore = secondQuestion(firstScore);
		int thirdScore = thirdQuestion(secondScore);
		int[] scores = new int[] {firstScore, secondScore, thirdScore};
		sort(scores);
			
		System.out.println("Your highest score was: " + scores[0]);

		String writeToFile = name + "\nHighscore: " + scores[0] + "\n\n\n\n";
		fileWrite(writeToFile);
		printFile();

		System.exit(0); 
	}

	public static void printFile() {
		String ask = JOptionPane.showInputDialog("Would you like to see all the scores? (yes or no)");

		if (ask.equalsIgnoreCase("yes")) {

			try {
				Scanner input = new Scanner(new File("scores.txt"));
			
				while (input.hasNextLine()) {
					System.out.println(input.nextLine());
				}
			}
	
			catch(IOException error) {
				System.err.println("IOException: " + error.getMessage());
			}
		}

		else if (ask.equalsIgnoreCase("no")) {
			System.out.println("");
		}

		else {
			System.out.println("Sorry, your answer was invalid. The program will now end");
		}
			
		
		return;
	}

	public static void fileWrite(String append) {
		try {
			String file = "scores.txt";
			FileWriter fw = new FileWriter(file, true);
			fw.write(append);
			fw.close();
		}
		
		catch(IOException error) {
			System.err.println("IOException: " + error.getMessage());
		}
		
		return;
	}

	public static void sort(int[] scores) {
		int arrayLength = scores.length - 1;
		int temp = 0;

		for (int i = 0; i<arrayLength; i+=1) {

			for (int j = 0; j<arrayLength; j+=1) {

				if (scores[j+1]>scores[j]) {
					temp = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = temp;
				}
			}
		}

		return;
	}

	public static void startQuestion() { 
		System.out.println("Welcome, to the Impossible Quiz! This is an all or nothing contest, rack up all the points you can by choosing the correct answer. But beware, choosing the 'Impossible' answer will reset your score to 0 and end the game! \n\nI wish you the best of luck. The quiz will start as soon as you're ready");
		String ready = JOptionPane.showInputDialog(null, "Are you ready? Please respond with yes or no:"); 
		if (ready.equalsIgnoreCase("yes")) { 
			System.out.println("Let's get ready to rumble!");
		}
		else if (ready.equalsIgnoreCase("no")) {
			System.out.println("Tough luck");
		}
		else {
			System.out.println("You can't follow simple instructions? You'll fail this quiz");
		}
		return; 
	}

	//Access first question answers
	
	public static questionInfo setFirstCorrect(questionInfo first) {
		first.correct = "antelope";
		return first;
	}

	public static String getFirstCorrect(questionInfo first) {
		return first.correct;
	}

	public static questionInfo setFirstIncorrect(questionInfo first) {
		first.incorrect = "axolotl";
		return first;
	}

	public static String getFirstIncorrect(questionInfo first) {
		return first.incorrect;
	}

	public static questionInfo setFirstImpossible(questionInfo first) {
		first.impossible = "aristotle";
		return first;
	}

	public static String getFirstImpossible(questionInfo first) {
		return first.impossible;
	}

	//First Question

	public static String askFirst() {
		String question[] = questionBank();
		String firstAnswer = JOptionPane.showInputDialog(question[0]);
		firstAnswer = firstAnswer.toLowerCase();
		return firstAnswer;
	}

	public static int firstQuestion() {

		boolean count = true;
		
		questionInfo first = new questionInfo();
		first = setFirstCorrect(first);
		first = setFirstIncorrect(first);
		first = setFirstImpossible(first);

		String firstAnswer = askFirst();

		Set<String> setAnswer = new HashSet<String>();
		setAnswer.add(first.correct);
		setAnswer.add(first.incorrect);
		setAnswer.add(first.impossible);

		if (!setAnswer.contains(firstAnswer)) {

			count = false;

			for (int i = 1; i<4; i+=1) {

				JOptionPane.showMessageDialog(null, "Sorry, that's an invalid answer, please try again\nYou have 3 attempts. Attempt: " +i);

				while (!count) {

					firstAnswer = askFirst();
				
					if (setAnswer.contains(firstAnswer)) {
						break;
					}
					break;
				}
			}
		}
		
		System.out.println("1) " + getFirstCorrect(first) + " is the correct answer");
		int userScore = 0;
		userScore = score(getFirstCorrect(first), getFirstIncorrect(first), firstAnswer, userScore);
		return userScore; 
	}

	//Second Question

	public static String askSecond() {
		String question[] = questionBank();
		String secondAnswer = JOptionPane.showInputDialog(question[1]);
		secondAnswer = secondAnswer.toLowerCase();
		return secondAnswer;
	}

	public static int secondQuestion(int userScore) {
		
		questionInfo second = new questionInfo();
		second.correct = "ruf";
		second.incorrect = "ducati";
		second.impossible = "okta";

		String secondAnswer = askSecond();

		Set<String> setAnswer = new HashSet<String>();
		setAnswer.add(second.correct);
		setAnswer.add(second.incorrect);
		setAnswer.add(second.impossible);

		if (!setAnswer.contains(secondAnswer)) {

			for (int i = 1; i<4; i+=1) {

				JOptionPane.showMessageDialog(null, "Sorry, that's an invalid answer, please try again\nYou have 3 attempts remaining. Attempt: " +i);
				secondAnswer = askSecond();
				
				if (setAnswer.contains(secondAnswer)) {
					break;
				}
			}
		}
		
		System.out.println("2) RUF is the correct answer");
		userScore = score(second.correct, second.incorrect, secondAnswer, userScore);
		return userScore; 
	}

	//Third Question

	public static String askThird() {
		String question[] = questionBank();
		String thirdAnswer = JOptionPane.showInputDialog(question[2]);
		thirdAnswer = thirdAnswer.toLowerCase();
		return thirdAnswer;
	}

	public static int thirdQuestion(int userScore) {
		
		questionInfo third = new questionInfo();
		third.correct = "spain";
		third.incorrect = "netherlands";
		third.impossible = "brazil";

		String thirdAnswer = askThird();

		Set<String> setAnswer = new HashSet<String>();
		setAnswer.add(third.correct);
		setAnswer.add(third.incorrect);
		setAnswer.add(third.impossible);

		if (!setAnswer.contains(thirdAnswer)) {

			for (int i = 1; i<4; i+=1) {

				JOptionPane.showMessageDialog(null, "Sorry, that's an invalid answer, please try again\nYou have 3 attempts remaining. Attempt: " +i);
				thirdAnswer = askThird();
				
				if (setAnswer.contains(thirdAnswer)) {
					break;
				}
			}
		}
		
		System.out.println("3) Spain is the correct answer");
		userScore = score(third.correct, third.incorrect, thirdAnswer, userScore);
		return userScore;
	}

	//Score

	public static int score(String correct, String incorrect, String answer, int userScore) {

		if (answer.equalsIgnoreCase(correct)) { 
			userScore += 1; 
			System.out.println("Well done, your score is: " + userScore); 
		}

		else if (answer.equalsIgnoreCase(incorrect)) {
			System.out.println(answer +" is incorrect, your score remains: " + userScore);
		}

		else { 
			userScore = 0;
			System.out.println(answer +" is an impossible answer. Score: " +userScore); 
		
		}
		return userScore;
	}
	
	public static String[] questionBank() {
		String[] bank = new String[5];
		bank[0] = "Which of the following animals is a mammal? (Please type the full answer)\nA) Axolotl\nB) Aristotle\nC) Antelope";
		bank[1] = "Which of the following is a car company? (Please type the full answer)\nA) RUF\nB) Ducati\nC) Okta";
		bank[2] = "Who won the world cup in 2010 (Please type the full answer)\nA) Netherlands\nB) Brazil\nC) Spain";
		return bank;
	}
}

//creates records so multiple values can be stores in 1 place

class questionInfo {
	String correct;
	String incorrect;
	String impossible;
}
