import java.util.Scanner;

class wordCount 
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter a sentence : ");
        String line = stdin.nextLine();

        String[] word = line.split(" ");
        
        System.out.println("number of words : " + word.length);
    }
}
