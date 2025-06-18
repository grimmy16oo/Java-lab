class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 50; i += 2)
        {
            System.out.println("Odd Thread: " + i);
            try {
                Thread.sleep(100); // Small delay for better output visualization
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EvenThread extends Thread {
    public void run()
    {
        for (int i = 2; i <= 50; i += 2) {
            System.out.println("Even Thread: " + i);
            try {
                Thread.sleep(100); // Small delay for better output visualization
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args)
    {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All numbers printed!");
    }
}