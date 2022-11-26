import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the mappings for a single category of items that should be displayed
 * stores mappings between the image location and the text that should be spoken
 * and the name of the category
 * @author Micah Fujiwara
 * @version 11/30
 */
public class AACCategory {
    //image location, text
    public HashMap<String, String> category = new HashMap<>();
    public String newCategory;

    /**
     * creates a new empty category with the given name
     * @param name - the name of the category
     */
    public AACCategory(String name){
        this.newCategory = name;
    }

    /**
     * adds item
     * @param imageLoc - the location of image
     * @param text - the text associated with image
     */
    public void addItem(String imageLoc, String text){
        category.put(imageLoc, text);
    }


    /**
     * returns the name of the category
     * @return the name of the category
     */
    public String getCategory(){
        return this.newCategory;
    }

    
    /**
     * returns the text associated with the given image loc in this category
     * @param imageLoc the location of the image
     * @return the text associated with the image
     */
    public String getText(String imageLoc){
        return category.get(imageLoc);
        /*
        if (AACCategoryName.containsKey(imageLoc)){
            String text = AACCategoryName.get(imageLoc);
            return text;
        }
        
        return "no text for this image";
        */
    }

    /**
     * determines if the provided images is stored in the category
     * @param imageLoc the location of the category
     * @return true if it is in the category, false otherwise
     */
    public boolean hasImage(String imageLoc){
        if (category.containsKey(imageLoc)){
            return true;
        }
        return false;
    }

    /**
     * returns an array of all the images in the category
     * @return the array of image locations
     */
    public String[] getImages(){
        ArrayList<String> imagesList = new ArrayList<>();
        for (String key:category.keySet()){
            imagesList.add(key);
        }
        String[] images = (String[]) imagesList.toArray();
        return images;
    }

}
