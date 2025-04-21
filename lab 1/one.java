import java.util.Scanner;
public class one{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);

        System.out.println("Enter 2 integer: ");
        int x = stdin.nextInt();
        int y = stdin.nextInt();

        // if( x>y )
        // {
        //     System.out.println("max : " + x);
        //     System.out.println("min : " + y);
        // }
        // else
        // {
        //     System.out.println("max : " + y);
        //     System.out.println("min : " + x);
        // }

        System.out.println("maximum number : " + Math.max(x,y));
        System.out.println("minimum number : " + Math.min(x,y) );

    }
}