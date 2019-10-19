/**
 * This class implements several sorting algorithms.
 * Part of the code is from a textbook.
 */
package collection;

/**
 * The vector passed into the sorting methods will be sorted.
 *
 * @author	David Zheng
 * @version     1.0
 */
public class MySort {

    private MySort() {}  // Prevent instantiation.

    /**
     * This will sort a MyVector using a selection sort.
     *
     * @param	vec	The vector to be sorted
     * @return	The sorted MyVector
     */
    public static MyVector selectionSort(MyVector vec) {
        int i,
                j,
                n = vec.size(),
                smallPos;
        Comparable smallest,
                current;
        for (i = 0; i < n - 1; i++) {
            smallPos = i;
            smallest = (Comparable) vec.elementAt(smallPos);
            for (j = i + 1; j < n; j++) {
                current = (Comparable) vec.elementAt(j);
                if (current.compareTo(smallest) < 0) {
                    smallPos = j;
                    smallest = (Comparable) vec.elementAt(smallPos);
                }
            }
            if (smallPos != i) {
                swap(vec, i, smallPos);
            }
        }
        return vec;
    }

    /**
     * The method for swapping two elements on the vector.
     *
     * @param	vec	The vector in which the swapping will happen.
     * @param	first	The index of the first element to be swapped.
     * @param	second	The index of the second element to be swapped.
     */
    public static void swap(MyVector vec, int first, int second) {
        Object temp = vec.elementAt(first);
        vec.replace(first, vec.elementAt(second));
        vec.replace(second, temp);
    }

    /**
     * This method sorts a vector by way of an insertion sort
     *
     * @param vec the vector to be sorted
     * @param left the leftermost element in the vector
     * @param right the rightermost element in the vector
     */
    public static void insertionSort(MyVector vec, int left, int right) {
        int inner, outer;
        Object target;//can replace with temp

        for (outer = left + 1; outer <= right; outer++) {
            target = vec.elementAt(outer);
            inner = outer;
            while (inner > left && ((Comparable) vec.elementAt(inner - 1)).compareTo(target) > 0) {
                vec.replace(inner, vec.elementAt(inner - 1));
                inner--;

            }
            vec.replace(inner, target);
        }

    }

    /**
     * Generates the median of a vector
     *
     * @param vec the vector
     * @param left the left object
     * @param right the right object
     */
    public static void medianOf3(MyVector vec, int left, int right) {
        int middle = (left + right) / 2;
        if (((Comparable) vec.elementAt(left)).compareTo(vec.elementAt(middle)) > 0) {
            swap(vec, left, middle);
        }
        if (((Comparable) vec.elementAt(middle)).compareTo(vec.elementAt(right)) > 0) {
            swap(vec, middle, right);
        }
        if (((Comparable) vec.elementAt(left)).compareTo(vec.elementAt(middle)) > 0) {
            swap(vec, left, middle);
        }

    }

    /**
     * Partitions a vector
     *
     * @param vec the vector
     * @param left the left object
     * @param right the right object
     * @return int the partition
     */
    public static int partition(MyVector vec, int left, int right) {
        Object pivot = vec.elementAt((left + right) / 2);
        while (true) {
            while (((Comparable) vec.elementAt(++left)).compareTo(pivot) < 0);
            while (((Comparable) vec.elementAt(--right)).compareTo(pivot) > 0);
            if (left > right) {
                break;
            } else {
                swap(vec, left, right);
            }

        }
        return left;
    }

    /**
     * QuickSort method
     *
     * @param vec the method
     * @param left the left object
     * @param right the right object
     */
    public static void quickSort(MyVector vec, int left, int right) {
        if (right - left + 1 <= 10) {
            insertionSort(vec, left, right);
        } else {
            medianOf3(vec, left, right);
            int leftPtr = partition(vec, left, right);
            quickSort(vec, left, leftPtr - 1);
            quickSort(vec, leftPtr, right);
        }
    }

    /**
     * Merge Sorts a vector
     *
     * @param vec the vector
     * @param temp temporary comparable vector
     * @param left the left object
     * @param right the right object
     */
    public static void mergeSort(MyVector vec, Comparable[] temp, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2, i, j, k;
        mergeSort(vec, temp, left, mid);
        mergeSort(vec, temp, mid + 1, right);

        for (j = left; j <= right; j++) {
            temp[j] = (Comparable) vec.elementAt(j);
        }
        i = left;
        k = mid + 1;
        for (j = left; j <= right; j++) {
            if (i == mid + 1) {
                vec.replace(j, temp[k++]);
            } else {
                if (k > right) {
                    vec.replace(j, temp[i++]);

                } else {
                    if ((temp[i]).compareTo(temp[k]) < 0) {
                        vec.replace(j, temp[i++]);
                    } else {
                        vec.replace(j, temp[k++]);
                    }
                }
            }
        }

    }

}
