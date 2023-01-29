import java.util.*;
class Game{
    public void RandomNoGuess()
    {
        int randomNo, guessNo;
        int Count=1;
        randomNo=(int)(Math.random()*50);
        Scanner obj = new Scanner(System.in);
        System.out.println("___________________Guess the Number Game__________________");
        System.out.println("Enter any number between 1 to 50. Remember that you have only 4 guesses");
        guessNo= obj.nextInt();

        do
        {
            if(guessNo==randomNo)
            {
                System.out.println("Congratulations!!!!!! You have guessed the correct number!!! The random number was "+randomNo);
                break;
            }
            if(guessNo>randomNo)
            {
                System.out.println("The random number is less than the guessed number");
            }
            else if(guessNo<randomNo)
            {
                System.out.println("The random number is greater than your guessed number ");
            }
            System.out.print("Enter your next guess: ");
            guessNo=obj.nextInt();
            Count++;
        }while(Count<5);
        if(Count <= 4 && guessNo == randomNo )
        {
            System.out.println("You are Winner!!");
        }
        else
        {
            System.out.println("Thats all you have guessed 4 times!!!...Try again in next game!!");
            System.out.println("By the way the random number chosen was: "+randomNo);
        }

    }
}
public class NumberGame{
    public static void main(String args[]){
        Game objGame = new Game();
        objGame.RandomNoGuess();
    }
}