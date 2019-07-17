import java.io.*;

class Node			//Structure of a Single Node of the List
{
	int data;
	Node next;
	
	Node()
	{
		data = 0;
		next = null;
	}
	
	Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

public class LinkedList 	//Main Linked List Class with operations
{
	Node head;
	
	LinkedList()			//constructor which initializes head to null
	{
		head = null;
	}
	
	public boolean isEmpty()	//to check whether list is empty
	{
		if(head == null)
			return true;
		
		return false;
	}
	
	public void insertAtEnd(int data)	//function to insert at the end
	{
		Node newNode = new Node(data);
		
		if(isEmpty())		//if list is empty initialize head node
			head = newNode;
		else				//list not empty, traverse till the end and then add
		{
			Node temp = head;
			
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newNode;
		}
		
		System.out.println(newNode.data+" inserted at the end of the list.\n");
	}
	
	public void insertAtBeginning(int data) //function to insert at beginning
	{
		Node newNode = new Node(data);
		
		if(isEmpty())
			head = newNode;
		else					//Point the newNode's next to head and make the newNode as head
		{
			newNode.next = head;
			head = newNode;
		}
		
		System.out.println(newNode.data+" inserted at the beginning of the list.\n");
	}
	
	public void deleteElement(int data)		//function to delete specified element
	{
		if(isEmpty())		//List is Empty
		{
			System.out.println("Empty List. Cannot Delete.\n");
			return;
		}
		
		if(head.data == data)	//Element found at head. So move head to next node
		{
			head = head.next;
			System.out.println("Deletion of "+data+" successful.\n");
		}
		else
		{
			Node temp = head;
			boolean foundFlag = false;	//Flag used for searching
			
			while(temp.next != null)	//Search for the node previous to the one which we intend to delete
			{
				if(temp.next.data == data)
				{
					foundFlag = true;
					break;
				}
				
				temp = temp.next;
			}
			
			if(foundFlag == true)	//if found
			{
				Node del = temp.next;	
				temp.next = del.next;
				del.next = null;
				
				System.out.println("Deletion of "+data+" successful.\n");
			}
			else					//not found
			{
				System.out.println("Element not found in the list.\n");
			}
		}
	}
	
	public void printList()
	{
		if(isEmpty())
		{
			System.out.println("\nList Empty.");
			return;
		}
		
		Node temp = head;
		
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			
			if(temp.next != null)
				System.out.print("-> ");
			temp = temp.next;
		}
		System.out.println("\n");
	}

	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans,data;
		
		LinkedList list = new LinkedList();
		
		do
		{
			System.out.println("Menu:- \n1.Add Element at End \n2.Add Element at Beiginning \n3.Delete Element \n4.Print List \n0.Exit");
			ans = Integer.parseInt(br.readLine());
			
			switch(ans)
			{
			case 1:
				{
					System.out.print("\nEnter data:- ");
					data = Integer.parseInt(br.readLine());
					System.out.println();
					
					list.insertAtEnd(data);
					break;
				}
			case 2:
				{
					System.out.print("\nEnter data:- ");
					data = Integer.parseInt(br.readLine());
					System.out.println();
					
					list.insertAtBeginning(data);
					break;
				}
			case 3:
				{
					System.out.print("\nEnter data to be deleted:- ");
					data = Integer.parseInt(br.readLine());
					System.out.println();
					
					list.deleteElement(data);
					break;
				}
			case 4:
				{
					System.out.println();
					
					list.printList();
					break;
				}
			case 0:
					break;
			default:
				{
					System.out.println("\nInvalid Case.");
				}
			}
			
		}while(ans != 0);
	}

}
