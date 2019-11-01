/**
 * A double-linked list node implementation to be used by the DLList class.
 */
package collection;

/**
 * Implements one node for the double-linked list.
 * 
 * @author David Zheng
 * @version 1.0
 */
public class DLListNode {
	public Object data;
	public DLListNode prev;
	public DLListNode next;
	
	/**
	 * The constructor for the DLListNode.
	 * 
	 * @param d the Object to set as the data
	 * @param p the PLListNode that is previous in the list
	 * @param n the DLListNode that is next in the list
	 */
	public DLListNode(Object d, DLListNode p, DLListNode n)
	{
		data = d;
		prev = p;
		next = n;
	}
}
