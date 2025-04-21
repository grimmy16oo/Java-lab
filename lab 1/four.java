import java.util.Scanner;
public class four {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter base and exponent : ");
        int x = scan.nextInt();
        int y = scan.nextInt();

        System.out.println("Power : " + Math.pow(x,y));
    }
    
}
