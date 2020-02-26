package controller;

import java.util.Scanner;

import model.data_structures.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	/**
	 * Corre el sistema mediante la consola 
	 */
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo(); 
				modelo.leerDatos("comparendos_dei_2018_small.geojson");
				view.printMessage("Comparendos cargados");
				view.printMessage("Numero actual de elementos: " + modelo.darLista().darTamano() + "\n---------");
				view.printMessage("Primer comparendo en la Lista");
				view.printComparendo((Comparendo) modelo.darLista().darPrimero().darElemento());
				view.printMessage("Ultimo comparendo de la lista");
				view.printComparendo((Comparendo) modelo.darLista().darUltimo().darElemento());
				break;

			case 2:
				Comparable[] pruebaShS = modelo.copiarComparendos();
				long startTime = System.currentTimeMillis(); 
				modelo.shellSort(pruebaShS);
				long endTime = System.currentTimeMillis();          
				long duration = endTime - startTime; 
				view.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos");
				view.printDiez(pruebaShS);
				break;

			case 3:
				Comparable[] pruebaMS = modelo.copiarComparendos();
				Comparable[] aux = modelo.copiarComparendos();
				long startTime1 = System.currentTimeMillis();
				modelo.mergeSort(pruebaMS, aux, 0, pruebaMS.length-1);
				long endTime1 = System.currentTimeMillis();          
				long duration1 = endTime1 - startTime1; 
				view.printMessage("Tiempo de ordenamiento: " + duration1 + " milisegundos");
				view.printDiez(aux);
				break;
				
			case 4:
				Comparable[] pruebaQS = modelo.copiarComparendos();
				long startTime2 = System.currentTimeMillis();
				modelo.quickSort(pruebaQS);
				long endTime2 = System.currentTimeMillis();          
				long duration2 = endTime2 - startTime2;
				view.printMessage("Tiempo de ordenamiento: " + duration2 + " milisegundos");
				view.printDiez(pruebaQS);
				break;

			case 5: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	

}
