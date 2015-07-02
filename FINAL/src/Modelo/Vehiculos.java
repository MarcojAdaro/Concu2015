package Modelo;

/**
 * Genera un vehiculo, y realiza disparos a partir de un arreglo.
 * @author Adaro, Barreda, Vogel
 *
 */

public class Vehiculos extends Thread{
	
	Monitor monitor;
	
	private String nombre;
	
	private int transiciones[];
	
	/**
	 * Constructor de la clase Vehiculo.
	 * @param n Nombre del vehiculo
	 * @param m Monitor a ser utilizado
	 * @param t Arreglo de las transiciones a disparar
	 */
	public Vehiculos (String n, Monitor m, int t[] ){
		
		nombre = n;
		monitor = m;
		transiciones = t;
		
	}
	
	/**
	 * Metodo que provoca que el hilo realice todos los disparos
	 */
	public void run(){
		
		while(true){
			
			try{
				
				for(int i=0; i<transiciones.length; i++){
					
					monitor.disparo(transiciones[i], nombre);
					sleep(100);
				}
				sleep(500);
			} catch(InterruptedException e){
				e.printStackTrace();
				
			}
			
			
		}
			
	}
	
	/**
	 * Retorna el nombre del hilo
	 */
	public void getnombre(){
		System.out.println(nombre);
	}

}
