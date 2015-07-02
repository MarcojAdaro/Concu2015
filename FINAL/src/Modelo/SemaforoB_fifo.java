package Modelo;

/**
 * Implementa un semaforo FIFO
 * @author Adaro, Barrera, Vogel
 *
 */
public class SemaforoB_fifo {
	
	cola_fifo cola;
	
	private int val;
	
	/**
	 * Inicializa el semaforo FIFO
	 * @param initial Valor inicial del semaforo
	 */
	public SemaforoB_fifo(int initial){
		val = initial;
		cola = new cola_fifo();
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
	 * Se pone en uno al semaforo y se despierta al hilo que espera mas tiempo
	 */
	public synchronized void Signal(){

		val=1;
		cola.get().notify();
	}

}
