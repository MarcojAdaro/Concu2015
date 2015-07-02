package Modelo;

/**
 * Implementa una variables condicional
 * @author Adaro, Barrera, Vogel
 *
 */
public class VarCondicionales {
	
	private Semaforo mutex;
	private Semaforo condicion;	
	private int bloqueados;
	private cola_fifo c;
	
	/**
	 * Inicializar la variable condicional
	 * @param sem
	 */
	public VarCondicionales(Semaforo sem) {
		
		mutex = sem;
		condicion = new Semaforo(0,c);
		bloqueados=0;
	}
	
	/**
	 * Se bloquea al hilo y se lo agrega a la cola, ademas se libera el monitor
	 */
	public void DELAY() {
		bloqueados++;
		mutex.Signal(); //RETIRO DEL MONITOR AL HILO, PARA ELIMINAR LA EXCLUSION MUTUA
		condicion.Wait();//BLOQUEO EL HILO YA QUE NO CUENTA CON LOS RECURSOS
	}
	

	/**
	 * Si hay hilos en la cola se libera uno, sino se libera el monitor
	 */
	public void RESUME() { 
		if(bloqueados>0) { //SI HAY HILOS BLOQUEADOS DESPIERTO A UNO
			bloqueados--; //DISMINUYO LA CANTIDAD DE BLOQUEADOS
			condicion.Signal();//LIBERO EL RECURSO
		}
		else
			mutex.Signal(); //LIBERO EL MONITOR
	}

}
