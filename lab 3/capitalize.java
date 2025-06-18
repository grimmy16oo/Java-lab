import java.util.Scanner;

public class capitalize  
{
    public static void main(String[] args)
    {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter a sentence : ");
        String sentence = stdin.nextLine();

        String[] word = sentence.split(" ");
        
        StringBuilder newStr = new StringBuilder();

        for(String w : word)
        {
            String s = w.substring(0, 1).toUpperCase() + w.substring(1);
            newStr.append(s).append(" ");
        }
        System.out.println(newStr.toString());
    }
}

// w.substring(0, 1).toUpperCase() → capitalizes the first letter.
// w.substring(1) → gets the rest of the word.

//newStr.append(s).append(" "); -> Appends each modified word to the StringBuilder and add space