package Modelo.politicas;

import java.util.ArrayList;

/**
 * Implementa una cola FIFO
 * @author Adaro, Barrera, Vogel
 */

public class cola_fifo implements Cola{
	
	private ArrayList<Thread> cola;
	
	/**
	 * Inicializa la cola
	 */
	public cola_fifo(){
		
		cola = new ArrayList<Thread>();
	}
	
	/**
	 * Agrega un elemento a la cola en el ultimo lugar
	 * @param c Elemento a agregar
	 */
	public void set(Thread c){
		cola.add(c);
	}
	
	/**
	 * Devuleve el primer elemento de la cola y lo elimina
	 * @return El elemento de la primera posicion
	 */
	public Thread get(){
		
		Thread c = null;
		
		try{
			
			c = cola.get(0);
			
		}catch(IndexOutOfBoundsException e){
			
			System.out.print("Se trato de extraer elemento fuera de rango!!");
			
		}
		
		cola.remove(0);
		
		return c;
		
	}
	
	/**
	 * Devuelvo el primer elemneto de la cola
	 * @return El elemento de la primera posicion
	 */
	public Thread view(){
		
		Thread c = null;
		try {
			c = cola.get(0);
		} catch (IndexOutOfBoundsException e) {
			
			System.out.print("Se trato de extraer elemento fuera de rango!!");
		}
		
		return c;
		
	}
	
	/**
	 * Devuelve true si la cola esta vacia, false si contiene elementos
	 * @return boolean Estado de la cola
	 */
	public boolean empty(){
		
		int size = cola.size();
		
		if(size == 0){
			return true;
		}else{
			return false;
		}
		
	}

}
