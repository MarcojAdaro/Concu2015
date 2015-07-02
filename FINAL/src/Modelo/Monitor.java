package Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;

import Modelo.politicas.Cola;
import Modelo.politicas.cola_fifo;

/**
 * Implementa un monitor
 * @author Adaro, Barrera, Vogel
 *
 */
public class Monitor {
	
	private Cola c;
	String a="";
	String b="";
	
	private Semaforo mutex;
	private VarCondicionales cond;
	private Procesador_de_Petri p;
	
	/**
	 * Inicializa los semaforos para realizar la exclusion mutua y proteger la seccion critica
	 * @throws FileNotFoundException
	 * @throws NullPointerException
	 * @throws IOException
	 */
	public Monitor(){
		
		c = new cola_fifo();
		
		mutex = new Semaforo(1,c);
		
		cond = new VarCondicionales(mutex);
		
		p = new Procesador_de_Petri(a,b);
		
	}
	
	/**
	 * Envia los disparos a el Procesador de Petri
	 * @param t transicion a disparar
	 * @param nombre nombre del hilo
	 */
	public void disparo(int t, String nombre) {
		
		mutex.Wait(); 
		
		System.out.println("Entro el vehiculo: "+ nombre +"\n");
		
		while( p.disparo(t) == false )
		{
			cond.DELAY();
		}
		System.out.println("vehiculo : " + nombre);
		p.disparo(t-1);
		
		cond.RESUME();
		System.out.println("Sale vehiculo: "+nombre+"\n");	
		
		
	}

}
