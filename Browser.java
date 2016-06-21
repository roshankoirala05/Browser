/**
   @author ROSHAN KOIRALA
   @version 1.0
   @since 10/24/2014
  
   A Java Program to simulate the navigational tools of an internet browser,
   using Stack objects to keep track of the sites visited.
 */


// importing required utilities
import java.util.*;
import java.net.URL;


/**
   A Browser class that that uses Stacks to load webpage, go back, go forward, 
   and display history for a browser. 
 */
public class Browser
{
   private Stack<String> currentStack = new Stack<String>();           // A stack to keep the current pages
   private Stack<String> tempStack = new Stack<String>();              // A stack to keep previous or forward pages
   private Stack<String> historyStack = new Stack<String>();            // A stack to keep the history of pages
   private String currentPage;                                    // Holds the string for current page
   
  /**
   The constructor  initializes the Browser obect with a default url.
  */
   public Browser()
   {
      
      currentStack.push("http://www.ulm.edu");
      updateCurrentPage();
   }

  /**
   The constructor  initializes the Browser obect with given argument if it is valid url
   It sets the browser object with default error message, if the argument is invalid url
   @param webPage The url to be loaded in browser object
  */
   public Browser(String webPage)
   {
      load(webPage);
   }

  
  /**
   Loads the url passed as argument if the url is properly formatted and found, if not, a default 
   error message is loaded.
   @param url The url to be loaded in browser object
   @return True if successfully loaded, false otherwise
  */
   public boolean load(String url)
   {
      try
      {
         URL testpage = new URL(url);
         if(testpage.getContent()!=null)
         {
            currentStack.push(url);
            updateCurrentPage();
            
            //Erasing any forward pages
            while(!tempStack.empty())
            {
               tempStack.pop();
            }
            return true;
         }
      }
      catch ( Exception e)
      {
         currentStack.push("ERROR:CANNOT FIND "+url);
         currentPage=currentStack.peek();
         return false;
      }
      return false;
   }

   
  /**
   Returns the current page of the browser
   @return The string object containing url for the current page 
  */

   public String currentPage()
   {
      return currentPage;
   }

   
  /**
   Checks if the browser object can go back.
   @return True if there is a previous url to go back, false otherwise.
  */
   public boolean canGoBack()
   {
     
      String temp = currentStack.pop();
      
      if(!currentStack.empty())
      {
         currentStack.push(temp);
         return true;
      }
         
      else
      {
         currentStack.push(temp);
         return false;
      }
   }

  
  /**
   Check if the browser object can go forward
   @return True if there is a next url to go forward, false otherwise
  */
   public boolean canGoForward()
   {
      if(!tempStack.empty())
         return true;
      else 
         return false;
   }

   
  /**
   Loads the previous page in the browing history if there is a previous page to load, no effect otherwise.
   @return the current page after loading the previous page
  */
   public String goBack()
   {
      if(canGoBack()==true )
      {
         tempStack.push(currentStack.pop());
         currentPage = currentStack.peek();
         return currentPage;
      }
      else
      {
         return currentPage;
      }
   }
   
   
   
  /**
   Loads the next page in the browing history if there is a next page to load, no effect otherwise.
   @return the current page after loading the next page
  */
   public String goForward()
   {
      if(canGoForward()==true)
      {
         currentStack.push(tempStack.pop());
         currentPage =currentStack.peek();
         return currentPage;
      }
      else
      {
         return currentPage;
      }
   }
   
   
  /**
   Displays a list of the pages loaded in the current browsing session
   @return String representing a list of history of a browser object
  */
   public String history()
   {
      String historyOfPages="";
      
      // A temporary stack to keep the history pages when tracing the history stack for printing
      Stack<String> tempo = new Stack<String>();
      
      // pushing out all the pages in history stack to display the pages.
      while(!historyStack.empty())
      {
         tempo.push(historyStack.peek());
         historyOfPages+=(historyStack.pop()+"\n");
      }
   
      // Pulling back all the pages to history stack so that it remains unchanged
      while(!tempo.empty())
      {
         historyStack.push(tempo.pop());
      }
      return ("\nHISTORY:\n"+historyOfPages+"\n");
   }
   
   
   /**
     Updates the current page and history list
    */   
   
   private void updateCurrentPage()
   {
      currentPage = currentStack.peek();
      historyStack.push(currentPage);
   }

} // End class


