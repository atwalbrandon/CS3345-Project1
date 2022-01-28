package atwalproject1;

/**
 *
 * @author Brandon Atwal
 */
public class Node<AnyType extends IDedObject>{
    AnyType element;
    Node link;
    Node(){
        this(null,null);
    }
    Node(AnyType e, Node l){
        element = e;
        link = l;
    }
    void setElement(AnyType e){
        element = e;
    }
    void setLink(Node l){
        link = l;
    }
    AnyType getElement(){
        return element;
    }
    Node getLink(){
        return link;
    }
}