/**
 * A sorted linked list that can store comparables
 */
public class SortedList
{

	private ListNode head;

	public SortedList()
	{
		head = null;
	}

	/**
	 * Inserts a new list node
	 * @param value
	 */
	public void insert(Comparable value)
	{
		if (head == null)
		{
			// empty list
			head = new ListNode(value, null);
		}
		else if (value.compareTo(head.getValue()) < 0)
		{
			// new first on nonempty list
			head = new ListNode(value, head);
		}
		else
		{
			ListNode searcher = head;
			boolean done = false;
			while (!done)
			{
				if (searcher.getNext() == null)
				{
					// not in list
					done = true;
				}
				else if (value.compareTo(searcher.getNext().getValue()) <= 0)
				{
					// found node to insert after
					done = true;
				}
				else
				{
					// keep searching
					searcher = searcher.getNext();
				}
			}

			// insert new node after searcher
			ListNode temp = new ListNode(value, searcher.getNext());
			searcher.setNext(temp);
		}

	}

	/**
	 * searches for an Object
	 * @param value
	 * @return
	 */
	public Object search(Comparable value)
	{
		ListNode searcher = head;
		while (true)
		{
			if (searcher == null)
			{
				// End of list
				return null;
			}
			else if (value.compareTo(searcher.getValue()) < 0)
			{
				// in the middle
				return null;
			}
			else if (value.compareTo(searcher.getValue()) == 0)
			{
				// found it!
				return searcher.getValue();
			}
			else
			{
				searcher = searcher.getNext();
			}
		}
	}

	/**
	 * Removes a ListNode that has a certain value
	 * @param value
	 * @return
	 */
	public Object remove(Comparable value)
	{
		if (head == null)
		{
			// empty
			return null;
		}
		else if (value.compareTo(head.getValue()) < 0)
		{
			// Before the beginning
			return null;
		}
		else if (value.compareTo(head.getValue()) == 0)
		{
			// Value is head
			Object temp = head.getValue();
			head = head.getNext();
			return temp;
		}
		else
		{
			ListNode searcher = head;
			while (true)
			{
				if (searcher.getNext() == null)
				{
					// End of list
					return null;
				}
				else if (value.compareTo(searcher.getNext().getValue()) < 0)
				{
					// in the middle
					return null;
				}
				else if (value.compareTo(searcher.getNext().getValue()) == 0)
				{
					// found it!
					Object temp = searcher.getNext().getValue();
					searcher.setNext(searcher.getNext().getNext());
					return temp;
				}
				else
				{
					searcher = searcher.getNext();
				}
			}
		}
	}

	/**
	 * returns the sorted list as a String - there are line breaks in between each node
	 */
	public String toString()
	{
		String listAsString = "";
		ListNode searcher = head;
		
		if (head == null)
		{
			return "null";
		}
		else
		{
			while (searcher != null)
			{
				listAsString += searcher.getValue() + "\n";
				searcher = searcher.getNext();
			}
		}
		
		return listAsString;
	}
}
