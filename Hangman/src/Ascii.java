public class Ascii {
    static void printHangman(int state) {
        if (state == 0) {
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
        } 
        else if (state == 1) {
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
        else if (state == 2) {
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
        else if (state == 3) {
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
        else if (state == 4) {
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
        else if (state == 5) {
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
        else if (state == 6) {
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
        }
    }
}