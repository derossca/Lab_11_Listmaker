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
        boolean done = false;
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
                    quit();
                    break;
            }
            System.out.println();
        }
        while (!done);

    }

    private static void displayList()
    {
        if(list.size() != 0)
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.printf("%1d%10s%5s", i + 1, list.get(i), " ");
            }
        }
        else
        {
            System.out.println("List is empty!");
        }

    }

    private static void add()
    {
        String addItem = "";

        addItem = SafeInput.getNonZeroLenString(in, "Add an item to the list ");

        list.add(addItem);
    }

    private static void delete()
    {
        int deleteItem = 0;

        deleteItem = SafeInput.getRangedInt(in, "Select the number of the item to delete ", 1, 100);

        list.remove(deleteItem);
    }

    private static void printItem()
    {
        displayList();
    }

    private static void quit()
    {
        boolean quitting = false;

        quitting = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }
}