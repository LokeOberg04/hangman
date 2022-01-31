import javax.swing.*;

public class hangman {
    public static void main(String[] args) {

        String word = JOptionPane.showInputDialog("Word?");
        String underscore = "";
        String guess = "";
        char letterguess = 0;
        String wordguess = "";
        int lives = 3;
        char[] letters = new char[word.length()];

        for(int i = 0; i < word.length(); i++) {
            letters[i] = word.charAt(i);
            if (letters[i] == ' ') {
                underscore += "";
            }
                else if (letters[i] == '-') {
                underscore += "-";
            }
                else {
                underscore += "_";
            }
        }
        char[] underscorelist = new char[underscore.length()];
        System.out.println(underscorelist);
        guess = JOptionPane.showInputDialog("Guess?");
        if(guess.length()>1) {
            wordguess = guess;
            if(wordguess.equals(word)) {
                System.out.println("you win!\n The word was " + word);
            }
            else {
                System.out.println("you lose!\n The word was " + word + "\nYour guess was " + wordguess);
            }
        }
        else {
            letterguess = guess.charAt(0);
            for (int l = 0; l < word.length(); l++) {
                if (letterguess == letters[l]) {
                    letters[l] = letterguess;
                    System.out.println(letters);
                }
                else {
                    lives = lives-1;
                    System.out.println("Your letter was wrong\n" + "You have " + lives + " left");
                }
        }
        }
    }
}
