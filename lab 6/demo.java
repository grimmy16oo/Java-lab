import javax.swing.JOptionPane;

public class demo 
{
    public static void main(String[] args) 
    {
        String name = JOptionPane.showInputDialog("What's your name?");
        JOptionPane.showMessageDialog(null, "Hello " + name + "!");

        int choice = JOptionPane.showConfirmDialog(null, "Do you like Java?", "Question", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Great!");
        } else {
            JOptionPane.showMessageDialog(null, "Oh no!");
        }
    }
}
