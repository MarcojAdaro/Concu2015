/**
 * 
 */
package Modelo.politicas;

/**
 * @author Adaro, Barreda, Vogel
 *
 */
public interface Cola {
	
	void set(Thread c);
	
	Thread get();
	
	Thread view();
	
	boolean empty();

}
