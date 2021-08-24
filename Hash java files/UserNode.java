package TDHashProject;

public class UserNode {

    UserNode next;
    UserNode leftChild;
    UserNode rightChild;
    String name;
    String address;
    String number;

    public UserNode()
    {
        number = null;
        address = null;
        name = null;
        next = null;
    }

    public UserNode(String name, String address, String number)
    {
        this.name = name;
        this.address = address;
        this.number = number;
        this.next = null;
        this.rightChild = null;
        this.leftChild = null;
    }

    //Returning respective name, address, telephone number and next person in the hash table

    public String getName()
    {
        return name;
    }

    public String getTelenumber()
    {
        return number;
    }

    public String getAddress()
    {
        return address;
    }

    public UserNode getNext()
    {
        return next;
    }

    //Setting the next person, number and address

    public void setNext(UserNode next)
    {
        this.next = next;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }    

}
