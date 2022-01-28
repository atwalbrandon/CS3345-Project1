package atwalproject1;

/**
 *
 * @author Brandon Atwal
 */
public class Product implements IDedObject{
    private int productID;
    private String productName, supplierName;
    
    public int getID(){
        return productID;
    }
    
    //prints all variable values on separate lines, per instructions
    public void printID(){ 
        System.out.println("\t"+productID+"\n\t"+productName+"\n\t"+supplierName);
    }
    
    public Product()
    {
        productID = 0;
        productName = "None Given";
        productName = "None Given";
    }
    
    public Product(int id, String pName, String sName){
        productID = id;
        productName = pName;
        supplierName = sName;
    }
}
