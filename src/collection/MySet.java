/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;


/**
 *
 * @author Brent
 * @version 10/18/19
 */
public class MySet extends MyVector {
    
    //default constructor for MySet
    public MySet () {
        
       data = new Object[INITIAL_CAPACITY];
		size = 0;
    }
    
    /**
     * Returns the number of elements in this MySet
     * @return the number of objects in the set
     */
    public int cardinality() {
        return size;
    }
    
    /**
     * returns a new set, this set - B
     * @param B the set to be removed
     * @return new set minus the values removed from given B
     */
    public MySet complement(MySet B) {
        MySet complement = new MySet();
        complement.ensureCapacity(this.size);
        complement = this.clone();
        for(int i = 0; i < size; ++i)
                {
                    if (this.contains(data[i]) == true)
                    {
                        complement.removeAt(i);
                    }
                }
        
        return complement;
    }
    
    /**
     * adds a new element to this set but excludes duplicates
     * @param element is the element to add
     * @return true if element is added and false if element given was a duplicate
     */
    public boolean add(Object element) {
        if (size == data.length) super.expand();
        
        if (this.contains(element) == false){
            data[size++] = element;
            return true;
        }
        return false;
    }
    
    /** returns a new set of this set intersection given B set
     * @param B the set to intersect with the current set
     * @return the new set intersection (values that are contained in both sets
     */
    
    public MySet intersection(MySet B) {
        MySet intersection = new MySet();
        for(int i = 0; i < size; ++i)
                {
                 for(int j =0; j < B.size; j++){
                     if(data[i] == B.data[j]){
                         intersection.add(B.data[i]);
                     }
                 }   
                    
                }
        return intersection;
    }
    
    
    /**
     * checks whether this set is a subset of B
     * @param B set that is checked
     * @return true if current set is a subset of given B
     */
    public boolean subsetOf(MySet B){
        int i;
        int j;
        for( i = 0; i < this.size; ++i)
                {
                    for ( j =0; j < B.size; j++){
                        if (this.data[i] == B.data[i])
                            break;
                    }
                    if (j == B.size)
                        return false;
    }
        return true;
    }
    
    
    /**
     * creates new set, this set union with given B
     * @param B set to union
     * @return new set that is union of current set with given set B
     */
    public MySet union(MySet B){
        MySet union = new MySet();
        for(int i = 0; i < size; ++i)
                {
                 for(int j =0; j < B.size; j++)
                    {
                     union.add(data[i]);
                     if(B.data[j] != null)
                     {
                         union.add(B.data[j]);
                     }
                    }       
                }
        return union;
    }
    
    /**
	 * Clone a copy of the current MySet.
	 * @return			The cloned copy of the current MySet.
	 */
    
    @Override
	public MySet clone(){
            super.clone();
            MySet setCopy = new MySet();
		setCopy.ensureCapacity(this.size);
		for (int i = 0; i < size; ++i){
			setCopy.data[i] = this.data[i];
		}
		setCopy.size = this.size;
		return setCopy;
	}
        
        
        /**
	 * Get a String representation of the current set including each element.
	 * @return			The String representation.
	 */
    @Override
	public String toString(){
            super.toString();
            String str = "+++++++++++++++++++++++++++++++++++++++++++++\n" +
					 "The current set contains the following: \n";
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
        
        
        /**
         * method to determine if given number is part of the fibonacci sequence
         * @param place is the number in the sequence desired (ie) input
         * of 5 would give the 5 number of the sequence
         */
        public int fib(int place) { 
            double phi = (1 + Math.sqrt(5)) / 2; 
            return (int) Math.round(Math.pow(phi, place)  
                            / Math.sqrt(5)); 
        }
            
        /**
         * method that adds fibonacci numbers to a set
         * @param amt is the total number of items to add to the given set
         */
        public void addFib(int amt){
            int number = 0;
            for (int adds = 0; adds < amt;) {
                if(this.add(this.fib(number)) == true){
                number++;
                adds++;
                }
            else
                    number++;
            }
        }
 
       
        /**
         * method to determine if a number is prime
         * @param num is the number checked
         * @return true if number is prime
         */
        public boolean isPrime(int num) {
            for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                return false;
            }
        }
            return true;
        }
        
       /**
     * method that will add prime numbers to a set
     *
     * @param amt is the amount of prime numbers to add to given set
     */
    public void addPrime(int amt) {
        int number = 2;
        //int adds = 0;
       // if (adds <= amt){
        for (int adds = 0; adds < amt;) {
            if (this.isPrime(number) == false) {
                number++;
            } else {
                this.add(number);
                number++;
                adds++;
            }
        }
        //}
    }
}



