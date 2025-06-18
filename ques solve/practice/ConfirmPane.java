import javax.swing.*;

public class ConfirmPane {
    public static void main(String[] args)
    {
        int choice = JOptionPane.showConfirmDialog(null,"what will it be?","demo",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);

        if(choice == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog(null,"you choose yes.");
        else if (choice == JOptionPane.NO_OPTION)
            JOptionPane.showMessageDialog(null, "You chose no.");
        else if (choice == JOptionPane.CANCEL_OPTION)
            JOptionPane.showMessageDialog(null, "You chose to cancel!");
        else
            JOptionPane.showMessageDialog(null, "Dialog closed without selection.");
    }
}
