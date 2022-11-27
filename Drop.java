
/**
 * Write a description of class Drop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Drop extends Command
{
    
    /**
     * Constructor for objects of class Drop
     */
    public Drop(String parameter)
    {
        super(parameter);
    }

    @Override
    public String process(GameStatus gamestatus)
    {
       if(!hasParameter()) {
            return "drop what?";
        }
        String itemToDrop=getParameter();
        if(itemToDrop.equals("all")){
            gamestatus.dropAll();
            return "you have dropped all your items";
        }
        Item item= gamestatus.getItemsCollected().findItem(itemToDrop);
        if (item!=null){
            gamestatus.getItemsCollected().removeItem(item);
            return "your item has been dropped";
        }
        else{return "you didn't collect that item";}
    }
}
