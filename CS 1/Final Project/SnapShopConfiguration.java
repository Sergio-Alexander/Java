// Write your short report here (-2 if there is no report)
//----------------------------------------------------------------------------------------------------------------
// I am going to create several classes - BlackAndWhiteFilter, NegativeFilter, FlipVerticalFilter, LaplacianFilter, GaussianFilter, and UnsharpMaskingFilter - Just like the examples
// Tried creating the EmbossFilter but I was unsuccessful. 
// I was stuck on the BlackAndWhiteFilter for a while, took me several days to figure it out. Searched YouTube for help, and it worked. 
// The negative filter also took me some time to figure out because I did not know how to properly format the codes.
// I was trying out some code for the BlackAndWhiteFilter when I stumbled upon making the filter just dimnmer everytime the user presses the filter button.
// And so I created the dimming filter.
// Tried some inputing other numbers and came across the thermal filter where it made the picture look like it was seen through thermal imaging.
// I wish I had more time to work on this project as it was very interesting, with more time I could've come up with more filters, but time is not on my side.
// Coding in Java has made me appreciate libraries because I started with C++ in my previous school, and most of the time I had to brute force my way into making my projects work.
/**
 * A class to configure the SnapShop application
 * 
 * @author Sergio Satyabrata
 * @version 3/21/2022
 */
public class SnapShopConfiguration {
	/**
	 * Method to configure the SnapShop. Call methods like addFilter and
	 * setDefaultFilename here.
	 * 
	 * @param theShop
	 *            A pointer to the application
	 */
	public static void configure(SnapShop theShop) {

		theShop.setDefaultFilename("seattle.jpg");
		theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
		theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
		// add your other filters below
        theShop.addFilter(new NegativeFilter(), "Negative");
		theShop.addFilter(new GaussianFilter(), "Gaussian Blur");
        theShop.addFilter(new LaplacianFilter(), "Laplacian");
		theShop.addFilter(new UnsharpMaskingFilter(), "Unsharp Masking");
		theShop.addFilter(new EdgyFilter(), "Edgy");
		theShop.addFilter(new BlackAndWhiteFilter(), "Black and White");
		theShop.addFilter(new ThermalFilter(), "Thermal");
        theShop.addFilter(new DimmingFilter(), "Dimming");
	}
}