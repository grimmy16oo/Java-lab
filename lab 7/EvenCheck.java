
import java.util.Scanner;
class EvenNumberException extends Exception {

    public EvenNumberException(String message) 
    {
        super(message);
    }
}

public class EvenCheck 
{
    public static void checkEven(int number) throws EvenNumberException 
    {
        if (number % 2 == 0)
        {
            throw new EvenNumberException("The number is even!");
        } 
        else 
        {
            System.out.println("The number is odd.");
        }
    }
    public static void main(String[] args) 
    {
        System.out.println("Enter number : ");
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();

        try 
        {
            checkEven(n); 
        } 
        catch (EvenNumberException e) 
        {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
