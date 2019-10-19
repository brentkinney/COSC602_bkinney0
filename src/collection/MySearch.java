/**
 * Implement a simple binary and linear search on MyVector object.
 * Part of the code is from a textbook.
 */
package collection;

/**
 * @author	David Zheng
 * @version	1.0
 */
public class MySearch {
    private MySearch() {}  // Prevent instantiation.
    
    /**
     * Do linear search for the target on the vector.
     * Assuming the vector is sorted in increasing order.
     * @param	vec		The vector to be searched.
     * @param	target	The object to be searched.
     * @return			The index of the found value, -1 otherwise.
     */
    public static int linearSearchSorted(MyVector vec, Comparable target)
    {
        int j;
        for (j = 0; j < vec.size() && target.compareTo(vec.elementAt(j)) > 0; j++);
        
        if (j < vec.size() && target.compareTo(vec.elementAt(j)) == 0)
            return j;
        return -1;
    }
    
    /**
     * Do binary search for the target on the vector.
     * Assuming the vector is sorted in increasing order.
     * @param	vec		The vector to be searched.
     * @param	target	The object to be searched.
     * @return			The index of the found value, -1 otherwise.
     */
    public static int binarySearch(MyVector vec, Comparable target)
    {
        int first = 0,
            last = vec.size() - 1,
            middle;
        while (last - first >= 0)
        {
            middle = (first + last) / 2;
            if (target.compareTo(vec.elementAt(middle)) < 0)
                last = middle - 1;
            else if (target.compareTo(vec.elementAt(middle)) > 0)
                first = middle + 1;
            else
                return middle;
        }
        return -1;
    }


}
