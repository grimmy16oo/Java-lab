interface Payment
{
    void makePayment(double amount);
}
class CreditCardPayment implements Payment{
    @Override
    public void makePayment(double amount)
    {
        System.out.println("Payment of $" + amount + " using Credit Card");
    }
}
class DebitCardPayment implements Payment{
    @Override
    public void makePayment(double amount)
    {
        System.out.println("Payment of $" + amount + " using Dredit Card");
    }
}
class CashPayment implements Payment{
    @Override
    public void makePayment(double amount)
    {
        System.out.println("Payment of$ " + amount + "using Cash");
    }
}

class PaymentInterface {
    public static void main(String[] args)
    {
        Payment c = new CreditCardPayment();
        c.makePayment(100.0);

       Payment d = new DebitCardPayment();
        d.makePayment(50.0);

        Payment ca = new CashPayment();
        ca.makePayment(25.0);
    }
}
