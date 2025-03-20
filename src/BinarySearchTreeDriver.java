import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * Binary Search Tree Driver.
 *
 */
public class BinarySearchTreeDriver {

    /*
     * The main function.
     */
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read file
        try(BufferedReader reader = new BufferedReader(
                new FileReader(args[0]))) {
            String[] stF = reader.readLine().split("\\s+");
            System.out.println("Enter tree type (i - int, d - double, s std:string): ");
            String str = scanner.nextLine();
            if (str.equals("i")) { // integer
                BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
                readF(stF, bst, "i");
                menu(scanner, bst, "i");
            } else if (str.equals("d")) { // double
                BinarySearchTree<Double> bst = new BinarySearchTree<Double>();
                readF(stF, bst, "d");
                menu(scanner, bst, "d");
            } else { // string
                BinarySearchTree<String> bst = new BinarySearchTree<String>();
                readF(stF, bst, "s");
                menu(scanner, bst, "s");
            } // else
        } catch (IOException e) {
            e.printStackTrace();
        } // catch
    } // main

    /*
     * Reads file.
     *
     */
    public static <T extends Comparable<T>> void readF(String[] str,
                                                       BinarySearchTree<T> bst, String type) {
        // sort the initial data
        for (String each: str) {
            if (type.equals("i")) { // integer
                bst.insert((T) Integer.valueOf(each));
            } else if (type.equals("d")) { // double
                bst.insert((T) Double.valueOf(each));
            } else { // string
                bst.insert((T) each);
            } // else
        } // for
    } // readF

    public static <T extends Comparable<T>> void menu(Scanner scanner, BinarySearchTree<T> bst,
                                                      String type) {
        while (true) {
            System.out.print("Commands: \n(i)  -  Insert Item\n(d)  -  Delete Item\n(p)  -" +
                               "  Print Tree\n(s)  -  Search Item\n(l)  -  Count Leaf " +
                             "Nodes\n(sp) -  Find Single Parents\n(c"
                             + ")  -  Find Cousins\n(q)  -  Quit program\n");
            String input = scanner.nextLine();
            switch (input) {
            case "q":
                System.out.println("Program ended!");
                return;
            case "i":
            case "d":
            case "s":
            case "c":
                System.out.println("Enter the value:");
                String s = scanner.nextLine().trim();
                if (type.equals("i")) { // integer value
                    if (input.equals("i")) { // insert
                        bst.insert((T) Integer.valueOf(s));
                        bst.inOrder();
                    } else if (input.equals("d")) {// delete
                        bst.inOrder();
                        bst.delete((T) Integer.valueOf(s));
                    } else if (input.equals("s")) { // search
                        bst.search((T) Integer.valueOf(s));
                    } else { // find cousins
                        bst.getCousins((T) Integer.valueOf(s));
                    } // else

                } else if (type.equals("d")) { //double value
                    if (input.equals("i")) { // insert
                        bst.insert((T) Double.valueOf(s));
                        bst.inOrder();
                    } else if (input.equals("d")) { // delete
                        bst.inOrder();
                        bst.delete((T) Double.valueOf(s));
                    } else if (input.equals("s")) { // search
                        bst.search((T) Double.valueOf(s));
                    } else { // find cousins
                        bst.getCousins((T) Double.valueOf(s));
                    } // else
                } else { // string value
                    if (input.equals("i")) { // insert
                        bst.insert((T) s);
                        bst.inOrder();
                    } else if (input.equals("d")) { // delete
                        bst.inOrder();
                        bst.delete((T) s);
                    } else if (input.equals("s")) { // search
                        bst.search((T) s);
                    } else { // find cousins
                        bst.getCousins((T) s);
                    } // else

                } // else
                break;
            case "p": // print tree
                bst.inOrder();
                break;
            case "l": // count leaves
                bst.getNumLeafNodes();
                break;
            case "sp": // find single parents
                bst.getSingleParent();
                break;
            default:
                System.out.println("Invalid commands!");
                break;
            } // switch
        } // while
    } // menu
} // BinarySearchTreeDriver
