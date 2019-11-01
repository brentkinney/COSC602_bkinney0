/**
 * The class of singly linked list node.
 */
package collection;

/**
 * @author	David Zheng
 * @version	1.0
 */
public class SLListNode 
{
	public Object data;
	public SLListNode next;
	
	/**
	 * @param	d	The real data to be saved into the SLListNode.
	 * @param	n	The reference to the next node in the SLList.
	 */
	public SLListNode(Object d, SLListNode n)
	{
		data = d;
		next = n;
	}
}
