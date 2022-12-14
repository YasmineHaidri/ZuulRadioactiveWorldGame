/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  The exits are labelled north,
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room
{
    private String description;
    private Exits exits = new Exits();
    private Items items = new Items();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
    }
    public void setExit(String d, Room r){exits.add(d,r);}

    public void addItem(Item i){items.add(i);}

    public Room getExit(String d){return exits.get(d);}
    public String getItems(){return items.getDescription();}
    public Items returnItems(){return items;}
    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description + "\n"
        + items.getDescription() +"\n"
        + exits.getDescription();
    }

}
