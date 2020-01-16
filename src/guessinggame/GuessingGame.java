/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;

/**
 *
 * @author jonathan.gabl
 */
import java.util.Scanner;

public class GuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        String[] food = {"pizza", "burger", "pasta"};
        String randomFood = food[(int) (Math.random() * 3)];
        String[] guesses = new String[3];
        String currentGuess = "";
        boolean playing = true;
        boolean isFood = false;
        int currentIndex = 0;
        System.out.println("The secret meal must be one of the following");
        for (int i = 0; i < food.length; i++) {
            System.out.println(food[i]);
        }
        System.out.println(randomFood);
        while (playing) {
            System.out.print("Guess the secret meal:");
            currentGuess = input.nextLine().toLowerCase();
            for (int i = 0; i < food.length; i++) {
                if (currentGuess.equals(food[i])) {
                    isFood = true;
                }
            }
            if (currentGuess.equals(randomFood)) {
                System.out.println("You Win");
                playing = false;
            } else {
                if (isFood) {
                    for (int i = 0; i < food.length; i++) {
                        if (currentGuess.equals(guesses[i])) {
                            System.out.println("You Already Guessed that, You Lose!");
                            playing = false;
                        }
                    }
                    guesses[currentIndex] = currentGuess;                    
                    currentIndex++;
                } else {
                    System.out.println("You Lose!");
                    playing = false;
                }
            }
            isFood = false;
        }
    }
}
