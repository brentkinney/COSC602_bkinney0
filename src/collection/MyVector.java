/**
 * The implementation of the vector ADT.
 * It is not meant to be a complete implementation of vector ADT.
 */
package collection;

/**
 * Implements a simplified version of the vector ADT.
 * Note: The clone method below only make a shallow copy of this MyVector object.
 * @author	David Zheng
 */
public class MyVector implements Cloneable {
	static final int INITIAL_CAPACITY = 100;
	Object [] data;
	int size;
	
	/**
	 * Default constructor
	 */
	public MyVector(){
		data = new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * Appends the element at the end of the vector.
	 * @param	element	The element to be appended.
	 */
	public void append(Object element){
		if (size == data.length) expand();
		
		data[size++] = element;
	}
	
	/*
	 * Doubles the current capacity.
	 */
	void expand(){
		Object [] temp = new Object[data.length * 2];
		
		for(int i = 0; i < size; ++i){
			temp[i] = data[i];
		}
		
		data = temp;
	}
	
	/**
	 * Make the vector collection empty.
	 */
	public void clear(){
		for(int i = 0; i < size; ++i)
			data[i] = null;
		size = 0;
	}
	
	/**
	 * Check whether the vector contains the element.
	 * @param	element	The element to be checked upon.
	 * @return			true if the element is in the vector, false otherwise.
	 */
	public boolean contains(Object element){
		for(int i = 0; i < size; ++i)
                {
			if (element.equals(data[i]))
				return true;
                }
		return false;
	}
	
	/**
	 * Access the element at the given index.
	 * @param	index	The index of the element to be accessed.
	 * @return			The Object at the index.
	 */
	public Object elementAt(int index){
		if (index < 0 || index >= size)
			return null;
		return data[index];
	}
	
	/**
	 * Find the index of the element.
	 * @param	element	The element that its index needs to be found.
	 * @return			The index of the element, if no such element return -1.
	 */
	public int indexOf(Object element){
		for(int i = 0; i < size; ++i)
			if (element.equals(data[i]))
				return i;
		return -1;
	}
	
	/**
	 * Insert the element at the given index.
	 * @param	index	The index of the location to be inserted.
	 * @param	element	The element to be inserted.
	 * @return			true if succeeds, false otherwise.
	 */
	public boolean insertAt(int index, Object element){
		if (index < 0 || index >= size) return false;
		
		if (size == data.length) expand();
		
		for (int i = size; i > index; --i)
			data[i] = data[i-1];
		data[index] = element;
		++size;
		return true;
	}
	
	/**
	 * Check whether the vector is empty.
	 * @return			true if it is empty, false otherwise.
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * Remove the element at the given index.
	 * @param	index	The index of the element to be removed.
	 * @return			The element being removed.
	 */
	public Object removeAt(int index){
		if (index < 0 || index >= size)
			return null;
		
		Object temp = data[index];
		while (index < size-1){
			data[index] = data[index+1];
			index++;
		}
		data[--size] = null;
		return temp;
	}
	
	/**
	 * Remove the element from the vector.
	 * @param	element	The element to be removed.
	 * @return			true if succeeds, false otherwise.
	 */
	public boolean remove(Object element){
		return removeAt(indexOf(element)) != null;
	}
	
	/**
	 * Replace the current element at the given index with the given element.
	 * @param	index	The index of the element to be replaced.
	 * @param	element	The element used to replace the current one.
	 * @return			true if succeeds, false otherwise.
	 */
	public boolean replace(int index, Object element){
		if (index < 0 || index >= size)
			return false;
		data[index] = element;
		return true;
	}
	
	/**
	 * Get the number of elements in the current vector.
	 * @return			size of the current vector.
	 */
	public int size(){
		return size;
	}
	
	/**
	 * Make sure the vector gets at least the given capacity.
	 * @param	minCapacity	The minimal value of capacity to be insured.
	 */
	public void ensureCapacity(int minCapacity){
		if(minCapacity <= data.length - size)
			return;
		Object [] newData = new Object[minCapacity + size];
		for (int i = 0; i < size; ++i){
			newData[i] = data[i];
		}
		data = newData;
	}
	
	/**
	 * Clone a copy of the current vector.
	 * @return			The cloned copy of the current vector.
	 */
	public MyVector clone(){
		MyVector vecCopy = new MyVector();
		vecCopy.ensureCapacity(this.size);
		for (int i = 0; i < size; ++i){
			vecCopy.data[i] = this.data[i];
		}
		vecCopy.size = this.size;
		return vecCopy;
	}
	
	/**
	 * Merge the elements from the vect into this MyVector.
	 * @param	vect		The MyVector to copy elements from.
	 */
	public void merge(MyVector vect){
		for (int i = 0; i < vect.size(); ++i){
			this.append(vect.elementAt(i));
		}
	}
	
	/**
	 * Removes a range of elements from this vector.
	 * @param	fromIndex	The starting index, inclusive.
	 * @param	toIndex		The ending index, exclusive.
	 */
	public void removeRange(int fromIndex, int toIndex){
		if (fromIndex >= toIndex)
			return;
		if (fromIndex < 0)
			fromIndex = 0;
		if (toIndex >= size)
			toIndex = size;
		int num = toIndex - fromIndex;
		for (int i = fromIndex; i < size - num; ++i){
			data[i] = data[i + num];
		}
		for (int j = size - num; j < size; ++j){
			data[j] = null;
		}
		size = size -num;
	}
	
	/**
	 * Reverse the order of the elements in the vector.
	 */
	public void reverse(){
		Object temp;
		for (int i = 0; i < size/2; ++i){
			temp = data[i];
			data[i] = data[size - i - 1];
			data[size - i - 1] = temp;
		}
	}
	
	/**
	 * Get a String representation of the current vector including each element.
	 * @return			The String representation.
	 */
	public String toString(){
		String str = "+++++++++++++++++++++++++++++++++++++++++++++\n" +
					 "The current vector contains the following: \n";
		str += "size = " + size + "\n";
		str += "capacity = " + data.length + "\n";
		for (int i = 0; i < size; ++i){
			str += i + ": " + data[i] + "\t";
			if((i+1)%5 == 0)
				str += "\n";
		}
		str += "\n+++++++++++++++++++++++++++++++++++++++++++++\n";
		return str;
	}
}
