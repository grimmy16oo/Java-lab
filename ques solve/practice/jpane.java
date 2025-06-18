import javax.swing.JOptionPane;
public class jpane {
    public static void main(String[] args)
    {
        String n1 = JOptionPane.showInputDialog("enter number");
        String n2 = JOptionPane.showInputDialog("enter num");

        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        int sum = num1 + num2;

        JOptionPane.showMessageDialog(null,sum);
    }
}
