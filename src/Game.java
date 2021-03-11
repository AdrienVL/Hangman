import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    
    Random r = new Random();
    Scanner letterPrompt = new Scanner(System.in);
    List<Integer> instancesOfLetter = new ArrayList<Integer>();
    List<String> incorrectGuesses = new ArrayList<String>();
    private String movieToGuess;
    private String encodedMovie;
    private int wrongGuesses;
    
    
    


    public String getMovie(List<String> movieList) {
        int randomized = r.nextInt(movieList.size());
        movieToGuess = movieList.get(randomized);

        return movieToGuess;
    }

    public String encodeMovie(String movieToGuess){
        String [] movieSplit = movieToGuess.split("");

        for(var i = 0; i < movieToGuess.length(); i++){

            if (movieSplit[i].isBlank()){
                movieSplit[i] = " ";
            }else{
                movieSplit[i] = "_";
            }

        }

        encodedMovie = String.join("", movieSplit);
        return encodedMovie;
    }

    public String handleGuess(){
        while (wrongGuesses < 11){

            System.out.println("Guess a letter: ");
            String letter = letterPrompt.next();
            
            String [] movieSplit = movieToGuess.split("");
            String [] encodedSplit = encodedMovie.split("");
    
                for(var i = 0; i < movieToGuess.length(); i++){
                                   
                    if (movieSplit[i].equals(letter)){
                        System.out.println("hit");
                        encodedSplit[i] = letter;
                        
                    } 
                }

                encodedMovie = String.join("", encodedSplit);
                movieToGuess = String.join("", movieSplit);

                System.out.println(encodedMovie);

                if(!encodedMovie.contains(letter)){
                    wrongGuesses++;

                    if (!incorrectGuesses.contains(letter)){
                    
                    incorrectGuesses.add(letter);

                    }
                }

                System.out.println("Wrong guesses: " + wrongGuesses);
                System.out.println("Incorrect letters: " + String.join(",",incorrectGuesses));
                

                if(movieToGuess.equals(encodedMovie)){
                    System.out.println("You Won!");
                    break;
                }

                if(wrongGuesses == 10){
                    System.out.println("You Lost!");
                    break;
                }


            }

            return encodedMovie;
    }
    

}
