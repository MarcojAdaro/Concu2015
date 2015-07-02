package Modelo;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String patch1="C:\\datos\\incidencia.txt";
		String patch2="C:\\datos\\estado.txt";
		
		Procesador_de_Petri p = new Procesador_de_Petri(patch1,patch2);
		
		p.get_incidencia();
		
		p.get_estado();

	}

}
