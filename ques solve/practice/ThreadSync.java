//Create a shared counter variable and two threads that increment it 1000 times each. Demonstrate the need for synchronization by showing incorrect results without synchronization.
class Counter
{
    int cnt = 0;
    public synchronized void count()
    {
        cnt++;
    }
    public void displayCount()
    {
        System.out.println(cnt);
    }
}
public class ThreadSync {
    public static void main(String[] args) throws InterruptedException
    {
        Counter c = new Counter();

        Thread t1 = new Thread()
        {
            @Override
            public void run()
            {
                for(int i=0; i<1000; i++)
                {
                    c.count();
                }
            }
        };
        Thread t2 = new Thread()
        {
            @Override
            public void run()
            {
                for(int i=0; i<1000; i++)
                {
                    c.count();
                }
            }
        };

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        c.displayCount();
    }
}
//without synchronized it will print 1676. because two threads are accessing count funtion at the same time.
//after using synchronized it will print 2000.because it dosent let accens another thread when one thread is already using the function
