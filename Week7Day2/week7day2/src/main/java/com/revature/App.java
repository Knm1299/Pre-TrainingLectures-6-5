package com.revature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *  Today: The other collections
 * 
 *  HashMap
 *      Key:Value pairs
 *      Very fast to check if it contains a particular key
 *      Keys: 
 *          can't contain duplicates,
 *          only one null allowed, 
 *          ordered based on a hash function(no relation to insertion)
 *      Values: 
 *          each is associated with a key, 
 *          no restriction on duplicates or nulls
 * 
 *      Each set of Key:Value pairs is stored in a Map Entry(Map.Entry)
 *          We can't iterate over a map, but we can get a set of entries to iterate over
 *          using getEntrySet
 * 
 *      Methods:
 *          put(K,V)    - Adds a Key,Value pair to the map
 *          get(K)      - returns the value associated with a particular key
 *          contains(K) - returns a boolean true if the key exists in the map, false otherwise
 *          
 *          for getting iterable collections:
 *              EntrySet - returns a set of entries that can be iterated over
 *              KeySet   - returns a set of just keys, no values
 *              Values   - returns a collection(probably a list) of just values
 * 
 *  HashSet
 *      Just the keys from a HashMap
 *      Can't contain duplicates
 *      Can be iterated over
 *      ordered based on hashes
 *      same speed as HashMap to find if it contains an element
 * 
 * 
 *  Iterators
 *      These are what Java uses behind the scenes for a for-each loop
 *      Each iterable collection(everything but the maps and tables) implements iterable
 *      Iterable defines behavior for getting an iterator, and moving from one element to the next
 *      .next() is how we move from one to the next - we've seen this before!
 * 
 * 
 */
public class App 
{
    public static void main( String[] args )
    {
        HashMap<String, Double> priceMap = new HashMap<>();
        priceMap.put("Coffee", 1.0);
        priceMap.put("Nuka Cola", 1.0);
        priceMap.put("Energy Drinks", 1.0);
        priceMap.put("Juice", 1.0);

        // iterating over entryset
        // for(Map.Entry<String, Double> entry : priceMap.entrySet()){
        //     System.out.println(entry);
        //     System.out.println(entry.getKey());
        //     System.out.println(entry.getValue());
        // }

        //iterating over keyset/values
        // for(double s : priceMap.values()){
        //     System.out.println(s);
        // }

        // System.out.println(priceMap.containsKey("Coffee"));

        // System.out.println(priceMap.get("Nuka Cola"));

        Set<String> stringSet = priceMap.keySet();

        Iterator<String> stringIterator = stringSet.iterator();
        
        // for(int i = 0; i<stringSet.size(); i++){
        //     String s = stringIterator.next();
        //     System.out.println(s);
        // }

        //equivalent foreach
        // for(String s : stringSet){
        //     System.out.println(s);
        // }

        // System.out.println(stringSet.contains("Nuka Cola"));

    }
}
