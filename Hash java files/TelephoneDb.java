package TDHashProject;

public class TelephoneDb {

    LinkedList object = new LinkedList();

    public TelephoneDb()
    {
        //check
    }

    public void insert(String name, String address, String number)
    {
        //Performing hashing now
        int index = Math.abs(name.hashCode()) % MainFile.hashnum;
        
        if (object.get(name, index) == null)
        {
            UserNode entry = new UserNode(name,address,number);
            object.add(entry, index);
            //If new entry, it creates UserNode object for the person's information
            //Then adds it to the hashtable in appropriate Linked List
        }
        else
        {
            UserNode updatePerson = object.get(name,index);
            updatePerson.setAddress(address);
            updatePerson.setNumber(number);
            //If an entry already exists for that name then update the address and the phone number
        }
    }

    public UserNode retrieve(String name)
    {
        int index = Math.abs(name.hashCode()) % MainFile.hashnum; //Hashing the name
        return object.get(name,index);
        //Searching the LL for appropriate name from the UserNode
    }

    public UserNode delete(String name)
    {
        int index = Math.abs(name.hashCode()) % MainFile.hashnum;
        return object.remove(name, index);
        //Deleting the respective UserNode object and returning the details
    }

    public void displayBook()
    {
        for (int index =0; index <= (MainFile.hashnum -1); ++index)
        {
            System.out.println(" \n Telephone Database [" + index + "] : ");
            object.display(index);
            //For displaying the entire LL as required
        }
    }

    public void writeOutput() throws Exception
    {
        object.print();
        //Used to copying all the Phonebook Database to output csv file
   }

}