/*

 Problem:- Implement k stacks in a single array.
 
*/


import java.io.*;

class KStack
{
	int k;			//number of stacks in single array
	int size;		//size of the array
	int arr[];		//for actual storage of elements
	int top[];		//for storing top element of stack for each stack
	int next[];		//for pointing to the next element 
	
	int free;		//to specify the next free location
	
	KStack()		//default constructor (not actual needed)
	{
		k = 1;
		size = 5;
		arr = new int[size];
		top = new int[k];
		next = new int[size];
		
		for(int i = 0; i < k; i++)
			top[i] = -1;
		
		for(int i = 0; i < size-1; i++)
			next[i] = i+1;
		next[size-1] = -1;
		
		free = 0;
	}
	
	KStack(int k, int size)		//parameterized constructor
	{
		this.k = k;
		this.size = size;
		arr = new int[size];
		top = new int[k];
		next = new int[size];
		
		for(int i = 0; i < k; i++)
			top[i] = -1;
		
		for(int i = 0; i < size-1; i++)
			next[i] = i+1;
		next[size-1] = -1;
		
		free = 0;			
	}
	
	
	public boolean isFull()
	{
		if(free == -1)
			return true;
		
		return false;
	}
	
	public boolean isEmpty(int stackNo)
	{
		if(top[stackNo] == -1)
			return true;
		
		return false;
	}
		
	
	public void push(int stackNo, int data)
	{
		if(isFull())
		{
			System.out.println("\nArray full. Cannot insert.\n");
			return;
		}
		
		int insertionPosition = free;	//get the free location in array for insertion
		
		arr[insertionPosition] = data;	//insert the data
		
		free = next[insertionPosition];			//update free to the next unused location
		next[insertionPosition] = top[stackNo];		//this will help us point to previous location while popping from stack 
		top[stackNo] = insertionPosition;			//top of stack will be current insertion position
		
		System.out.println("\nElement "+data+" pushed onto stack "+stackNo+"\n");
		
	}
	
	public int pop(int stackNo)
	{
		if(isEmpty(stackNo))
		{
			System.out.println("\nStack "+stackNo+" is Empty. Cannot pop.");
			return -1;
		}
		
		int deletionPosition = top[stackNo];	//get the index of top element of stack	
		int popedValue = arr[deletionPosition];		//store the deleted value
		
		top[stackNo] = next[deletionPosition];		//point the top of stack to previous position
		next[deletionPosition] = free;		//make the next[deletionPosition] point to next free location
		free = deletionPosition;		//make free point to current deletion position
		
		return popedValue;
	}
	
	
	public void printStack(int stackNo)
	{
		if(isEmpty(stackNo))
		{
			System.out.println("Stack "+stackNo+" Empty.");
			return;
		}
		
		System.out.println("\nElements of stack "+stackNo+" are:- ");
		for(int i = top[stackNo]; i != -1; i = next[i])
			System.out.println(arr[i]);
		
		System.out.println();
	}
	
	
	
	
}

public class KStacksinArray 
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0,data,stackNo;
		
		System.out.print("Enter the size of array:- ");
		int size = Integer.parseInt(br.readLine());
		
		System.out.print("\nEnter number of stacks:-");
		int k = Integer.parseInt(br.readLine());
		
		KStack kstack = new KStack(k,size);
		
		do
		{
			System.out.println("\nMenu:- \n1.Insert element into a stack \n2.Pop Element from a stack \n3.Print a stack \n0.Exit");
			ans = Integer.parseInt(br.readLine());
			
			switch(ans)
			{
			case 1:
				{
					System.out.print("Enter data:- ");
					data = Integer.parseInt(br.readLine());
					System.out.print("\nEnter stack Number:- ");
					stackNo = Integer.parseInt(br.readLine());
					
					kstack.push(stackNo, data);
					break;
				}
			case 2:
				{
					System.out.print("\nEnter stack Number:- ");
					stackNo = Integer.parseInt(br.readLine());
					
					int popedValue = kstack.pop(stackNo);
					
					if(popedValue != -1)
						System.out.println("Elemenet "+popedValue+" popped from stack "+stackNo);
					break;
				}
			case 3:
				{
					System.out.print("\nEnter stack Number:- ");
					stackNo = Integer.parseInt(br.readLine());
					
					kstack.printStack(stackNo);
					break;
				}
			case 0:
					break;
			default:
				{
					System.out.println("\nInvalid Case.\n");
				}
			}
		}while(ans != 0);
	}
}
