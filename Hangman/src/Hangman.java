import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hangman {

    int wordHardness = 1;
    int lives = 6;

    Hangman(int difficulty) {
        
        for (int i = 2; i <= difficulty; i++) {
            lives -= 1;
            wordHardness += 1;
        }

        //intro
        System.out.println("Welcome to Hangman! Note: You can guess spaces.");
        Ascii.printHangman(0);
        System.out.println("Don't get hanged.");
        System.out.println("");

        //big word bank, different word banks for different difficulties and wordHardness
        List<String> wordBank = new ArrayList<String>();
        wordBank.add("why");
        if (wordHardness == 1) {
            wordBank.addAll(Arrays.asList("apple", "orange", "jeans", "seven", 
            "eight", "zero", "scarce", "red", "head", "lead", "stead", "prey", "stay", "jacket", 
            "wifi", "router", "marker", "chair", "crazy", "insane", 
            "why", "what", "how", "penguin", "umpire", "flick", "foil", "rum", "rusty", "pear",
            "ball", "soup", "figure", "east", "west", 
            "yes", "less", "nation", "phone", "clock", "you", "yarn", 
            "purple", "gray", "emu", "blink", "blast", "restful", 
            "tingle", "mad", "paper", "pencil", "cruel", "library", "book", "look", "glance", 
            "smile", "pin", "yellow", "white", "jazz", "case", "safe", "chip", "dirt",
            "mud", "lust", "crust", "must", "bee", "time", "thing", "world", "saturn", "earth",
            "table", "tablet", "folder", "charge", "trash", "shark",
            "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey", 
            "turtle", "whale", "wolf", "zebra",
            "point", "crate", "late", "tardy", "slip", "pink", "brown", "sun",
            "horse", "norse", "shield", "dragon", "city", "best", "crest", 
            "screen", "xray", "arm", "elbow", "joint", "knee", "ankle", 
            "blind", "blinds", "green", "brush", "hint", "opera", "moss", "grass", "tree", "dirty", 
            "leaves", "kin", "bin", "sin", "win", "winner", "chicken", "car",
            "java", "lime", "key", "pie", 
            "string", "bling", "dock", 
            "sock", "stock", "guide", "brain", "king", "queen", "jail", 
            "flute", "cello", "violin", "viola", "bass", "drums", "blue", "slight", "spite", "rind", "cheese", 
            "egg", "leg", "calves", "calf", "beef", "steak", "brocoli", "tomato", 
            "kale", "old", "bold", "sold", "salad", "potato", 
            "kind", "person", "buy", "lava", "prince", 
            "evening", "state", "river", "lake", "urn", "burnt", "stern", "stool", "pool", "noon", "knife",
            "chess", "chest", "draw", "liver", "silver", "pasta", "penne", "kneel", "yawn", "hope", 
            "hopeful", "love", "war", "battle"));
        }
        else if (wordHardness == 2) {
            wordBank.addAll(Arrays.asList("mahjong", "arbitrary", "inkling", "dark blue", "quota", "queue",
            "airplane", "computer", "reasonable", "abolition", "therefore", "pristine", "princess", "blowing", "sixty", "laptop", "odyssey", 
            "tortellini", "blessed", "mousetrap", "python", "ember", "appreciation", "culture", "breathe", "grateful", "dagger", 
            "lithium", "aluminum", "nuclear fission", "innovation", "mangosteen", "bagpipes", "mutton", "hoodie", "flinch", "finch", 
            "incredible", "incredible", "stockings", "vapid", "jubilee", "binder", "bathroom", "bedroom", 
            "nuclear fusion", "gauntlet", "eardrum", "wombat", "afloat", "speaker", "galaxy", "weasel", 
            "necesity", "wring", "ancient", "crescent", "crescendo", "nitrogen", "sliding", "rolling", 
            "meaning", "scissors", "checkmate", "firetruck", "gerund", "rusting", "mastery", "wrinkle", "bask", "basket", 
            "bye bye", "bracket", "habitual", "serpent", "varsity", "tarnish", "stork", "element", "shambles",
            "licorice", "interesting", "hinder", "cup pong", "cupboard", "hamster", "retire", "hairstyle", "yesterday", "simmer"));
        }
        else {
            wordBank.addAll(Arrays.asList("intrinsically", "birthday gift", "ubiquitous", "condescending", 
            "horace mann", "musketeer", "tennis ball", "new year", "lineage", "drawbridge", 
            "balsamic vinegar", "orientation", "potato salad", "instigate", "hole puncher", 
            "province", "muscle fiber", "kale chips", "kowtow", "ostentatious", "claustrophobic", "jackpot",
            "rock and roll", "whimsical", "omnibus", "tree stump", "tyrannical", "artisanal", "stalemate", 
            "opus", "sweatshirt", "lightbulb", "peppa pig", "appointment", "guandao", "omnipotent", "avalanche", "eggplant", 
            "whiteboard", "paper cut", "centaur", "bugfix", "embark", "gratitude", "maternal"));
        }

        //picking a random word
        Random rand = new Random(); 
        int wordIndex = rand.nextInt(wordBank.size()); 
        String randWord = wordBank.get(wordIndex);

        //creating a string that is able to be modified very easily
        StringBuilder theWord = new StringBuilder(); 
        for (int i = 0; i < randWord.length(); i++) {
            theWord.append("*");
        }

        System.out.println("You need to guess: " + theWord);
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


            //checks if user input is repeated
            if (guessesMade.contains(letter)) {
                System.out.println("You already entered that input, try again.");
                continue;
            }
            else {
                //store every input
                guessesMade.add(letter);
            }

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
                    Ascii.printHangman(6);
                    System.exit(0);
                }

                System.out.println("Nope. You have " + lives + " lives left.");

                //all the art to indicate amount of lives lost visualized
                if (lives == 5) {
                    Ascii.printHangman(1);
                }
                else if (lives == 4) {
                    Ascii.printHangman(2);
                }
                else if (lives == 3) {
                    Ascii.printHangman(3);
                }
                else if (lives == 2) {
                    Ascii.printHangman(4);
                }
                else if (lives == 1) {
                    Ascii.printHangman(5);
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