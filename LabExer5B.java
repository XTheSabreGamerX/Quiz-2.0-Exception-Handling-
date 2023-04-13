/* Juan Carlos T. Matiass
IT201A*/

import java.util.*;
public class LabExer5B {

    static Scanner s = new Scanner(System.in);
    private static String response, response2;
    private static int score = 0;
    private static int i;

    private static String[] questions = {
        "Who is the main protagonist of the game series: Yakuza?",
        "What game revolutionized the MOBA Gaming genre?",
        "What Video Game has characters that obtain elemental powers through gemstones named 'Visions?'",       // Questions Array
        "In the video game 'Grand Theft Auto V', what is their country called?",
        "In the anime 'Date a Live,' which character wears a Black and Red Gothic outfit?",        
        "Among these choices, which would you use to write on a piece of paper?",
        "Between these three animals, which of them is the largest in terms of size?",
        "Which of these Anime characters have blonde hair?",
        "In League of Legends, which of these champions would be considered a Mid Laner?",
        "What is the video game store made by Valve called?"
    };

    private static String[] choices = {
        "A. Kiryu B. Aether C. Ashe",
        "A. CS:GO B. Minecraft C. DOTA",
        "A. World of Warcraft B. Genshin Impact C. God of War",     //Choices Array
        "A. Vice City B. San Andreas C. Liberty City",
        "A. Tohka B. Origami C. Kurumi",
        "A. Stick B. Pen C. Bamboo",
        "A. Elephant B. Dog C. Ant",
        "A. Chitoge Kirisaki B. Megumin C. Shalltear Bloodfallen",
        "A. Ashe B. Zed C. Camille",
        "A. G2G B. Humble Bundle C. Steam"
    };

    private static String answers[] = {
        "A",
        "C",
        "B",
        "B",        //Answers Array
        "C",
        "B",
        "A",
        "A",
        "B",
        "C",
    };

    public static void main(String[] args) throws Exception {   // Main method (practically empty. Just runs the quiz method lmao)
        Quiz();
    }

    private static void Quiz() throws Exception {
    while (i < questions.length) {      // While loop to loop the program back when an exception is encountered. Functions until it meets the condition of i < questions.length
        for (i = 0; i < questions.length; i++) {    // For loop for the questions and choices. Practically the whole quiz itself!
            try {
                System.out.println(questions[i]);
                System.out.println(choices[i]);  
                System.out.print("Answer: "); 
                response = s.nextLine();
                if (response.equalsIgnoreCase("")) {        // Try Block, checking for any exceptions specified in activity handout
                    throw new NoAnswer();
                }
                else if (!response.matches("[ABCabc]+")) {
                    throw new InvalidLetter();
                }
           }
            catch (NoAnswer na) {
                System.out.println(na.getMessage());        // Blank answer exception
                System.out.print("Would you like to try again? (Y/N): ");
                response2 = s.nextLine();
                if (response2.equalsIgnoreCase("N")) {
                    System.out.println("Thank you for trying out the quiz!");       
                    System.exit(0);
                }
                else if (response2.equalsIgnoreCase("Y")) {
                    score = 0;
                    break;
                }
                else {
                    System.out.println("You did not answer a valid letter.");
                    System.exit(0);
                }
            }

            catch (InvalidLetter il) {      // Invalid Letter or Special Character or Number exception
                System.out.println(il.getMessage());
                System.out.print("Would you like to try again? (Y/N): ");
                response2 = s.nextLine();
                if (response2.equalsIgnoreCase("N")) {
                    System.out.println("Thank you for trying out the quiz!");
                    System.exit(0);
                }
                else if (response2.equalsIgnoreCase("Y")) {
                    score = 0;
                    break;
                }
                else {
                    System.out.println("You did not answer a valid letter.");
                    System.exit(0);
                }
            }
            
        if (response.equalsIgnoreCase(answers[i])) {        // Correct answer condition (score increases!!)
            System.out.println("Correct!");
            score++;
        }
        else {      // Wrong answer! Shame! (Just kidding :p)
            System.out.println("Wrong!");
        }
        }
    }
    System.out.println("Your score is: " + score + "!!");       // Final print statement of the user's score
    }
}