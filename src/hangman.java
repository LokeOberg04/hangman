import javax.swing.*;

public class hangman {
    public static void main(String[] args) {

        String word = "";
        String wrongletter = "";
        String underscore = "";
        String guess = "";
        char letterguess = 0;
        String wordguess = "";
        int lives = 6;
        int correct = 0;

        int knapp = JOptionPane.showConfirmDialog(null, "Do you want to play hangman?");
        while (knapp == 0) {

            word = JOptionPane.showInputDialog("Word?");
            wrongletter = "";
            underscore = "";
            guess = "";
            letterguess = 0;
            wordguess = "";
            lives = 6;
            correct = 0;

            char[] letters = new char[word.length()];

            for (int i = 0; i < word.length(); i++) {
                letters[i] = word.charAt(i);
                if (letters[i] == ' ') {
                    underscore += " ";
                } else if (letters[i] == '-') {
                    underscore += "-";
                } else {
                    underscore += "_";
                }
            }
            char[] underscorelist = new char[underscore.length()];
            for (int j = 0; j < underscore.length(); j++) {
                underscorelist[j] = underscore.charAt(j);
            }
            while (lives > 0) {
                System.out.println(underscorelist);
                guess = JOptionPane.showInputDialog("Guess?");
                if (guess.length() > 1) {
                    wordguess = guess;
                    if (wordguess.equals(word)) {
                        System.out.println("you win!\n The word was " + "'" + word + "'");
                        lives = 0;
                        knapp = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
                    } else {
                        System.out.println("you lose!\n The word was '" + word + "'\nYour guess was " + "'" + wordguess + "'");
                        lives = 0;
                        knapp = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
                    }
                } else {
                    letterguess = guess.charAt(0);
                    for (int l = 0; l < word.length(); l++) {
                        if (letterguess == letters[l]) {
                            underscorelist[l] = letterguess;
                            correct = 1;
                        } else {
                        }
                    }
                    if (correct == 0) {
                        wrongletter += " " + letterguess;
                        lives -= 1;
                        System.out.println("Your letter was wrong\n" + "You have " + lives + " lives left");
                        System.out.println("You have already guessed" + wrongletter);
                    } else {
                        correct = 0;
                    }
                }
            }
        }
    }
}