import javax.swing.*;

public class OptionPane {
   public static void main(String[] args)
   {
       String[] responses = {"red","green","blue"};

       int choice = JOptionPane.showOptionDialog(null,"choose something","demo",0,JOptionPane.QUESTION_MESSAGE,null,responses,responses[0]);

       if(choice == 0)
            JOptionPane.showMessageDialog(null,"you choose red");
       if(choice == 1)
           JOptionPane.showMessageDialog(null,"you choose green");
       if(choice == 2)
           JOptionPane.showMessageDialog(null,"you choose blue");
   }
}
