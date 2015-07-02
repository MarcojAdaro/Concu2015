package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Genera las matrices que representan a una red de petri y permite aplicar la ecuacion de estado a esta.
 * @author Adaro, Barreda, Vogel
 */
public class Procesador_de_Petri {
	
	private int[] m_estado;
	private int[][] m_incidencia;
	private int n_transiciones;
	private int n_plazas;
	
	/**
	 * Genera una matriz de incidencia y estado apartir de los archivos incidencia.txt y estado.txt
	 */
	public Procesador_de_Petri (String a, String b){
		
		String[] aux;
		String linea;
		n_transiciones = 0;
		n_plazas = 0;

		try {
			
			BufferedReader br1 = new BufferedReader(new FileReader(a)) ;
			
			for(int j=0, i=0; (linea = br1.readLine()) != null; i++ , j=0){
				
				System.out.println(linea);
				
				aux = linea.split(" ");
				
				System.out.println(aux);
				/*
				while(j<aux.length){
					
					m_incidencia[i][j] = Integer.parseInt(aux[j]);
					
					j++;
				}*/
				
			}
			br1.close();
			
			BufferedReader br2 = new BufferedReader(new FileReader(b));
			
			linea = br2.readLine();
			aux = linea.split(" ");
			int i = 0;
			
			while(i<aux.length){
				
				m_estado[i] = Integer.parseInt(aux[i]);
				i++;
			}
			
			br2.close();
			
		}catch (Exception e){
			
			System.out.println("Error algun archivo!!");
		}
		
		//n_transiciones = m_incidencia.length;
		//n_plazas = m_incidencia[0].length;
		
		System.out.println("se termino de leer la matriz de incidencia..");
		System.out.println("El sistema consta de: PLAZAS = " + n_plazas + " TRANSICIONES = " + n_transiciones);
		System.out.println("se termino de leer la matriz de estado..");
		
	}
	
	/**
	 * Muestra en pantalla matriz de incidencia
	 */
	public void get_incidencia(){
		
		System.out.println("MATRIZ DE INCIDENCIA:");
		
		for(int i=0; i<n_plazas ; i++){
			
			for(int j=0; j<n_transiciones;j++){
				
				System.out.print(m_incidencia[i][j] + " ");
			}
		}
		
	}
	
	/**
	 * Muestra en pantalla matris de estado.
	 */
	public void get_estado(){
		
		System.out.println("MATRIZ DE ESTADO:");
		
		for(int i=0; i<n_transiciones;i++){
			
			System.out.print(m_estado[i]+ " ");
		}
	}
	
	/**
	 * Metodo que mediante una transicion ejecuta la ecuacion de estado de una red de petri.
	 * 
	 * @param t Numero de la transicion a ejecutar.
	 * @return Retorna true si la transicion se ejecuto, false si la transicion no se ejecuto.
	 */
	public boolean disparo(int t){
		
		int auxiliar[] = new int[n_plazas];
		int resultado=0;
	
		for(int i=0; i<n_plazas;i++){
			
			resultado = m_incidencia[i][t]*m_estado[i];
			
			if(resultado<0){
				
				return false;
				
			}
			
			auxiliar[i]= resultado;
		}
		
		
		return true;
	
	}

}
