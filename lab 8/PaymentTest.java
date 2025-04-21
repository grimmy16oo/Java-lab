
interface PaymentMethod {

    boolean authorizePayment(double amount);
    void processPayment(double amount);
    void refundPayment(double amount);
}

class CreditCard implements PaymentMethod {

    String cardNumber;
    String cardHolderName;

    public CreditCard(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean authorizePayment(double amount) {
        if (cardNumber.equals("412356789123456")) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    @Override
    public void processPayment(double amount) 
    {
        if (authorizePayment(amount)) 
        {
            System.out.println("processing " + amount + " tk");
        } 
        else 
        {
            System.out.println("processing failed");
        }
    }

    @Override
    public void refundPayment(double amount)
     {
        if (authorizePayment(amount))
        {
            System.out.println("refunding " + amount + " tk");
        } 
        else 
        {
            System.out.println("refunding failed");
        }
    }
}

class Paypal implements PaymentMethod {

    String email;
    String password;

    public Paypal(String email, String password) 
    {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean authorizePayment(double amount) 
    {
        if (email.equals("susmita@gmail.com") && password.equals("cat")) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }

    @Override
    public void processPayment(double amount) 
    {
        if (authorizePayment(amount)) 
        {
            System.out.println("processing " + amount + " tk");
        } 
        else 
        {
            System.out.println("processing failed");
        }
    }

    @Override
    public void refundPayment(double amount) 
    {
        if (authorizePayment(amount)) 
        {
            System.out.println("refunding " + amount + " tk");
        } 
        else 
        {
            System.out.println("refunding failed");
        }
    }
}

public class PaymentTest {

    public static void main(String[] args) 
    {
        PaymentMethod c = new CreditCard("412356789123456", "Susmi");
        c.authorizePayment(20000);
        c.processPayment(5000);
        c.refundPayment(1000);

        System.out.println("------------");

        PaymentMethod p = new Paypal("aaaa@gmail.com", "cat");
        p.authorizePayment(12330);
        p.processPayment(8769);
        p.refundPayment(6754);
    }
}
