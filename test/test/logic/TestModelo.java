package test.logic;

import static org.junit.Assert.*;
import model.data_structures.Comparendo;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Integer[] arregloA;

	private Integer[] arregloD;

	private Integer[] arregloO; 

	private Modelo modelo;

	@Before
	public void setUp1() 
	{
		modelo= new Modelo();
	}

	public void setUp2() 
	{
		modelo.leerDatos("comparendos_dei_2018_small.geojson");
	}

	public void setUp3()
	{
		arregloA = new Integer[1000000];
		arregloD = new Integer[1000000];
		arregloO = new Integer[1000000];
		for(int i=0 ; i<1000000 ; i++)
		{
			arregloA[i]=i;
			arregloD[1000000-i-1]=1000000-i-1;
			double p = Math.random()*1000000;
			int po = (int) p;
			arregloO[i] = po;
		}
	}

	@Test
	public void testModelo() 
	{
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darLista().darTamano());  // Modelo con 0 elementos presentes.
	}
	
	@Test
	public void testShellSort()
	{
		setUp3();
		long startTimeA = System.currentTimeMillis();
		modelo.shellSort(arregloA);
		long endTimeA = System.currentTimeMillis();          
		long durationA = endTimeA - startTimeA;
		System.out.println("Shell Sort Ascendente: " + durationA);
		
		long startTimeD = System.currentTimeMillis();
		modelo.shellSort(arregloD);
		long endTimeD = System.currentTimeMillis();          
		long durationD = endTimeD - startTimeD;
		System.out.println("Shell Sort Descendente: " + durationD);
		
		long startTimeO = System.currentTimeMillis();
		modelo.shellSort(arregloO);
		long endTimeO = System.currentTimeMillis();          
		long durationO = endTimeO - startTimeO; 
		System.out.println("Shell Sort Aleatorio: " + durationO);
		
		for(int i = 1; i<100000 ; i++)
		{
			assertEquals(i,(int) arregloA[i]);
			assertEquals(i,(int) arregloD[i]);
			assertTrue(((int) arregloO[i])>=((int) arregloO[i-1]));
		}
	}
	
	@Test
	public void testMergeSort()
	{
		setUp3();
		Integer[] aux1 = arregloA;
		Integer[] aux2 = arregloD;
		Integer[] aux3 = arregloO;
		
		long startTimeA = System.currentTimeMillis();
		modelo.mergeSort(arregloA, aux1, 0, 999999);
		long endTimeA = System.currentTimeMillis();          
		long durationA = endTimeA - startTimeA; 
		System.out.println("Merge Sort Ascendente: " + durationA);
		
		long startTimeD = System.currentTimeMillis();
		modelo.mergeSort(arregloD, aux2, 0, 999999);
		long endTimeD = System.currentTimeMillis();          
		long durationD = endTimeD - startTimeD; 
		System.out.println("Merge Sort Descendente: " + durationD);
		
		long startTimeO = System.currentTimeMillis();
		modelo.mergeSort(arregloO, aux3, 0, 999999);
		long endTimeO = System.currentTimeMillis();          
		long durationO = endTimeO - startTimeO;
		System.out.println("Merge Sort Aleatorio: " + durationO);
		
		for(int i = 1; i<100000 ; i++)
		{
			assertEquals(i,(int) arregloA[i]);
			assertEquals(i,(int) arregloD[i]);
			assertTrue(((int) arregloO[i])>=((int) arregloO[i-1]));
		}
	}
	
	@Test
	public void testQuickSort()
	{
		setUp3();
		long startTimeA = System.currentTimeMillis();
		modelo.quickSort(arregloA);
		long endTimeA = System.currentTimeMillis();          
		long durationA = endTimeA - startTimeA; 
		System.out.println("Quick Sort Ascendente: " + durationA);
		
		long startTimeD = System.currentTimeMillis();
		modelo.quickSort(arregloD);
		long endTimeD = System.currentTimeMillis();          
		long durationD = endTimeD - startTimeD; 
		System.out.println("Quick Sort Descendente: " + durationD);
		
		long startTimeO = System.currentTimeMillis();
		modelo.quickSort(arregloO);
		long endTimeO = System.currentTimeMillis();          
		long durationO = endTimeO - startTimeO; 
		System.out.println("Quick Sort Aleatorio: " + durationO);
		
		for(int i = 1; i<100000 ; i++)
		{
			assertEquals(i,(int) arregloA[i]);
			assertEquals(i,(int) arregloD[i]);
			assertTrue(((int) arregloO[i])>=((int) arregloO[i-1]));
		}
	}
}
