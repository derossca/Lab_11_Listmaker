//importing utilities
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //array list
   static ArrayList<String> list = new ArrayList<>();
   static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {


        final String menu = "A - add D - delete P - print Q - quit";
        boolean done = false; //putting here just in case needed
        String cmd = "";

        do
        {
            //display array list
            displayList();

            //get menu choice
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            //execute choice
            switch (cmd)
            {
                case "A":
                    //prompt user for a list item
                    //make sure that item is not an empty string
                    //add it to the list
                    add();
                    break;
                case "D":
                    //prompt user for the number of the item to delete
                    //translate the number to an index by subtracting 1
                    //remove the item from the list
                    delete();
                    break;
                case "P":
                    printItem();
                    break;
                case "Q":
                    //prompt user to see if they are sure they want to quit
                    //if Yy then program ceases, if Nn program continues and prompts menu choices
                    quit();
                    break;
            }
            System.out.println();
        } while (!done);
        //quit set to false unless user input in method below is Yy
        //program only quits when condition is met in helper method quit() below
    }

    private static void displayList()
    {
        //list size cannot be zero
        if(list.size() != 0)
        {
            //for loop that prints out list number + 1 for user readability, then list item
            //and some space is added for readability
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("%1d%10s%5s", i + 1, list.get(i), " ");
            }
        }
        else //else output that the list is empty
        {
            System.out.println("List is empty!");
        }

    }

    private static void add()
    {
        //declaring variable needed
        String addItem = "";

        //calling method so user is prompted and inputs an item to add
        addItem = SafeInput.getNonZeroLenString(in, "Add an item to the list ");

        //user input is added to the list
        list.add(addItem);
    }

    private static void delete()
    {
        int deleteItem = 0;

        //getting user input while prompting for number of the list item to delete
        deleteItem = SafeInput.getRangedInt(in, "Select the number of the item to delete ", 1, 100);
        //matching user number with array index number by subtracting 1
        deleteItem = deleteItem - 1;

        //removing the item at index location given and translated
        list.remove(deleteItem);
    }

    private static void printItem()
    {
        //outputs the array list
        displayList();
    }

    //made this a boolean to work with the switch case Q and do while loop for entire program
    private static boolean quit()
    {
        boolean quitting = false;

        //prompts user to see if they are sure they want to quit Yy or Nn
        quitting = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");

        //If else structure that returns true and will end program in main method
        //should user choose Yy
        if(quitting)
        {
            quitting = true;
        }
        //else the boolean quitting is false and program continues on
        else
        {
            quitting = false;
        }
        //return result of quitting from if else structure
        return quitting;
    }
}