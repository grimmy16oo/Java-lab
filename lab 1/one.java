import java.util.Scanner;
public class one{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);

        System.out.println("Enter 2 integer: ");
        int x = stdin.nextInt();
        int y = stdin.nextInt();

        System.out.println("maximum number : " + Math.max(x,y));
        System.out.println("minimum number : " + Math.min(x,y) );

    }
}