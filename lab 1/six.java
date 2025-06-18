public class six {
    public static void main(String[] args)
    {
        int[] arr = new int[10];

        for(int i=0; i<arr.length; i++)
        {
            arr[i] = (int)(Math.random() * 100);        //Math.random() returns a doublenbetween 0-1
        }
        for(int val : arr)
        {
            System.out.println(val);
        }  
    }
}
