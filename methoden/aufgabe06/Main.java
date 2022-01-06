public class Main
{
public static void alpha()
{ System.out.println( "Hallo!" ); }
public static void beta()
{ alpha(); alpha(); }
public static void main( String[] args )
{ beta(); alpha(); }
}
