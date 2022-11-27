
/**
 * uncomment the implements part if you want the compiler to help
 * with the correct method signatures.
 */
import java.util.*;
public class GameStatus
{
    private Room currentRoom;
    private Room lastRoom;
    private Room beamer;
    private HashSet<Room> visited;
    private int numberOfRooms;
    private boolean seenAll = false;
    private Items collected;
    private int weightCollected;
    private final int maxWeight=26;
    private int radiationSumme;

    public GameStatus(Room initialRoom){
        setLocation(initialRoom);
        HashSet<Room> visited= new HashSet();
        collected=new Items();
        visited.add(initialRoom);
    }

    public void setLocation(Room room){
        lastRoom = currentRoom;
        currentRoom = room;
        //visited.add(room);
        //seenAllRooms();
    }

    public Room getLocation(){
        return currentRoom;
    }

    public boolean goBack(){
        if (lastRoom == null)
            return false;
        currentRoom = lastRoom;
        lastRoom = null;
        return true;
    }

    public void chargeBeamer(){
        beamer = currentRoom;
    }

    public boolean fireBeamer(){
        if (beamer == null) return false;
        setLocation(beamer);
        beamer = null;
        return false;
    }
    
    public String getLocationDescription(){
        return "You are " +currentRoom.getDescription();
    }
     public String collectItem(Item item){
         weightCollected+=item.getWeight();
         if(!weightUberlauf()){
         collected.add(item);
         
         if(!item.getName().equals("Dirty-Bomb")){
         int radiation=Integer.parseInt(item.getDescription());
         radiationSumme+=radiation;}
         else  {radiationSumme=radiationSumme*2;}
         win();
        return"your item has been successfully collected";}
        else {
            weightCollected+=item.getWeight();
            return"your items weigh too much, you have to drop some of them";}
         }
    public Items getItemsCollected(){return collected;}
    public void dropAll(){collected=null;}
    public boolean weightUberlauf(){
        return weightCollected>maxWeight;
    }
    private boolean playing = true;
    public void quit(){playing = false;}
   /* public void seenAllRooms(){
        if (visited.size()==12){System.out.println("Congratulations! you've"+
            "seen all rooms");}
    }*/
    public void win(){
    if (radiationSumme==20)
    {playing=false; 
    System.out.println("Congratulation! you collected enough radiation and won");
    }}
    public boolean isPlaying(){return playing;}

}
