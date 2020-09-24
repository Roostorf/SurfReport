package SurfNewsParser;

import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;




/**
 * Represents a Example1Parse.
 *
 * @author Constantine Peros
 */
public class SurfParse {

  /**
   * Creates a New Example1Parse.
   *
   */
  public SurfParse() {
  }

  public static void main(String[] args) {
      Start();    
  }

  /**
   * 
   */
  private static void Start() {
    int dayCount = 0;
    Document document;
    try {
      //Get Document object after parsing the html from given url.
      String web = "https://www.surfnewsnetwork.com/surf_spot/diamond-head/";
      
      web = SelectSpot();
      
      document = Jsoup.connect(web).get(); 
      String text = document.body().text();

      dayCount = determineDay(text);
      //System.out.println(dayCount);
      
      Monday(text, dayCount);
      Tuesday(text, dayCount);
      Wednesday(text, dayCount);
      Thursday(text, dayCount);
      Friday(text, dayCount);
      Saturday(text, dayCount);
      Sunday(text, dayCount);
      
      print("done");
      
      //TryAgain();
    
    } catch (Exception e) {
      // TODO: handle exception
    }
    // TODO Auto-generated method stub
    
  }

  /**
   * 
   */
  private static void TryAgain() {
    
    print("Try Again? Y/N");
    Start();
    Scanner inKey = new Scanner(System.in);
    String yesNo = inKey.nextLine();         
      if (yesNo.equals("y")) { 
          inKey.close();
          Start();
        } else if (yesNo.equals("n")) {
          inKey.close();
        } else {
          inKey.close();
        }
  }
  
  /**
   * @return 
   * 
   */
  private static String SelectSpot() {
    print("[A]la Moana Bowls, [C]huns, [D]iamondhead, [E]wa Plains, [H]aleiwa, [L]aniakea, [M]akaha, Makapu[u] [P]ipeline, [R]ocky Point, Sand[y], [S]unset, [W]aikiki" );
    print("Which surf report? ");
        
        String web = new String();
        //rBoolean dayBool = false;
        Scanner inKey = new Scanner(System.in);

        while (true) {
          String spot = inKey.nextLine();
          
        if (spot.equals("d")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/diamond-head/";
            print("Fetching Surf Report For Diamondhead...");
            break;
          } else if (spot.equals("r")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/rocky-point/";
            print("Fetching Surf Report For Rockypoint...");
            break;
          } else if (spot.equals("w")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/waikiki/";
            print("Fetching Surf Report For Waikiki...");
            break;
          } else if (spot.equals("m")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/makaha/";
            print("Fetching Surf Report For Makaha...");
            break;
          } else if (spot.equals("y")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/sandys/";
            print("Fetching Surf Report For Sandy Beach...");
            break;
          } else if (spot.equals("s")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/sunset-beach/";
            print("Fetching Surf Report For Sunset Beach...");
            break;
          } else if (spot.equals("p")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/pipeline/";
            print("Fetching Surf Report For Ehukai Beach...");
            break;
          } else if (spot.equals("c")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/chuns/";
            print("Fetching Surf Report For Chuns Beach...");
            break;
          } else if (spot.equals("u")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/chuns/";
            print("Fetching Surf Report For Chuns Beach...");
            break;
          } else if (spot.equals("l")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/laniakea/";
            print("Fetching Surf Report For Laniakea Beach...");
            break;
          } else if (spot.equals("h")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/haleiwa/";
            print("Fetching Surf Report For Haleiwa...");
            break;
          } else if (spot.equals("e")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/ewa-plain/";
            print("Fetching Surf Report For Ewa-Plains...");
            break;
          } else if (spot.equals("a")) { 
            web = "https://www.surfnewsnetwork.com/surf_spot/ala-moana-bow/";
            print("Fetching Surf Report For Ala Moana Bowls...");
            break;
          } else {
            Start();
          }
        }

        inKey.close();
        
        print(web);
        
        return web;

    //String text = diamondhead.body().text();
  }

  /**
   * @param text
   */  
  private static void Sunday(String text, int dayCount) {
    if(text.matches("(.*)Sunday(.*)")) {
      if (dayCount == 5) {
          String sun = text.substring(text.indexOf("Sunday"), text.indexOf("spots") - 5);
          print("   " + sun);     
      } else {
          String sun = text.substring(text.indexOf("Sunday"), text.indexOf("Monday"));
          print("   " + sun);    
      }
    } 
  }

  /**
   * @param text
   */
  private static void Saturday(String text, int dayCount) {
    if(text.matches("(.*)Saturday(.*)")) {
      if (dayCount == 3) {
          String sat = text.substring(text.indexOf("Saturday"), text.indexOf("spots") - 5);
          print("   " + sat); 
      } else {
          String sat = text.substring(text.indexOf("Saturday"), text.indexOf("Sunday"));
          print("   " + sat);
      }
    }
  }

  /**
   * @param text
   */
  private static void Friday(String text, int dayCount) {
    
    if(text.matches("(.*)Friday(.*)")) {
        if (dayCount == 8) {
            String fri = text.substring(text.indexOf("Friday"), text.indexOf("spots") - 5);
            print("   " + fri);
        } else {
            String fri = text.substring(text.indexOf("Friday"), text.indexOf("Saturday"));
            print("   " + fri);
        }
    }
  }

  /**
   * @param text
   */
  private static void Thursday(String text, int dayCount) {
    if(text.matches("(.*)Thursday(.*)")) {
        if (dayCount == 13) {
            String thu = text.substring(text.indexOf("Thursday"), text.indexOf("spots") - 5);
            print("   " + thu);
        } else {
            String thu = text.substring(text.indexOf("Thursday"), text.indexOf("Friday"));
            print("   " + thu);
        }  
    }
  }


  /**
   * @param text
   */
  private static void Wednesday(String text, int dayCount) {
    if(text.matches("(.*)Wednesday(.*)")) {
      if (dayCount == 11) {
          String wed = text.substring(text.indexOf("Wednesday"), text.indexOf("spots") - 5);
          print("   " + wed);
      } else {
          String wed = text.substring(text.indexOf("Wednesday"), text.indexOf("Thursday"));
          print("   " + wed);
      }
    }
  }

  /**
   * 
   */
  private static void Monday(String text, int dayCount) {
    if(text.matches("(.*)Monday(.*)")) {
      if (dayCount == 7) {
          String mon = text.substring(text.indexOf("Monday"), text.indexOf("spots") - 5);
          print("   " + mon);
      } else {
          String mon = text.substring(text.indexOf("Monday"), text.indexOf("Tuesday"));
          print("   " + mon);
        
      }

    }
    
  }
  
  /**
   * 
   */
  private static void Tuesday(String text, int dayCount) {
    if(text.matches("(.*)Tuesday(.*)")) {
      if (dayCount == 9) {
          String tue = text.substring(text.indexOf("Tuesday"), text.indexOf("spots") - 5);
          print("   " + tue);
      } else {
          String tue = text.substring(text.indexOf("Tuesday"), text.indexOf("Wednesday"));
          print("   " + tue);   
      }

    }
    
  }



  public static void print(String string) {
    System.out.println(string);
  }
  
  public static int determineDay(String text) {
    int dayCount = 0;

    if(!text.matches("(.*)Sunday(.*)")) {
      dayCount = dayCount + 1;
    }
    if(!text.matches("(.*)Monday(.*)")) {
      dayCount = dayCount + 2;
    }
    if(!text.matches("(.*)Tuesday(.*)")) {
      dayCount = dayCount + 3;
    }
    if(!text.matches("(.*)Wednesday(.*)")) {
      dayCount = dayCount + 4;
    }
    if(!text.matches("(.*)Thursday(.*)")) {
      dayCount = dayCount + 5;
    }
    if(!text.matches("(.*)Friday(.*)")) {
      dayCount = dayCount + 6;
    }
    if(!text.matches("(.*)Saturday(.*)")) {
      dayCount = dayCount + 7;      
    }
    
    return dayCount;
    
    
  }

}
