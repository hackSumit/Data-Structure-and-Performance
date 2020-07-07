package textgen;

import java.util.AbstractList;



/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
			size=0;
			head=new LLNode<E>(null);
			tail=new LLNode<E>(null);
			head=tail;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
		LLNode<E> temp=new LLNode<E>(element,null,tail);
		if(temp.data==null)
		{
			throw new NullPointerException();
		}
		if(tail != null)
        {
        tail.next = temp;   
        }
        tail = temp;
        if(head == null) { head = temp;}
        size++;
        return true;	
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> cur=head;
		E data=null;
		int count=0;
		if(index>size|| index<=-1)
		{
			throw new IndexOutOfBoundsException();
		}else
		{
			while(cur!=null)
			{
				if(count==index) {
				 data=cur.data;
				return data;
				}
				count++;
				cur=cur.next;
			}
		}
		return data;
				
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index<=-1||index>size)
		{
			throw new IndexOutOfBoundsException();
			
		}
		if(element==null)
		{
			throw new NullPointerException();
		}
		
		LLNode<E> temp=new LLNode(element,null,null);
		LLNode<E> cur=head;
		if(index==0)
		{
			temp.next=cur;
			cur.prev=temp;
			head=temp;
			size++;
		}else {
		 for (int i = 0; i <size; i++) 
	        { 

			 if(i==index)
			 {
			cur.prev.next=temp;
			temp.prev=cur.prev;
			cur.prev=temp;
			temp.next=cur; 
		    size++;
		    return;
				 }
	        
			 cur=cur.next; 
			
	        }
		}	
		
	}
 
 


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> cur=head;
		E remData=null;
		if(index<=-1 ||index >size)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		
		//Now to loop through that index inorder to delete
		
		
		if(index==0)
		{
			head=cur.next;
			remData=cur.data;
			size--;
		}else {
		
		for(int i=0;cur!=null&& i<size;i++)
		{
			
		//If deletion is at the end	
			if(i==size-1)
			{
				cur.prev.next=cur.next;	
				remData=cur.data;
				size--;
			}
//			//deletion at middle
			else if(i==index) 
			{
			cur.prev.next=cur.next;
			cur.next.prev=cur.prev;
			remData=cur.data;
			size--;
			}
		cur=cur.next;
			}
		}
		return remData;		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index<=-1||index>size)
		{
			throw new IndexOutOfBoundsException();
			
		}
		if(element==null)
		{
			throw new NullPointerException();
		}
		
		//check for the specified value and display
		LLNode<E> temp=head;
		E changedData=null;
		for(int i=0;i<index&& temp!=null;i++)
		{
		temp=temp.next;
		}
		changedData=temp.data;
		temp.data=element;
		 return changedData;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode(E element, LLNode<E> next,LLNode<E> prev) {
		this.data = element;
        this.prev = prev;
        this.next = next;
       
    }

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
