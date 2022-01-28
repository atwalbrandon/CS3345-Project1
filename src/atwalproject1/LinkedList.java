package atwalproject1;

/**
 *
 * @author Brandon Atwal
 */

//singly linked list
public class LinkedList<AnyType extends IDedObject>{
    Node front, rear;
    public LinkedList(){
        front = null;
        rear = null;
    }
    //empties the linked list
    void makeEmpty(){
        front = null;
        rear = null;
    }
    //get the generic type to get the particular
    //id and returns AnyType. Dont remove object from list. 
    //return null if list is empty or ID not found.
    AnyType findID(int ID){
        if (rear == null) return null; //if list is empty, id not found
        
        Node current = front;
        while (current != rear)
        {
            if (current.getElement().getID() == ID){
                return (AnyType)current.getElement(); //if ids match, return AnyType e
            }
            current = current.getLink(); //if no match, go to next node
        }
        if (rear.getElement().getID() == ID)
            return (AnyType)rear.getElement();
        
        return null; //id not found
    }
    
    

    //insert at front of list or return false if that id already exists
    boolean insertAtFront(AnyType x){
        if(rear == null || findID(x.getID()) == null){ //if list is empty || if the ID does not exist
            Node<AnyType> p = new Node<AnyType>(x,null);
            if (rear == null) //if list empty
                front = rear = p;
            else{ //if list not empty
                p.link = front;
                front = p;
            }   
                
            return true;
        }
        return false; //id already exists
    }
    //delete and return the record at front of the list return null if empty
    AnyType deleteFromFront(){
        if (rear != null) //if not empty
        {
            AnyType temp = (AnyType)front.getElement();
            if (front == rear){
                front = rear = null;
            }
            else
                front = front.getLink();
            return temp;
        }
        return null;
    }
    //find and delete the record with given id or returns null if not found
    AnyType delete(int ID){
        if (rear != null){ //if list not empty
            Node current = front;
            Node previous = null;
            if (front.getElement().getID() == ID){ //test front
                if (rear.getElement().getID() == ID){ //if it's the only element
                    makeEmpty();                      //clear
                }else{
                    front = current.getLink();
                }
                return (AnyType)current.getElement();
            }
                
            while (current != rear){ //test middle
                if (current.getElement().getID() == ID){ //if match
                    previous.setLink(current.getLink());
                    return (AnyType)current.getElement();
                }
                previous = current;
                current = current.getLink();
            }
            
            if (rear.getElement().getID() == ID){ //test rear
                previous.setLink(null);
                rear = previous;
                return (AnyType)current.getElement();
            }
        }
        return null;
    }
    //print all elements in the order they appear in the linked list
    //if list empty print apropriate message
    void printAllRecords(){
        if (rear == null)
            System.out.println("\tList is empty.");
        else{
            Node current = front;
            while (current != rear) //print all except rear
            {
                current.getElement().printID();  //print
                System.out.println();            //print blank line for spacing
                current = current.getLink();     //go to next node
            }
            rear.getElement().printID(); //print rear
        }
    }
}
