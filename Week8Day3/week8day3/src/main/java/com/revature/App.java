package com.revature;

/**
 * Today's topics: Algorithmic complexity
 * 
 *  What is an algorithm?
 *      - A specific set of instructions to complete a task
 *          - specific enough to transfer to code
 *      - sorting algos
 *      - searching algos
 *          - linear search
 *              Iterate over an array/collection
 *              for each element:
 *                  check if it is the target
 *                      if so, return
 *                      else continue
 *  
 *  How do we measure them? What makes one algo better/worse than another?
 *      - efficiency
 *      - we measure algorithms' efficiency based on 
 *          - time
 *              - how many cpu cycles - how many instructions have to occur
 *              - Big O notation
 *                  - relative complexity - the letter n represents an approximation of the value that most affects speed
 *              - O(1)
 *                  - constant time
 * 
 *              - O(n)
 *                  - linear time
 * 
 *              - O(n^2)
 *                  - quadratic time
 * 
 *              - O(log n)
 *                  - logarithmic time
 *                  - binary search
 *                      - given a sorted array of numeric values
 *                      - pick an element(pivot)
 *                          - is this element larger or smaller than our target?
 *                          - if pivot is larger
 *                              - repeat using elements up to the pivot
 *                          - if it is smaller
 *                              - repeat using elements from pivot to the end of the array
 *                          - if they are equal
 *                              - return element, it was found 
 * 
 * 
 *      1,2,3,4,5
 *      looking for 2
 *      
 *      pivot: 3(index 2)
 *      3 is larger than 2
 *      so 
 *      new array: 1,2
 *      pivot: 1(index 0)
 *      1 is less than 2
 *      new array: 2
 *      return 2
 * 
 *          - space
 *              - how much RAM does it use
 *              - everything for time complexity, but in terms of new memory addresses used
 * 
 * 
 *  ------------------------------------------------------------
 * 
 *  Design patterns
 *  - we've discussed a few of these, but two ones we should discuss somewhat formally:
 * 
 *  - Factory
 *      - Used as a central place for producing a certain kind of object
 *      - useful when we have multiple subtypes and can determine which to use algorithmically
 *      - We've seen this one before, when creating connections
 *          - When DriverManager getConnection is called
 *              - DriverManager instantiates a new connection
 *              - The actual class used for the connection is determined by:
 *                  - the url
 *                  - what drivers are available
 * 
 *  - Singleton
 *      - Used to ensure that only one instance of an object exists in the program
 *      - typically enforced using a getInstance method or something similar
 *          - This method gets the object if instantiated, and produces a new one if not
 *          - often this is made static to further ensure that only one can exist
 * 
 */
public class App {
    public static void main( String[] args ){

        int[] ints = new int[20];
        int target = 4;


        //O(n)
        for(int i1 = 0; i1< ints.length; i1++){
            int i = ints[i1];
            // System.out.println("Linear iteration: "+i);

            if(i == target){
            }else{
                continue;
            }
        }

        //O(n^2)
        for(int i : ints){
            for(int j : ints){
                // System.out.println(j);
            }
        }

        //O(log n) - n is halved each run cycle
        // System.out.println(binarySearch(ints, target));
    
        
        //Factory example
        Animal a = AnimalFactory.getAnimal("dumplings");
        // a.eat();

        //Singleton
        //see ConnectionUtils.java

    }



    static int binarySearch(int[] A, int N) {
      
        int lowestPossibleLoc = 0;
        int highestPossibleLoc = A.length - 1;
        int i = 0;

        while (highestPossibleLoc >= lowestPossibleLoc) {
            i++;
           System.out.println("log iteration: " + i);
           int middle = (lowestPossibleLoc + highestPossibleLoc) / 2;
           if (A[middle] == N) {
                     // N has been found at this index!
              return middle;
           }
           else if (A[middle] > N) {
                     // eliminate locations >= middle
              highestPossibleLoc = middle - 1;
           }
           else {
                     // eliminate locations <= middle
              lowestPossibleLoc = middle + 1;   
           }
        }
        
        // At this point, highestPossibleLoc < lowestPossibleLoc,
        // which means that N is known to be not in the array.  Return
        // a -1 to indicate that N could not be found in the array.
     
        return -1;
      
    }
}
