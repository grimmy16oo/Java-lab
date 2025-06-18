//Write a program that creates two threads, one printing even numbers and another printing odd numbers between 1 to 20.
class even implements Runnable{
    @Override
    public void run()
    {
        for(int i=1; i<=20; i++)
        {
            if(i%2 == 0)
                System.out.println("even : " + i);
        }
    }
}
class odd implements Runnable{
    @Override
    public void run()
    {
        for(int i=1; i<=20; i++)
        {
            if(i%2 != 0)
                System.out.println("odd : " + i);
        }
    }
}
class ThreadsCount {
    public static void main(String[] args){
        even e = new even();
        Thread t1 = new Thread(e);
        t1.start();

        odd o = new odd();
        Thread t2 = new Thread(o);
        t2.start();
    }
}
//no need of synchronizing because the two threads are not sharing any functions. its just 2 separate threads working on 2 diffrent task. we can use join() to make one thread wait for another tho.
