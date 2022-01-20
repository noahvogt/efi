public class Rekursion
{
    public int rekursAufruf (int n)
    {
        if (n > 1)
            return n + rekursAufruf (n - 1);
        return 1;
    } 
    public static void main (String [] args)
    {
        Rekursion rek = new Rekursion();
        System.out.println (rek.rekursAufruf (100));
    }
}
