'''
Created on 29/11/2021

@author: Herrera
'''

import random
import time

class AlgoritmosOrdenamiento:
    
    def __init__(self):
        self.intercambios = 0
        self.recorridos = 0
        self.comparaciones = 0 
    
    
    def mostrarDatos(self, inicio, fin):
        print(f"Tiempo: {fin-inicio}")
        print(f"Recorridos: {self.recorridos}")
        print(f"Intercambios: {self.intercambios}")
        print(f"Comparaciones: {self.comparaciones}")
        self.comparaciones = self.intercambios = self.recorridos = 0
    
    @staticmethod
    def intercambiar(a, i, j):
        aux = a[i]
        a[i] = a[j]
        a[j] = aux
        
    
    def quicksort(self, a, primero, ultimo):
        
        central = int((primero + ultimo)/2)
        pivote = a[central]
        i = primero
        j = ultimo
        
        while(i <= j):
          
            while(a[i] < pivote):
                i+=1
         
            while(a[j] > pivote):
                j-=1
           
            if(i <= j):
              
                AlgoritmosOrdenamiento.intercambiar(a, i, j)
                i+=1
                j-=1
         
        if(primero < j):
            self.quicksort(a, primero, j)
        if(i < ultimo):
            self.quicksort(a, i, ultimo)
            
        
            
    def quicksortLlamada(self, a):
        self.quicksort(a, 0, len(a)-1)
        
    def intercalacion(self, a1:list, a2:list) -> list:
        
        inicio = time.time()
        a3 : list = []
        cont : int = 0
        cont2 : int = 0

        while len(a1)!=cont and len(a2)!=cont2:
            self.comparaciones+=1
            self.intercambios+=1
            
            if a1[cont]<=a2[cont2]:
                a3.append(a1[cont])
                cont+=1
            else:
                a3.append(a2[cont2])
                cont2+=1
            self.recorridos+=1

        while len(a1)!=cont:
            self.recorridos+=1
            self.intercambios+=1
            a3.append(a1[cont])
            cont+=1

        while len(a2)!=cont2:
            self.recorridos+=1
            self.intercambios+=1
            a3.append(a2[cont2])
            cont2+=1
            
        fin = time.time()
        
        self.mostrarDatos(inicio, fin)

        return a3

    def ordenamientoMezclaDirecta(self,array):
        
        mitad=len(array)//2
        self.comparaciones+=1
        if len(array)>=2:
        
            arregloIz=array[mitad:]
            arregloDer=array[:mitad]

            array.clear()  
            
            self.ordenamientoMezclaDirecta(arregloIz)
            
            self.ordenamientoMezclaDirecta(arregloDer)
            
            while(len(arregloDer)>0 and len(arregloIz)>0):
                self.comparaciones+=1
                if(arregloIz[0]< arregloDer[0]):
                    array.append(arregloIz.pop(0))
                else:
                    array.append(arregloDer.pop(0))
                self.recorridos+=1
                self.intercambios+=1
            
            while len(arregloIz)>0:
                self.intercambios+=1
                self.recorridos+=1
                array.append(arregloIz.pop(0))
            
            while len(arregloDer)>0:
                self.intercambios+=1
                self.recorridos+=1
                array.append(arregloDer.pop(0))
        
        return array
    
    def mezclaDirectaLlamada(self, arreglo):
        inicio = time.time()
        self.ordenamientoMezclaDirecta(arreglo)
        fin = time.time()
        self.mostrarDatos(inicio, fin)
    
    def mezclaDirecta2(self, array):
        mitad=len(array)//2
        
        self.comparaciones+=1
        if len(array)>=2:
            arregloIz=array[mitad:]
            arregloDer=array[:mitad]

            array.clear()  
            
            self.mezclaDirecta2(arregloIz)
            self.mezclaDirecta2(arregloDer)
           
            while(len(arregloDer)>0 and len(arregloIz)>0):
                self.comparaciones+=1
                if(arregloIz[0]< arregloDer[0]):
                    array.append(arregloIz.pop(0))
                else:
                    array.append(arregloDer.pop(0))
                self.recorridos+=1
                self.intercambios+=1
           
            while len(arregloIz)>0:
                self.intercambios+=1
                self.recorridos+=1
                array.append(arregloIz.pop(0))
            
            while len(arregloDer)>0:
                self.intercambios+=1
                self.recorridos+=1
                array.append(arregloDer.pop(0))

    def mezclaNatural(self, numeros):
        inicio = time.time()
        izquerdo = 0
        izq = 0
        derecho = len(numeros)-1
        der = derecho
        ordenado=False
        
        while(not ordenado):
            ordenado = True
            izquierdo =0
            while(izquierdo<derecho):
                self.comparaciones+=1
                izq=izquerdo
                while(izq < derecho and numeros[izq]<=numeros[izq+1]):
                    izq=izq+1
                    self.intercambios+=1
                    self.recorridos+=1
                der=izq+1
                self.comparaciones+=1
                while(der==derecho-1 or der<derecho and numeros[der]<=numeros[der+1]):
                    der=der+1
                    self.intercambios+=1
                    self.recorridos+=1
                if(der<=derecho):
                    self.intercambios+=1
                    self.recorridos+=1
                    self.mezclaDirecta2(numeros)
                    ordenado= False
                izquierdo = izq
                
                self.recorridos+=1
                
        
        fin = time.time()
        self.mostrarDatos(inicio, fin)
                
                
                
vect = []
vect2 = []
vect3 = []
opcion = 0
a1 = AlgoritmosOrdenamiento()
for i in range(10):
    vect.append(random.randrange(70, 99, 2))

vect3 = vect.copy()    

a1.quicksortLlamada(vect)
vect2 = vect.copy()


while(opcion != 20):
    print("\nIntroduce metodo de ordenamiento: ");
    print("1) Intercalacion")
    print("2) Mezcla Directa")
    print("3) Mezcla natural")
    print("4) Salir")
    opcion = int(input("Introduce opcion: "))
    
    vector = vect3.copy()
    
    if (opcion == 1):
        print("\nVector ordenado: ")
        print(AlgoritmosOrdenamiento().intercalacion(vect, vect2))
        
    if (opcion == 2):
       
        AlgoritmosOrdenamiento().mezclaDirectaLlamada(vector)
        print("\nVector ordenado: ")
        print(vector)
        
    if (opcion == 3):
        AlgoritmosOrdenamiento().mezclaNatural(vector)
        print("\nVector ordenado: ")
        print(vector)
        
    if (opcion == 4):
        print("\nSaliendo . . .")
        
'''
        Crear vectores con números aleatorios con los siguientes tamaños:
        - 1000
        - 10000
        - 100000
        - 1000000

        Mostrar los tiempos de ejecución.
        Mostrar cantidad de recorridos, comparaciones e intercambios
        Crear una TABLA comparativa con los resultados.
        
        
        prueba vector con 1000 elementos
        
        metodo                tiempo            recorridos            comparaciones            intercambios
        
        Intercalacion         0.001991033       2000                  1938                     2000
        
        Mezcla Directa        0.023007154       9976                  10578                    9976
        
        Mezcla Natural        0.024993896       11980                 10584                    11977
        
        prueba vector con 10000 elementos
        
        metodo                tiempo            recorridos            comparaciones            intercambios
        
        Intercalacion         0.028009414       20000                 19342                    20000
        
        Mezcla Directa        0.165979623       133616                137932                   133616
        
        Mezcla Natural        0.173974752       153622                137938                   153619
        
        prueba vector con 100000 elementos
        
        metodo                tiempo            recorridos            comparaciones            intercambios
        
        Intercalacion         0.174989461       200000                193362                   200000
        
        Mezcla Directa        3.610975265       1668928               1700816                  1668928
        
        Mezcla Natural        3.778977155       1868931               1700822                  1868928
        
        prueba vector con 1000000 elementos
        
        metodo                tiempo            recorridos            comparaciones            intercambios
        
        Intercalacion         1.7279605         2000000               1932949                   2000000
        
        Mezcla Directa        392.423984        209391932             289301849                 209391932
        
        Mezcla Natural        303.123838        190262131             290293918                 199381131

'''
        