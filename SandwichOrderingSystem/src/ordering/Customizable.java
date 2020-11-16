/**
 * 
 */
package ordering;

/**
 * Customizable interface provides the methods that are to be implemented in
 * subclasses.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 */
public interface Customizable {
	/**
	 * add method is to be implemented in classes that implement Customizable.
	 * 
	 * @param obj to be added
	 * @return boolean if object was added
	 */
	boolean add(Object obj);

	/**
	 * remove method is to be implemented in classes that implement Customizable
	 * 
	 * @param obj to be removed
	 * @return boolean if object was removed
	 */
	boolean remove(Object obj);
}
