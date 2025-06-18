import java.util.*;
public class ExceptionHandling {
    public static void main(String[] args)
    {
        int[] arr = {10,20,30,40,50};

        Scanner stdin = new Scanner(System.in);
        System.out.println("enter index : ");

        try
        {
            String s = stdin.nextLine();
            int i = Integer.parseInt(s);        //Java automatically throws NumberFormatException when you try to convert a String to a number, and the string is not a valid number.

            System.out.println("Element at index " + i + ": " + arr[i]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Error: Index out of bounds");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: Invalid input.Please enter a numeric index");
        }
    }
}




//import java.util.*;
//public class ExceptionHandling {
//    public static void main(String[] args)
//    {
//        int[] arr = {10,20,30,40,50};
//
//        Scanner stdin = new Scanner(System.in);
//        System.out.println("enter index : ");
//
//        try
//        {
//            if(!stdin.hasNextInt())     //If the next token is not an integer, we throw a NumberFormatException.
//            {
//                throw new NumberFormatException();
//            }
//            int i = stdin.nextInt();
//            System.out.println("Element at index " + i + ": " + arr[i]);
//        }
//        catch(ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println("Error: Index out of bounds");
//        }
//        catch(NumberFormatException e)
//        {
//            System.out.println("Error: Invalid input.Please enter a numeric index");
//        }
//    }
//}

