/**
 * 
 */
package edu.odu.cs.cs350;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


/**
 * 
 * A container for counting the number of times a string (typically, a single word)
 * has been encountered.  Behaves much like a Map<String,Integer> with the special
 * property that adding a string not yet in the key set behaves as if the string
 * HAD been in there already, with an associated counter value of zero.  
 * 
 * 
 * @author zeil
 *
 */
public class StringCounter implements Cloneable, Iterable<String> 
{

	private TreeMap<String, Integer> map;
	
	
	public StringCounter() {
		map = new TreeMap<>();
	}


    int size() {
    	return map.size();
    }


    boolean isEmpty()
    {
    	return size() == 0;
    }


    boolean containsKey(String key)
    {
    	if (key == null)
    		throw new NullPointerException("Null key");
    	return map.get(key) != null;
    }



    int get(String key)
    {
    	if (key == null)
    		throw new NullPointerException("Null key");
    	Integer cnt = map.get(key);
    	if (cnt != null)
    		return cnt.intValue();
    	else
    		return 0;
    }

 
    public int add(String key, int value)
    {
    	return accumulate (key, value);
    }


    public int increment(String key)
    {
		return accumulate (key, 1);
    }


    public int decrement(String key)
    {
		return accumulate (key, -1);
    }


    private int accumulate(String key, int value)
    {
		if (key == null)
    		throw new NullPointerException("Null key");
    	Integer cnt = map.get(key);
    	int newValue = (cnt != null) ? cnt + value : value;
    	if (newValue == 0) {
    		if (cnt != null)
    			map.remove(key);
    	} else {
    		map.put(key,  newValue);
    	}
    	return (cnt != null) ? cnt.intValue() : 0;
    }

    
    // Bulk Operations


  
    void clear()
    {
		map.clear();
    }


    // Views

    /**
     * Returns a {@link Set} view of the keys known to this map
     * that have non-zero counters associated with them.
     * 
     * The set is backed by the map, so changes to the map are
     * reflected in the set, and vice-versa.  If the map is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation), the results of
     * the iteration are undefined.  
     *
     * @return a set view of the keys contained in this map
     */
    Set<String> keySet()
    {
    	return map.keySet();
    }

    /**
     * Returns an iterator over the keys known to this map
     * that have non-zero counters associated with them.
     * 
     * This iterator visits the keys in sorted (ascending) order.
     */
	@Override
	public Iterator<String> iterator() {
		return map.keySet().iterator();
	}

    // Comparison and hashing

    /**
     * Compares the specified object with this map for equality.  Returns
     * <tt>true</tt> if the given object is also a StringCOunter and the two
     * represent the same mappings.  
     *
     * @param o object to be compared for equality with this map
     * @return <tt>true</tt> if the specified object is equal to this one
     */
    public boolean equals(Object o) {
    	if (!(o instanceof StringCounter))
    		return false;
    	StringCounter other = (StringCounter)o;
    	return map.equals(other.map);
    }

    /**
     * Returns the hash code value for this object.
     *
     * @return the hash code value for this map
     */
    public int hashCode()
    {
    	return map.hashCode();
    }

    /**
     * Return a (deep) copy of this object.
     */
    @SuppressWarnings("unchecked")
	@Override
    public Object clone()
    {
		StringCounter theClone = new StringCounter();
    	theClone.map = (TreeMap<String, Integer>) map.clone();
    	return theClone;
    }
    

}
