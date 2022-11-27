import java.util.*;
/**
 * Write a description of class Take here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Take extends Command
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Take
     */
    public Take(String parameter)
    {
        super(parameter);
    }

    @Override
    public String process(GameStatus gamestatus)
    {
        if(!hasParameter()) {
            return "take what?";
        }
        String itemRequired= getParameter();
        Items itemsAvailable=gamestatus.getLocation().returnItems();
        Item item=itemsAvailable.findItem(itemRequired);
        if(item==null){
            return "this item isn't available in the room";
        }
        else{
            return gamestatus.collectItem(item);
        }
    }
}
