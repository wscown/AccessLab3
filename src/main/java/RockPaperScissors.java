/**
 * Created by wscown on 1/25/16.
 */

import java.util.Random;
import java.util.Scanner;

enum RPS {ROCK, PAPER, SCISSORS}

public class RockPaperScissors {
    public static void main(String[] args) {
        Tournament tournament = new Tournament();
    }
}

class Tournament{

    private int noOfGames;
    private int compScore;
    private int userScore;
    private ComputerPlayer computerPlayer = new ComputerPlayer();
    private UserPlayer userPlayer = new UserPlayer();

    Tournament(){
        noOfGames = 3;
        compScore = 0;
        userScore = 0;
        runTournament();
    }

    //Constructor used in testing
    Tournament(int i){
        compScore = 0;
        userScore = 0;
    }

    public void runTournament(){
        System.out.println("Welcome to a 3 round tournament of rock, paper, scissors!");

        for(int i = 0; i < noOfGames; i++){
            System.out.println("Time for round " + (i+1) + "!");

            computerPlayer.setRandomChoice();
            userPlayer.setUserChoice();

            play(computerPlayer, userPlayer);

            System.out.println("Current scores are - Computer " + compScore + " : " + userScore + " Player");
        }

        if(compScore > userScore){
            System.out.println("You lost to the computer. Final score Computer " + compScore + " : " + userScore + " Player");
        }else if (compScore < userScore){
            System.out.println("You beat the computer! Final score Computer " + compScore + " : " + userScore + " Player");
        }else{
            System.out.println("It was a draw. Final score Computer " + compScore + " : " + userScore + " Player");
        }
    }

    public void play(ComputerPlayer cp, UserPlayer up){

        //Computer wins
        if((cp.getCompChoice() == RPS.PAPER && (up.getUserChoice() == RPS.ROCK)) || (cp.getCompChoice() == RPS.SCISSORS && (up.getUserChoice() == RPS.PAPER)) || (cp.getCompChoice() == RPS.ROCK && (up.getUserChoice() == RPS.SCISSORS))){
            System.out.println("The computer won that round! Computer picked " + cp.getCompChoice() + " and you picked " + up.getUserChoice());
            compScore++;
        }else if((cp.getCompChoice() == RPS.PAPER && (up.getUserChoice() == RPS.PAPER)) || (cp.getCompChoice() == RPS.SCISSORS && (up.getUserChoice() == RPS.SCISSORS)) || (cp.getCompChoice() == RPS.ROCK && (up.getUserChoice() == RPS.ROCK))){
            System.out.println("Round was drawn. Computer picked " + cp.getCompChoice() + " and you picked " + up.getUserChoice());
        }else{
            System.out.println("You won that round! Computer picked " + cp.getCompChoice() + " and you picked " + up.getUserChoice());
            userScore++;
        }
    }

    public int getCompScore(){
        return compScore;
    }

    public int getUserScore(){
        return userScore;
    }
}

class ComputerPlayer {
    private RPS compChoice;

    public RPS getCompChoice() {
        return compChoice;
    }

    public void setChoice(RPS rps){
        compChoice = rps;
    }

    public RPS setRandomChoice(){
        Random rand = new Random();

        int choice = rand.nextInt(3);

        switch (choice) {
            case 0:
                compChoice = RPS.ROCK;
                break;
            case 1:
                compChoice = RPS.PAPER;
                break;
            case 2:
                compChoice = RPS.SCISSORS;
                break;
        }

        return compChoice;
    }
}

class UserPlayer{
    private RPS userChoice;

    public RPS getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(RPS userChoice){
        this.userChoice = userChoice;
    }

    public RPS setUserChoice(){
        Scanner sc = new Scanner(System.in);

        String userInput = "";

        while(userInput.compareTo("rock") != 0 && userInput.compareTo("paper") != 0 && userInput.compareTo("scissors") != 0 ) {
            System.out.println("Enter a valid choice of rock, paper, or scissors");
            userInput = sc.next().toLowerCase();
        }

        switch (userInput) {
            case "rock":
                userChoice = RPS.ROCK;
                break;
            case "paper":
                userChoice = RPS.PAPER;
                break;
            case "scissors":
                userChoice = RPS.SCISSORS;
                break;
        }

        return userChoice;
    }
}