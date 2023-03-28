import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    private HashMap<String, Room> exits = new HashMap<>();

    List<Objeto> objetos = new ArrayList<>();

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

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east exit.
     * @param south The south exit.
     * @param west The west exit.
     */

    /** Adiciona uma saida, se nao existir uma sala que ocupa essa mesma direcao **/
    public void setExit(Room destination, String direction){
        if (exits.containsKey(direction) == false){
            exits.put(direction, destination);
        }
    }

    /** Retorna true se a sala possuir uma saida na direcao especificada **/
    public boolean exitExists(String direction){
        if exits.containsKey(direction){
            return true;
        }else{
            return false;
        }
    }

    /** Retorna a sala que esta na direcao especificada **/
    public Room getRoom(String direction){
        if exitExists(direction){
            return exits.get(direction);
        }
    }

    /** Realiza um loop e imprime todas as direcoes onde existe uma sala na sala atual **/
    public void printExits(){
        System.out.println("Saidas: ")
        for (String path : exits.keySet()){
        System.out.println(path);
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }


}
