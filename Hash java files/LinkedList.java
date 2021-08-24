package TDHashProject;

import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class LinkedList {
    
    UserNode[] TDArray = new UserNode[MainFile.hashnum];

    public LinkedList()
    {     //Constructor check with MainFile
    }
    
    public void add(UserNode entry, int index)
    {
        if (TDArray[index] == null)
        {
            TDArray[index] = entry; //If LL empty, make the UserNode obj the first entry
        }
        else
        {
            UserNode firstNode = TDArray[index];
            //getting index of the respective first node of LL
            entry.setNext(firstNode);
            TDArray[index] = entry;
        }
    }

    public UserNode get(String name, int index)
    {
        if (TDArray[index] == null) //if LL empty
        {
            return null;
        }
        else
        {
            UserNode entry = TDArray[index];
            while(entry!=null && !(entry.getName().equals(name)))
            {
                entry = entry.getNext(); //Traversing the LL till name matches
            }
            if (entry == null)
            {
                return null;
            }
            else
            {
                return entry;
            }
        }
        
    }

    public UserNode remove(String name, int index)
    {
        if (TDArray[index]!=null)
        {
            //if LL not empty
            UserNode prev = null;
            UserNode entry = TDArray[index]; //first ele in LL
            while (entry.getNext() != null && !(entry.getName().equals(name)))
            {
                prev=entry;
                entry = entry.getNext();
            }
            if (entry.getName().equals(name)) //If name matches
            {
                //If first entry
                if (prev == null)
                {
                    TDArray[index] = entry.getNext();
                    //Second element becomes first after deletion
                }
                else
                {
                    //If not the first entry
                    prev.setNext(entry.getNext());
                    //Connecting prev to next after deletion of current
                }
            }

            else
            {
                return null;
            }

            return entry;
        }
        return null;
    }

    public void display(int index)
    {
        UserNode pointer = TDArray[index];
        while (pointer!= null)
        {
            //Traversing the list for displaying
            System.out.print(pointer.name + ", "+ pointer.address + ", "+ pointer.number + " => ");
            pointer = pointer.getNext();
        }
        System.out.print("null");
    }

    public void print() throws IOException
    {
        FileWriter fw = new FileWriter("output_file.csv");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int index = 0; index <= ( MainFile.hashnum -1); ++index )
        {
            UserNode pointer = TDArray[index];
            while (pointer!=null)
            {
                bw.write(pointer.name + ", " + pointer.address + ", " + pointer.number + "\n"); //Writing info into buffer
                pointer = pointer.getNext();
            }
            bw.flush();
        }
        bw.close();
    }
}
