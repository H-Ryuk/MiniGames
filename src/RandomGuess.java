import java.util.Scanner;

public class RandomGuess {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int rand, guess, MovesLeft = 10;
        rand = (int) (Math.random() * 100);

        boolean sttilplaying = true;

        while (sttilplaying) {
            System.out.println("You have "+MovesLeft+" trys to guess the random number. \nEnter Your guess number :");
            guess = input.nextInt();

            if (guess < rand) {
                System.out.println("Your guess is less than the random. \n------------------");
                MovesLeft--;
            } else if (guess > rand) {
                System.out.println("Your guess is greater than the random. \n------------------");
                MovesLeft--;
            }else {
                System.out.println("You win your guess is correct. The random number is: "+rand);
                sttilplaying = false;
            }if (MovesLeft == 0) {
                System.out.println("Game Over");
                sttilplaying = false;
            }
        }
    }
}

