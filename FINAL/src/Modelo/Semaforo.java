package Modelo;

import Modelo.politicas.Cola;

/**
 * Implementa un semaforo
 * @author Adaro, Barrera, Vogel
 *
 */
public class Semaforo {

	private int val;
	Cola cola;
	
	/**
	 * Inicializa el semaforo FIFO
	 * @param initial Valor inicial del semaforo
	 */
	public Semaforo(int initial, Cola c){
		val = initial;
		cola = c;
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
