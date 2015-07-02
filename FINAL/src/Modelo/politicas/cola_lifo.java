package Modelo.politicas;

import java.util.ArrayList;

/**
 * Implementa una cola LIFO
 * @author Adaro, Barrera, Vogel
 *
 */
public class cola_lifo implements Cola{
	
	private ArrayList<Thread> cola;
	
	/**
	 * Inicializa la cola
	 */
	public cola_lifo(){
		
		cola = new ArrayList<Thread>();
		
	}
	
	/**
	 * Agrega el elemento c a la cola
	 * @param c Elemento a agregar
	 */
	public void set(Thread c){
		
		this.cola.add(c);
		
	}
	
	/**
	 * Retorna el ultimo elemento de la cola y lo elimina sino devuelve null
	 * @return c Ultimo elemento de la cola
	 */
	public Thread get(){
		
		int size = cola.size();
		
		Thread c = null;
		
		try{
			
			c = this.cola.get(size -1);
			
		}catch(IndexOutOfBoundsException e){
			System.out.print("Se trato de extraer elemento fuera de rango!!");
		}
		
		this.cola.remove(0);
		
		return c;
		
	}
	
	/**
	 * Retorna el ultimo elemento de la cola
	 * @return c Ultimo elemento de la cola
	 */
	public Thread view(){
		
		Thread c = null;
		try {
			c = this.cola.get(0);
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
		
		int size = this.cola.size();
		
		if(size == 0){
			return true;
		}else{
			return false;
		}
		
	}

}
