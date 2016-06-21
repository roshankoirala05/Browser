public class BrowserTest
{
		public static void main (String [] args)
		{
			Browser b = new Browser();
			System.out.println ("CURRENT: " + b.currentPage());
			System.out.println ("CAN GO BACK: " + b.canGoBack());
			System.out.println ("CAN GO FWD: " + b.canGoForward() + "\n");
			String site = "http://www.espn.com";
			System.out.println ("LOADING: " + site + " ... " + b.load(site));
			System.out.println ("CURRENT: " + b.currentPage());
			System.out.println ("CAN GO BACK: " + b.canGoBack());
			System.out.println ("CAN GO FWD: " + b.canGoForward()+ "\n");
			site = "www.invalid.com";
			System.out.println ("LOADING: " + site + " ... " + b.load(site));
			System.out.println ("CURRENT: " + b.currentPage());
			System.out.println ("CAN GO BACK: " + b.canGoBack());
			System.out.println ("CAN GO FWD: " + b.canGoForward()+ "\n");
			
			System.out.println ("GOING BACK TO: " + b.goBack());
			System.out.println ("CURRENT: " + b.currentPage());
			System.out.println ("CAN GO BACK: " + b.canGoBack());
			System.out.println ("CAN GO FWD: " + b.canGoForward()+ "\n");
			
			System.out.println ("GOING FWD TO: " + b.goForward());
			System.out.println ("CURRENT: " + b.currentPage());
			System.out.println ("CAN GO BACK: " + b.canGoBack());
			System.out.println ("CAN GO FWD: " + b.canGoForward()+ "\n");

			System.out.println (b.history());
			
			site = "http://www.thebeatles.com";
			System.out.println ("LOADING: " + site + " ... " + b.load(site));
			System.out.println ("CURRENT: " + b.currentPage());
			System.out.println ("CAN GO BACK: " + b.canGoBack());
			System.out.println ("CAN GO FWD: " + b.canGoForward());
			
			System.out.println (b.history());
	}
}
		