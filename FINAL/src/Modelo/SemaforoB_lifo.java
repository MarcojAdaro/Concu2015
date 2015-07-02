package Modelo;

/**
 * Implementa una cola LIFO
 * @author Adaro, Barrera, Vogel
 *
 */
public class SemaforoB_lifo {
	
	cola_lifo cola;
	
	private int val;
	
	/**
	 * Inicializa el semaforo LIFO
	 * @param initial Valor inicial del semaforo
	 */
	public SemaforoB_lifo(int initial){
		val = initial;
		cola = new cola_lifo();
	}
	
	/**
	 * Si el semaforo esta en cero se agrega a la cola y se duerme al hilo, si esta en uno se pone en cero
	 */
	public synchronized void Wait(){
		
		while(val == 0){
			try {
				cola.set(Thread.currentThread());
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		val--;
	}
	
	/**
	 * Se pone en uno al semaforo y se despierta al hilo que espera menos tiempo
	 */
	public synchronized void Signal(){

		val=1;
		cola.get().notify();
	}

}
