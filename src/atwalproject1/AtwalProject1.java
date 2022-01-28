package atwalproject1;
import java.util.*; //import scanner
/**
 *
 * @author Brandon Atwal
 * BSA190001
 * CS 3345.0W3
 */
public class AtwalProject1 {
    Scanner keyboard;
    String[] ops; //possible operations
    int choice;   //user input choice
    LinkedList<Product> list;
    
    AtwalProject1(){
        keyboard = new Scanner(System.in);
        ops = new String[]{ "Make Empty",
                "Find ID",
                "Insert At Front",
                "Delete From Front",
                "Delete ID",
                "Print All Records",
                "Done"};
        list = new LinkedList();
    }
    
    //main menu/loop
    public void run(){
        choice = 0;
        do{
            System.out.println("Operations on List");
            for (int i=0; i<ops.length; i++){ //output operation choices
                System.out.println(" " + (i+1) + ". " + ops[i]);
            }
            choice = getInt("\tYour choice: ") - 1;
            switch(choice)
            {
                case 0: list.makeEmpty(); System.out.println("\tList emptied."); 
                        break;                              //Make Empty
                case 1: findID(); break;                    //Find ID
                case 2: insertAtFront(); break;             //Insert At Front
                case 3: deleteFromFront(); break;           //Delete From Front
                case 4: deleteID(); break;                  //Delete ID
                case 5: printAllRecords(); break;           //Print All Records
                case 6: System.out.println("\tDone."); break; //Done
                default:
                    System.out.println("\tPlease enter a valid operation");
            }
        }while(choice != 6); //if choice done, break and end program. Also restart if invalid choice
    }
    
    //get integer with input checking
    int getInt(String msg){
        System.out.print(msg);
        boolean t = keyboard.hasNextInt();
        while (!t){
            System.out.print("Invalid input. Please enter an integer.\n" + msg);
            keyboard.next();
            t = keyboard.hasNextInt();
        }
        int r = keyboard.nextInt(); keyboard.nextLine(); 
        return r;
    }
    
    void findID(){
        int id = getInt("\tID No: ");
        Product result = list.findID(id);
        if (result == null){
            System.out.println("\tNo product with that ID found.");
        }else{
            result.printID();
        }
    }
    
    void insertAtFront(){
        int id = getInt("\tEnter Product ID: ");
        System.out.print("\tEnter Product Name: ");
        String pName = keyboard.nextLine();
        System.out.print("\tEnter Supplier Name: ");
        String sName = keyboard.nextLine();
        
        Product p = new Product(id, pName, sName);
        boolean success = list.insertAtFront(p);
        if (success)
            System.out.println("\t...\n\tProduct Added");
        else
            System.out.println("\t...\n\tFailed to add. A product with this ID already exists");
    }
    
    void deleteFromFront(){
        Product deleted = list.deleteFromFront();
        if (deleted == null)
            System.out.println("\tList is empty. Could not delete.");
        else{
            deleted.printID();
            System.out.println("\tFirst item deleted");
        }
    }
    
    void deleteID(){
        int id = getInt("\tID No: ");
        Product result = list.delete(id);
        if (result == null){
            System.out.println("\tNo product with that ID found.");
        }else{
            result.printID();
            System.out.println("\tProduct deleted.");
        }
    }
    
    void printAllRecords(){
        list.printAllRecords();
    }
    
    public static void main(String[] args) {
        AtwalProject1 app = new AtwalProject1();
        app.run();
    }
    
}
