import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Hangman {
    

    public static void main(String[] args) throws Exception {
        List<String> movieList = new ArrayList<String>();
        File movies = new File("movies.txt");
        Scanner scanMovies = new Scanner(movies);
        Game myGame = new Game();
      


        while(scanMovies.hasNextLine()){
            String line = scanMovies.nextLine();
            movieList.add(line);
        } 

        System.out.println("List of movies: " + movieList);
        System.out.println("==================================");

        String movieToGuess = myGame.getMovie(movieList);
        String encodedMovie = myGame.encodeMovie(movieToGuess);

        // System.out.println("Movie Selected: " + movieToGuess);
        System.out.println("Encoded: " + encodedMovie);
        System.out.println("==================================");
        myGame.handleGuess();
 

    }
}
