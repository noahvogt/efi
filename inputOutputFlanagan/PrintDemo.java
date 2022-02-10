import flanagan.io.Db;
import java.util.Arrays;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Locale;

public class PrintDemo {
    
    public static void main(String args[]) {
        
        String headerComment = "Datentyp";
            String[] comments = {"Integer (i)","Double (d)", "String (s)", "Datum", "(Vor-)Name"};
            String[] boxTitles = {"i", "d", "s", "Dat", "name"};
            int defaultBox = 1;
            int Box =  Db.optionBox(headerComment, comments, boxTitles, defaultBox);
        
        if (Box == 1) {
            
            //int
            int i = Db.readInt("\nGeben sie den int i ein!\n", 123);
            
            char[] chars_dash = new char[80];
            Arrays.fill(chars_dash, '-');
            
            String s_dash = new String(chars_dash);
            
            System.out.format("%s\n", s_dash);
            
            System.out.printf( "|%d|   |%d|%n" , i , -i ) ; // |123| |-123|
            System.out.printf( "|%5d| |%5d|%n" , i , -i ) ; // | 123| | -123| 
            System.out.printf( "|%-5d| |%-5d|%n" , i , -i ) ; // |123 | |-123 |
            System.out.printf( "|%+-5d| |%+-5d|%n" , i, -i ) ; // |+123 | |-123 |
            System.out.printf( "|%05d| |%05d|%n%n", i, -i ) ; // |00123| |-0123|
            
            System.out.printf( "i =%6d%n", i);
            System.out.printf( "1i =%6d   i2 =%+7d%n", i, i);
            System.out.printf( "1i =%+-7di2 =%+-7d%n", i, -i);
            
            System.out.printf( "1i = %-6di2 =   %-6di3 =%6d%n%n", i, i, -i);
            
            System.out.printf( "|%X| |%x|%n", 0xabc, 0xabc ); // |ABC| |abc|
            System.out.printf( "|%08x| |%#x|%n%n", 0xabc, 0xabc ); // |00000abc| |0xabc|
            
            System.exit(0);
        }
        
        if (Box == 2) {
    
        
            //Double
            double d = Db.readDouble("\nGeben sie deine Double Zahl d ein!\n", 12345.678000);
        
            System.out.printf( "|%f| |%f|%n" , d, -d ); // |12345,678000| |-12345,678000|
            System.out.printf( "|%.2f| |%.2f|%n" , d, -d ); // |12345,68| |-12345,68|
            System.out.printf( "|%,10f| |%,10f|%n" , d, -d ); // |1234,567800| |-1234,567800|
            System.out.printf( "|%10.2f| |%10.2f|%n" , d, -d ); // | 12345,68| | –12345,68|
            System.out.printf( "|%010.2f| |%010.2f|%n",d, -d ); // |0012345,68| |-012345,68|
            
            System.exit(0);
        }
        
        if (Box == 3) {
        
            //String
            String s = Db.readLine("\nGeben sie einen String ein!\n", "Monsterbacke");
        
            System.out.printf( "%n|%s|%n", s ) ; // |Monsterbacke|
            System.out.printf( "|%20s|%n", s ) ; // | Monsterbacke|
            System.out.printf( "|%-20s|%n", s ) ; // |Monsterbacke |
            System.out.printf( "|%7s|%n", s ) ; // |Monsterbacke|
            System.out.printf( "|%.7s|%n", s ) ; // |Monster|
            System.out.printf( "|%20.7s|%n", s ); // | Monster|
    
            System.exit(0);
        }
        
        if (Box == 4) {
            
            
            String loc = Db.readLine("\nLanguage: \n\nChinese = zh \nEnglish = en" +
                                     "\nFrenc fr \nGerman de  \nItalian it \nJapanese = ja" +
                                     "\nKorean = ko \nPortuguese = pt \nSpanish = es" +
                                     "\nSwedish = sv\n\n", "de");
            
            
            Locale mylocale = new Locale(loc);
            
            ZoneId zoneId = ZoneId.of("Europe/Zurich");
            ZonedDateTime currentTime = ZonedDateTime.now();
            System.out.printf(mylocale, "%tA %<tB  %<te,  %<tY  %n", currentTime);
            System.out.printf(mylocale, "%TA %<TB  %<te,  %<tY  %n", currentTime);
            System.out.printf(mylocale, "%tD %n", currentTime);
            System.out.printf(mylocale, "%tF %n", currentTime);
            System.out.printf(mylocale, "%tc %n", currentTime);
            System.out.printf(mylocale, "%Tc %n", currentTime);
            System.out.printf(mylocale, "Es ist: %tA %<te %<tB %<tY, %<tH:%<tM %n", currentTime);
        }
        if (Box == 5) {
            String name = Db.readLine("\nGeben sie ihren Namen ein!\n", "Peter");
            System.out.println("Ihr Name lautet: " + name);
            try {
                System.out.println("Ihr Vorname lautet: " + name.substring(0,name.indexOf(" ")));
                System.out.println("Ihr Nachname lautet: " + name.substring(name.indexOf(" ") + 1));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Fehler: Sie haben nur einen einzigen Namen angegeben");
            }
        }
    }    
}
