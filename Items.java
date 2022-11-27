import java.util.*;
import java.util.stream.Collectors;
public class Items
{  
    List<Item> items ;
    public Items(){ 
    items= new ArrayList<>();
    }
    public void add(Item i){items.add(i);};
   
      public String getDescription(){
        if (items.isEmpty()) return "";
        return "Items:\n" + items.stream().map(i -> " - "+i.getName()).collect(Collectors.joining("\n"));
    }
    public Item findItem(String itemName){
        int i=0;
        boolean found=false;
        Item returned=null;;
        while( i<items.size()){
        if (items.get(i).getName().equals(itemName)){
            found=true;
            returned= items.get(i);
            break;
        } 
        i++;
        } 
        return returned;
      }
      public void removeItem(Item item){
          Iterator<Item> it= items.iterator();
          boolean erased=false;
          while (it.hasNext()){
           Item anyItem=it.next();
           if(anyItem==item){
               it.remove();
               break;
             }   
            }   
    }
}
