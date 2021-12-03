import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class AlgoritmosOrdenamiento{
	
	static long comparaciones = 0;
	static long intercambios = 0;
	static long recorrido = 0;
	
	public static void mostrarDatos(long tFin1, long tInicio1, long recorrido1, long comparaciones1, long intercambios1) {
		System.out.println("\nTiempo de ejecucion: " + (tFin1-tInicio1));
		System.out.println("Recorridos: " + recorrido1);
		System.out.println("Comparaciones: " + comparaciones1);
		System.out.println("Intercambios: " + intercambios1);
		comparaciones = recorrido = intercambios = 0;
	}
	
	private void quicksort(int a[], int primero, int ultimo) {
		 int i, j, central;
		 int pivote; 
		 central = (primero + ultimo)/2;
		 pivote = a[central];
		 i = primero;
		 j = ultimo;
		 do {
		 	 while (a[i] < pivote) i++;
		 	 while (a[j] > pivote) j--;
		 	 if (i <= j) {
		 		 // Se intercambian
		 		 int aux = a[i];
				 a[i] = a[j];
				 a[j] = aux;
		 	 	 i++;
		 	 	 j--;
		 	 }
		 } while (i <= j);
		 
		 if (primero < j)
		 	 quicksort(a, primero, j); // mismo proceso con sublista izqda
		 if (i < ultimo)
		 	 quicksort(a, i, ultimo); // mismo proceso con sublista drcha
	}
	
	public void quicksort(int a[]) {
		quicksort(a, 0, a.length-1);
	}
	
	public static int[] intercalacion(int numeros[], int numeros2[]) {
		long tInicio = System.currentTimeMillis();
		
		
		int arrayOrdenado[] = new int[numeros.length+numeros2.length];
		
    	int i=0, j=0, k=0;
    	
    	while(i<numeros.length && j<numeros2.length) {
    		comparaciones++;
    		if(numeros[i]<numeros2[j]) {
    			
    			arrayOrdenado[k] = numeros[i];
    			i++;
    		}else {
    			arrayOrdenado[k] = numeros2[j];
    			j++;
    		}
    		k++;
    		intercambios++;
    		recorrido++;
    	}
    	
    	while(i<numeros.length) {
    		intercambios++;
    		recorrido++;
    		arrayOrdenado[k] = numeros[i];
			i++;
			k++;
    	}
    	
        while(j<numeros2.length) {
        	intercambios++;
    		recorrido++;
        	arrayOrdenado[k] = numeros2[j];
			j++;
			k++;
    	}
        
        long tFin = System.currentTimeMillis();
		mostrarDatos(tFin, tInicio, recorrido, comparaciones, intercambios);
    	
    	return arrayOrdenado;
		
	}
	
	public static int[] ordenamientoMezclaDirecta(int arreglo[]) {
		int i,j,k;
		
		if(arreglo.length>1) {
			int numElementosIzq = arreglo.length/2;
			int numElementosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[] = new int[numElementosIzq];
			int arregloDerecho[] = new int[numElementosDer];
			
			for(i=0; i<numElementosIzq; i++) {
				recorrido++;
				intercambios++;
				arregloIzquierdo[i] = arreglo[i];
			}
			
			for(i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
				recorrido++;
				intercambios++;
				arregloDerecho[i-numElementosIzq]=arreglo[i];
			}
			
			arregloIzquierdo = ordenamientoMezclaDirecta(arregloIzquierdo);
			arregloDerecho = ordenamientoMezclaDirecta(arregloDerecho);
			i=j=k=0;
			
			while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
				comparaciones++;
				if(arregloIzquierdo[j]<arregloDerecho[k]) {
					intercambios++;
					arreglo[i] = arregloIzquierdo[j];
					i++;
					j++;
				}else {
					intercambios++;
					arreglo[i] = arregloDerecho[k];
					i++;
					k++;
				}
				recorrido++;
			}
			
			while(arregloIzquierdo.length!=j) {
				intercambios++;
				recorrido++;
				arreglo[i] = arregloIzquierdo[j];
				i++;
				j++;
			}
			
			while(arregloDerecho.length!=k) {
				intercambios++;
				recorrido++;
				arreglo[i] = arregloDerecho[k];
				i++;
				k++;
			}
			
		}// if
		
		return arreglo;
	}
	
	public static void mezclaDirectaLlamada(int [] arreglo) {
		long tInicio = System.currentTimeMillis();
		ordenamientoMezclaDirecta(arreglo);
		long tFin = System.currentTimeMillis();
		mostrarDatos(tFin, tInicio, recorrido, comparaciones, intercambios);
	}
	
	public static void mezclaDirecta2(int arreglo[]) {
		int i,j,k;
		
		if(arreglo.length>1) {
			int numElementosIzq = arreglo.length/2;
			int numElementosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[] = new int[numElementosIzq];
			int arregloDerecho[] = new int[numElementosDer];
			
			for(i=0; i<numElementosIzq; i++) {
				arregloIzquierdo[i] = arreglo[i];
				recorrido++;
				intercambios++;
			}
			
			for(i=numElementosIzq; i<numElementosIzq+numElementosDer; i++) {
				arregloDerecho[i-numElementosIzq]=arreglo[i];
				intercambios++;
				recorrido++;
			}
			
			mezclaDirecta2(arregloIzquierdo);
			mezclaDirecta2(arregloDerecho);
			i=j=k=0;
			
			
			while(arregloIzquierdo.length!=j && arregloDerecho.length!=k) {
				comparaciones++;
				if(arregloIzquierdo[j]<arregloDerecho[k]) {
					intercambios++;
					arreglo[i] = arregloIzquierdo[j];
					i++;
			  		j++;
				}else {
					intercambios++;
					arreglo[i] = arregloDerecho[k];
					i++;
					k++;
				}
				recorrido++;
			}
			
			//Arreglo izquierdo
			while(arregloIzquierdo.length!=j) {
				intercambios++;
				recorrido++;
				arreglo[i] = arregloIzquierdo[j];
				i++;
				j++;
			}
			
			while(arregloDerecho.length!=k) {
				intercambios++;
				recorrido++;
				arreglo[i] = arregloDerecho[k];
				i++;
				k++;
			}
		  }//if
			
	}
		
		public static void mezclaNatural(int numeros[]) {
			
			long tInicio = System.currentTimeMillis();
			
	        int izquierda = 0;
	        int izq = 0;
	        int derecha = numeros.length-1;
	        int der = derecha;
	        boolean ordenado = false;
	        do {
	        	
	        	izquierda = 0;
	        	ordenado = true;
	        	comparaciones++;
	        	while(izquierda<derecha) {
	        		izq = izquierda;
	        		recorrido++;
	        		while(izq<derecha && numeros[izq]<=numeros[izq+1]) {
	        			recorrido++;
	        			intercambios++;
	        			izq++;
	        		}
	        		der = izq+1;
	        		while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {
	        			intercambios++;
	        			der++;
	        		}
	        		
	        		if(der<=derecha) {
	        			intercambios++;
	        			mezclaDirecta2(numeros);
	        			
	        			ordenado = false;
	        		}
	        		izquierda = izq;
	        		recorrido++;
	        	}
	        	recorrido++;
	        } while(!ordenado);
	        
			
			long tFin = System.currentTimeMillis();
			mostrarDatos(tFin, tInicio, recorrido, comparaciones, intercambios);
		}	


}

public class PruebaOrdenamiento {
	public static void main(String[] args) {
		Random random = new Random();
		int [] vect = new int[1000];
		
		for (int i = 0; i < vect.length; i++) {
			vect[i] = random.nextInt(100) + 1;
		}

		
		int [] vect3 = vect.clone();
		
		
		AlgoritmosOrdenamiento ao1 = new AlgoritmosOrdenamiento();
		
		ao1.quicksort(vect);
		int[] vect2 = vect.clone();
		
		
		int opcion = 0;
		Scanner entrada = new Scanner(System.in);
		
		do {
			System.out.println("\nIntroduce metodo de ordenamiento: ");
			System.out.println("1) Intercalacion");
			System.out.println("2) Mezcla natural");
			System.out.println("3) Mezcla directa");
			System.out.println("4) Salir");
			System.out.println("Introduce opcion: ");
			opcion = entrada.nextInt();
			
			int vector[] = vect3.clone(); 
		
			System.out.println(Arrays.toString(vector));
			
			switch (opcion) {
				
			case 1:
				
				System.out.println("\nEl vector a sido ordenado");
				System.out.println(Arrays.toString(AlgoritmosOrdenamiento.intercalacion(vect, vect2)));
				
				break;
				
			case 2:
				AlgoritmosOrdenamiento.mezclaNatural(vector);
				System.out.println("\nEl vector a sido ordenado");
				System.out.println(Arrays.toString(vector));
				
				break;
				
			case 3:
				AlgoritmosOrdenamiento.mezclaDirectaLlamada(vector);
				System.out.println("\nEl vector a sido ordenado");
				System.out.println(Arrays.toString(vector));
				
				break;
				
			case 4:
				
				System.out.println("\nSaliendo . . .");
				
				break;
				
			default:
				System.out.println("\nOpcion incorrecta");
				break;
			}
			
		} while(opcion != 8);
	}
	
	/*
	
	prueba vector con 1000 elementos
		
	metodo				tiempo			recorridos			comparaciones			intercambios
	
	Intercalacion		0				2000				1986					2000
	
	Mezcla Natural		28				21958				8705					21952
	
	Mezcla Directa		47				19952				8703					19952
	
	prueba vector con 10000 elementos
		
	metodo				tiempo			recorridos			comparaciones			intercambios
	
	Intercalacion		3				20000				19891					20000
	
	Mezcla Natural		53				287238				120332					287232
	
	Mezcla Directa		73				267232				120330					267232
	
	prueba vector con 100000 elementos
		
	metodo				tiempo			recorridos			comparaciones			intercambios
	
	Intercalacion		50				200000				198948					200000
	
	Mezcla Natural		226				3537862				1532633					3537855
	
	Mezcla Directa		134				3337856				1532631					3337856
	
	prueba vector con 1000000 elementos
		
	metodo				tiempo			recorridos			comparaciones			intercambios
	
	Intercalacion		67				2000000				1989966					2000000
	
	Mezcla Natural		465				41902854			18620147				41902847
	
	Mezcla Directa		424			    39902848			18620145			    39902848
	
	*/
	
}
