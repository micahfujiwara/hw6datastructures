import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This is the class the keeps track of the complete set of AAC mappings. 
 * It will store the mapping of the images on the home page to the AACCategories. 
 * The class should keep track of the current category that is being displayed. 
 * Then given the current category ("" if the home screen or the category name for any other category), 
 * it should respond appropriately for each of the methods.
 * @author Micah Fujiwara
 * @version 11/20/22
 */

public class AACMappings {
    //this all items represents the image of the category, and a hashmap that stores the AAC category
    HashMap<String, AACCategory> allItems = new HashMap<>();
    //indicates which level you are in in terms of category so like outer field = homepage, inner field = category
    HashMap<String, String> indicator = new HashMap<>();

    /** 
     * this method should read in the file and create the relevant mappings 
     * from images to categories and add all the items to each category. 
     * It should also start the AAC on the home screen
     * @param filename
     * @throws FileNotFoundException
     */
    public AACMappings(String filename) throws FileNotFoundException {
        reset();
        Scanner in = new Scanner(new File(filename));
		while (in.hasNextLine()){
            //getting the entire line
            String entireLine = in.nextLine();
            //getting the image location
			String location = entireLine.split(" ")[0];
            //getting the text associated with imageloc
            String imageTextString = entireLine.split(" ")[1];

            if (location == "img/food/plate.png"){
                allItems.put("img/food/plate.png", new AACCategory("food"));

                while (location.substring(1,8)=="img/food"){
                    allItems.get("img/food/plate.png").addItem(location.substring(1), imageTextString);
                    //add(location.substring(1), imageTextString);
                    indicator.put(location, "food category");
                }
            }
            
            if(location == "img/clothing/hanger.png"){
                allItems.put("img/clothing/hanger.png", new AACCategory("clothing"));

                while(location.substring(1,12) == "img/clothing"){
                    allItems.get("img/clothing/hanger.png").addItem(location.substring(1), imageTextString);
                    //add(location.substring(1), imageTextString);
                    indicator.put(location.substring(1), "clothes category");
                }
                
            }
        }
        //to indicate the homepage
        indicator.put("img/home.png","");  
    }

    /**
     * Given the image location selected, it determines the associated text with the image. 
     * If the image provided is a category, it also updates the AAC's current category to be the category associated with that image
     * given an image, it will either return the name of the category associated with that image if on the home screen 
     * and update the current category to that category or if in a category, 
     * it will return the text to be spoken that is associated with that image. 
     * If the image is not found in the expected area, it will throw the ElementNotFoundException
     * @param imageLoc the location where the image is stored
     * @return returns the text associated with the current image
     */
    public String getText(String imageLoc){
    }

    /**
     * Provides an array of all the images in the current category
     * @return the array of images in the current category
     */
    public String[] getImageLocs() {
        //check the category first and then return all images in that category
        /* 
        ArrayList<String> imagesList = new ArrayList<>();
        allItems.get()
            imagesList.add(key);
        String[] images = (String[]) imagesList.toArray();
        return images;
        */
    }
    
    
    /**
     * Resets the current category of the AAC back to the default category
     * resets the current category to the home screen ("")
     */
    public void reset(){
       indicator.get("img/home.png");
    }

    /**
     * returns the current category or the empty string if on the default category
     * it should return which is the current category the page is on or the empty string if the page is empty
     */
    public void getCurrentCategory(){
        for (String str:indicator.keySet()){
            if(indicator.get(str) == "food category"){
                System.out.println("food category");
            }
            else if (indicator.get(str) == "clothes category"){
                System.out.println("clothes category");
            }
            else if (indicator.get(str) == ""){
                System.out.println("homepage");
            }
        }
    }

    /**
     * Determines if the image represents a category or text to speak
     * given an image, it will return true if it is a category image and false otherwise
     * @param imageLoc - the location where the image is stored
     * @return true if the image represents a category, false if the image represents text to speak
     */
    public boolean isCategory(String imageLoc){
        if (allItems.containsKey(imageLoc)){
            return true;
        }
        return false;
    }

    /**
     * Writes the ACC mappings stored to a file. 
     * The file is formatted as the text location of the category followed by 
     * the text name of the category and then one line per item in the category that starts with 
     * > and then has the file name and text of that image for instance: 
     * img/food/plate.png food >img/food/icons8-french-fries-96.png french fries 
     * >img/food/icons8-watermelon-96.png watermelon img/clothing/hanger.png clothing 
     * >img/clothing/collaredshirt.png 
     * collared shirt represents the file with two categories, 
     * food and clothing and food has french fries and watermelon and clothing has a collared shirt
     * writes the AACMappings in the same format that they are read in
     * @param filename the name of the file to write the AAC mapping
     * @throws IOException
     */
    public void writeToFile(String filename) throws IOException {
        FileWriter file = new FileWriter(new File(filename));
        file.write("hello");
    }

    /**
     * Adds the mapping to the current category (or the default category if that is the current category)
     * should add the image and text to the category that is currently selected. 
     * If it is on the home screen, it should create a new category with the given image and name. 
     * If it is in a category, it should add the image and text to speak to the currently shown category
     * @param imageLoc the location of the image
     * @param text the text associated with the image
     */
    public void add(String imageLoc, String text){
        //if default category = homepage, put image loc as a key 
        //if in a category, get theit and add item
        allItems.get(new AACCategory("name"));
        allItems.get("name").addItem(imageLoc, text);
    }
}
