import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Hangman {
    public static void main(String[] args) throws Exception {

        //intro
        System.out.println("Welcome to Hangman! Note: You can guess spaces.");
        System.out.println(" \n"
                    + " ------\n"
                    + "|     @\n"
                    + "|     @\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|");
        System.out.println("");
        System.out.println("Don't get hanged.");
        System.out.println("");

        //big word bank
        String[] wordBank = {"apple", "orange", "jeans", "mahjong", "arbitrary", "birthday gift",
        "airplane", "seven", "eight", "computer", "intrinsically", "zero", "ubiquitous", "scarce", 
        "reasonable", "condescending", "red", "head", "lead", "stead", "prey", "stay", "jacket", "abolition", 
        "wifi", "router", "marker", "chair", "horace mann", "cup pong", "cupboard", "crazy", "insane", 
        "why", "what", "how", "therefore", "musketeer", "penguin", "pristine", "umpire", "flick", "foil", 
        "licorice", "rum", "rusty", "tennis ball", "hole puncher", "binder", "pear", "embark",
        "ball", "soup", "gratitude", "maternal", "figure", "omnipotent", "avalanche", "east", "west", 
        "yes", "less", "nation", "habitual", "serpent", "phone", "hairstyle", "blowing", "sixty", 
        "whiteboard", "paper cut", "laptop", "clock", "odyssey", "whimsical", "you", "yarn", "yesterday", 
        "purple", "gray", "emu", "sweatshirt", "hoodie", "flinch", "finch", "blink", "blast", "restful", 
        "tingle", "tarnish", "tyrannical", "mad", "mastery", "artisanal", "paper", "pencil", "jackpot", 
        "interesting", "bracket", "cruel", "library", "book", "look", "glance", "smile", "firetruck", 
        "bye bye", "pin", "yellow", "white", "dark blue", "jazz", "case", "safe", "chip", "dirt",
        "mud", "lust", "crust", "must", "bee", "time", "thing", "world", "saturn", "earth", "appointment",
        "table", "tablet", "folder", "charge", "trash", "lightbulb", "peppa pig", "shark",
        "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey", 
        "turtle", "weasel", "whale", "wolf", "wombat", "zebra", "wrinkle", "instigate", "bask", "basket",
        "point", "crate", "late", "tardy", "slip", "bathroom", "bedroom", "pink", "brown", "sun", "centaur",
        "horse", "norse", "shield", "dragon", "ancient", "city", "guandao", "best", "crest", "crescent", 
        "meaning", "screen", "xray", "arm", "elbow", "joint", "knee", "ankle", "sliding", "rolling", 
        "rock and roll", "blind", "blinds", "green", "rusting", "brush", "gerund", "hint", "simmer", 
        "opus", "omnibus", "opera", "ostentatious", "moss", "grass", "tree", "dirty", "leaves", "claustrophobic", 
        "necesity", "kin", "bin", "sin", "win", "winner", "chicken", "stork", "shambles", "car",
        "java", "python", "ember", "vapid", "hinder", "quota", "queue", "varsity", "lime", "key", "pie",
        "afloat", "string", "bling", "wring", "tree stump", "incredible", "speaker", "scissors", "dock", 
        "sock", "stock", "stockings", "galaxy", "guide", "brain", "king", "queen", "jail", "hamster", 
        "jubilee", "retire", "bagpipes", "flute", "cello", "violin", "viola", "bass", "drums", "eardrum", 
        "muscle fiber", "gauntlet", "blue", "inkling", "slight", "spite", "rind", "cheese", "eggplant", 
        "egg", "leg", "calves", "calf", "beef", "steak", "mutton", "brocoli", "mangosteen", "tomato", 
        "kale", "kale chips", "orientation", "old", "bold", "sold", "salad", "potato salad", "potato", 
        "kind", "person", "buy", "lava", "princess", "prince", "element", "nitrogen", "aluminum", "lithium", 
        "nuclear fusion", "nuclear fission", "evening", "mousetrap", "bugfix", "innovation", "state", 
        "province", "river", "lake", "urn", "burnt", "stern", "stool", "pool", "noon", "knife", "dagger",
        "chess", "chest", "blessed", "checkmate", "stalemate", "draw", "drawbridge", "liver", "silver", 
        "balsamic vinegar", "pasta", "penne", "tortellini", "kneel", "kowtow", "yawn", "breathe", "hope", 
        "hopeful", "love", "war", "battle", "grateful", "appreciation", "lineage", "culture", "new year"};

        //picking a random word
        Random rand = new Random(); 
        int wordIndex = rand.nextInt(wordBank.length); 
        String randWord = wordBank[wordIndex]; 

        //creating a string that is able to be modified very easily
        StringBuilder theWord = new StringBuilder(); 
        for (int i = 0; i < randWord.length(); i++) {
            theWord.append("*");
        }

        System.out.println("You need to guess: " + theWord);

        int lives = 6;
        Scanner sc = new Scanner(System.in);
        ArrayList <String> guessesMade = new ArrayList <String> ();

        //while loop until lives are gone or there is a win in which case break
        while (lives > 0) {
            System.out.println("Guess a letter...");
            String letter = sc.nextLine();
            letter = letter.toLowerCase();
            boolean correct = false;

            //error checking
            if (letter.length() == 1) {
                char character = letter.charAt(0);
                if (Character.isLetter(character) || character == ' ') {
                    System.out.println("");
                } 
                else {
                System.out.println("Invalid input. Please enter a letter.");
                continue;
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a single letter.");
                continue;
            }

            //store every input
            guessesMade.add(letter);

            //responds if the user has correctly guessed, uses StringBuilder to change areas of string
            for (int i = 0; i < randWord.length(); i++) {
                if (randWord.charAt(i) == letter.charAt(0)) {
                    theWord.setCharAt(i, letter.charAt(0));
                    correct = true;
                }
            }

            if (!correct) {
                lives = lives - 1;

                //if lost
                if (lives == 0) {
                    System.out.println("You lost. The correct word was: '" + randWord + "'.");
                    System.out.println(" \n"
                        + " ------\n"
                        + "|      |\n"
                        + "|   \\  O  /\n"
                        + "|    \\ | /\n"
                        + "|     \\|/\n"
                        + "|      |\n"
                        + "|      |\n"
                        + "|     / \\\n"
                        + "|    /   \\\n"
                        + "|   /     \\");
                    System.out.println("");
                    continue;
                }

                System.out.println("Nope. You have " + lives + " lives left.");

                //all the art to indicate amount of lives lost visualized
                if (lives == 5) {
                    System.out.println(" \n"
                    + " ------\n"
                    + "|      |\n"
                    + "|      O\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|");
                    System.out.println("");
                }
                else if (lives == 4) {
                    System.out.println(" \n"
                    + " ------\n"
                    + "|      |\n"
                    + "|      O\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|\n"
                    + "|\n"
                    + "|\n"
                    + "|");
                    System.out.println("");
                }
                else if (lives == 3) {
                    System.out.println(" \n"
                    + " ------\n"
                    + "|      |\n"
                    + "|      O\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|     / \n"
                    + "|    /   \n"
                    + "|   /");
                    System.out.println("");
                }
                else if (lives == 2) {
                    System.out.println(" \n"
                    + " ------\n"
                    + "|      |\n"
                    + "|      O\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|     / \\\n"
                    + "|    /   \\\n"
                    + "|   /     \\");
                    System.out.println("");
                }
                else if (lives == 1) {
                    System.out.println(" \n"
                    + " ------\n"
                    + "|      |\n"
                    + "|      O  /\n"
                    + "|      | /\n"
                    + "|      |/\n"
                    + "|      |\n"
                    + "|      |\n"
                    + "|     / \\\n"
                    + "|    /   \\\n"
                    + "|   /     \\");
                    System.out.println("");
                }
                System.out.println("You must continue guessing: " + theWord);
                System.out.println("You have already guessed these letters: " + guessesMade);
                System.out.println("");
            }
            else {
                System.out.println("You correctly guessed " + letter + ".");
                System.out.println("You must continue guessing: " + theWord);
                System.out.println("");
            }

            if (!theWord.toString().contains("*")) { 
                System.out.println("");
                System.out.println("Congratulations you win! The word is: '" + randWord + "'!");
                lives = 0;
                break;
            }
        }
    }
}