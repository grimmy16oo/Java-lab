interface Payment
{
    boolean authorizePayment(double amount);
    void processPayment(double amount);
    void refundPayment(double amount);
}
class CreditCard implements Payment
{
    String cardNumber;
    String cardHolderName;

    public CreditCard(String cardNumber,String cardHolderName)
    {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public boolean authorizePayment(double amount)
    {
        if(cardNumber.length() == 16)
    }
}
public class PaymentTest
{
    public static void main(String[] args)
    {

    }
}
