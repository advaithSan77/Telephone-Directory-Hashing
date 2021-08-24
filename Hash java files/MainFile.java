package TDHashProject;

import java.util.Scanner;
import java.io.File;

public class MainFile {

    //Initializing hashnum, value can be changed based on hash table size req
    public static final int hashnum = 7;

    static Scanner scInput = new Scanner(System.in);

    public static void main(String[] args) throws Exception
    {
        System.out.println("Type 1 for Hash Table");
        int a = scInput.nextInt();
        if (a==1)
        {
            hash();
        }
    }

    public static void hash() throws Exception
    {

        TelephoneDb list = new TelephoneDb();
        Scanner sc = new Scanner (new File("input_data.csv"));
        while (sc.hasNextLine())
        {
            String str = sc.nextLine();
            String [] array = str.trim().split(",");
            list.insert(array[0],array[1],array[2]);
            //Inserts respective name,address and phno into hash table as extracted
        }

        int ch=0;
        while (ch!= 5)
        {
            System.out.println("\nHash Table Menu");
			System.out.println("1. Insert Telephone Number\n2. Retrieve required Telephone Number\n3. Delete a Telephone Number\n4. Display the Telephone Database\n5. End Given Program");
			System.out.print("Enter choice from (1-5): ");
            ch = scInput.nextInt();
            switch (ch)
            {
                case 1:
                //User enters name,address and telephone number
                    System.out.println("\n Enter your Name: ");
                    String inputName = scInput.next();
                    System.out.println("\n Enter your Address: ");
                    scInput.nextLine();
                    String inputAddr = scInput.nextLine();
                    System.out.println("\n Enter Phone Number: ");
                    String inputNumber = scInput.next();
                    //User can enter any format, so considering it as a .next() and not nextInt()
                    list.insert(inputName,inputAddr,inputNumber);
                    break;
                
                case 2:
                    //Retrieving required Telephone Records
                    Scanner ip = new Scanner(System.in);
                    System.out.print("\nEnter required Person's name: ");
                    String retrPerson = ip.nextLine();

                    UserNode retrieved = list.retrieve(retrPerson);
                
                    if (retrieved == null)
                    {
                        //If person does not exist in the Database
                        System.out.println("\n"+ retrPerson + " does not exist in the Telephone Database");
                    }
                    else
                    {
                        System.out.println(retrieved.name + "'s Address is : " + retrieved.address);
                        System.out.println(retrieved.name + "'s Phone Number is : "+ retrieved.number);
                    }
                    break;

                case 3:
                    //Deleting a given person's record from the Telephone Database
                    System.out.print("\n Enter required Person's name: ");
                    String delPerson = scInput.next();
                    UserNode deleted = list.delete(delPerson);

                    if (deleted == null)
                    {
                        System.out.println("\n"+ delPerson + "does not exist in the Telephone Database");
                    }
                    else
                    {
                        System.out.println("Deleting "+ deleted.name + " Address:" + deleted.address + " Phone number: " + deleted.number);
                    }
                    break;
                
                case 4:
                    //Displaying details
                    System.out.print("\n Displaying Database \n");
                    list.displayBook();
                    System.out.println("");
                    break;
                
                case 5:
                    //Ending the program
                    list.writeOutput();
                    System.out.println("\n Data has been written to the .csv file ");
                    break;

            
            }
        }
    }
}