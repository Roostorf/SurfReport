package SurfNewsParser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Represents a Example1Parse.
 *
 * @author Constantine Peros
 */
public class Example1Parse {

  /**
   * Creates a New Example1Parse.
   *
   */
  public Example1Parse() {
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    print("Fetching Surf Report For Diamondhead...");
    Document document;
    try {
      //Get Document object after parsing the html from given url.
      document = Jsoup.connect("https://www.surfnewsnetwork.com/surf_spot/diamond-head/").get();
      
      String text = document.body().text();
      
      //System.out.println("Test: " + text.matches("(.*)Saturday(.*)"));
      
      
      if(text.matches("Sunday")) {
        String sun = text.substring(text.indexOf("Sunday"), text.indexOf("Monday"));
        print("   " + sun);
      }
      if(text.matches("(.*)Monday(.*)")) {
        String mon = text.substring(text.indexOf("Monday"), text.indexOf("Tuesday"));
        print("   " + mon);
      }
      if(text.matches("(.*)Tuesday(.*)")) {
        String tue = text.substring(text.indexOf("Tuesday"), text.indexOf("Wednesday"));
        print("   " + tue);
      }
      if(text.matches("(.*)Wednesday(.*)")) {
        String wed = text.substring(text.indexOf("Wednesday"), text.indexOf("Thursday"));
        print("   " + wed);
      }
      if(text.matches("(.*)Thursday(.*)")) {
        String thu = text.substring(text.indexOf("Thursday"), text.indexOf("Friday"));
        print("   " + thu);
      }
      if(text.matches("(.*)Friday(.*)")) {
        String fri = text.substring(text.indexOf("Friday"), text.indexOf("Saturday"));
        print("   " + fri);
      }
      //if(text.matches("(.*)Saturday(.*)")) {
      //  String sat = text.substring(text.indexOf("Saturday"), text.indexOf("Sunday"));
      //  print(sat);
      //} 
      else {
        return;
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    print("done");

  }
  
  public static void print(String string) {
    System.out.println(string);
  }

}
