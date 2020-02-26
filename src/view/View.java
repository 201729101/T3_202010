package view;

import model.data_structures.Comparendo;
import model.data_structures.ListaEncadenada;
import model.data_structures.Nodo;
import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
	    /**
	     *Imprime el menú 
	     */
		public void printMenu()
		{
			System.out.println("1. Cargar lista de comparendos");
			System.out.println("2. Probar Shell Sort");
			System.out.println("3. Probar Merge Sort");
			System.out.println("4. Probar Quick Sort");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		/**
		 * Imprime un mensaje recibido por parámetro
		 * @param mensaje mensaje a imprimir
		 */
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}
		
		public void printComparendo(Comparendo inf)
		{
			System.out.println("[");
			System.out.println("ID: "+inf.getId());
			System.out.println("Fecha: "+inf.getFecha());
			System.out.println("Medio de detección: " + inf.getMedio());
			System.out.println("Clase de vehículo: "+inf.getClase());
			System.out.println("Tipo de servicio: "+inf.getTipo());
			System.out.println("Infracción: "+inf.getInfr());
			System.out.println("Descripción: "+inf.getDesc());
			System.out.println("Localidad: "+inf.getLocalidad());
			System.out.println("Coordenadas: "+inf.getLatitud()+" , "+inf.getLongitud());
			System.out.println("]");
		}
		
		/**
		 * Imprime todo un modelo recibido por parámetro
		 * @param modelo Modelo a imprimir
		 */
		public void printLista(ListaEncadenada lista)
		{
			System.out.println("Comparendos buscados: {");
			for(Nodo n = lista.darPrimero() ; n!=null ; n = n.darSiguiente())
			{
				Comparendo inf = (Comparendo) n.darElemento();
				printComparendo(inf);
			}
			System.out.println("}");
		}
		
		public void printArreglo(Comparable[] arreglo)
		{
			System.out.println("Comparendos buscados: {");
			for(int i=0 ; i<arreglo.length ; i++)
			{
				Comparendo inf = (Comparendo) arreglo[i];
				printComparendo(inf);
			}
			System.out.println("}");
		}
		
		public void printDiez(Comparable[] arreglo)
		{
			System.out.println("Primeros 10 comparendos: ");
			for(int i=0 ; i<arreglo.length && i<10 ; i++)
			{
				Comparendo inf = (Comparendo) arreglo[i];
				printComparendo(inf);
			}
			System.out.println("");
			System.out.println("Últimos 10 comprendos: ");
			for(int i=arreglo.length -11 ; i<arreglo.length ; i++)
			{
				Comparendo inf = (Comparendo) arreglo[i];
				printComparendo(inf);
			}
		}
		
		
}
