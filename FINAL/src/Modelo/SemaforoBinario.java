package Modelo;

/**
 * Implementa un semaforo binario
 * @author Adaro, Barreda, Vogel
 *
 */
public class SemaforoBinario {
	
	private int val;
	
	/**
	 * Inicializa el semaforo binario
	 * @param initial Valor inicial del semaforo
	 */
	public SemaforoBinario(int initial){
		val = initial;
	}
	
	/**
	 * Si el semaforo esta en cero se agrega a la cola y se duerme al hilo, si esta en uno se pone en cero
	 */
	public synchronized void Wait(){
		
		while(val == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		val--;
	}
	
	/**
	 * Se pone en uno al semaforo y se despierta a un hilo de la cola segun algoritmo utilizado
	 */
	public synchronized void Signal(){

		val=1;
	}

}
