/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sistemas Inteligentes
 */
public class Jugador{

    /**
     * Se llama desde la clase Interfaz para ejecutar BC.
     * Al final de la función la solución del tablero se debe encontrar en tablero
     * @param tablero
     * @return
     */
    int x;
    int y;
    
    public class Nodo{
        public int x1;
        public int y1;
        
        public int x2;
        public int y2;
        
        public Nodo(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        
        public Nodo(Nodo nodo){
            this.x1 = nodo.x1;
            this.y1 = nodo.y1;
            this.x2 = nodo.x2;
            this.y2 = nodo.y2;
        }
        @Override
        public boolean equals(Object obj){
            if (obj == this)
                return true;
            
            if (obj == null || obj.getClass() != this.getClass()) 
                return false;
            
            Nodo nodo = (Nodo)obj;
            return (this.x1 == nodo.x1 && this.y1 == nodo.y1 && this.x2 == nodo.x2 && this.y2 == nodo.y2)
                    || (this.x1 == nodo.x2 && this.y1 == nodo.y2 && this.x2 == nodo.x1 && this.y2 == nodo.y1);
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 37 * hash + this.x1;
            hash = 37 * hash + this.y1;
            hash = 37 * hash + this.x2;
            hash = 37 * hash + this.y2;
            return hash;
        }
        
        @Override
        public String toString(){
            return "<(" + x1 + "," + y1 + "),(" + x2 + "," + y2 +")>";
        }
    }
    
    public boolean ejecutarBC(Tablero tablero){
        /*int fila, columna;
        if(!siguiente(tablero))
            return true;
        fila = x;
        columna = y;
        
        for(int numero=1 ;numero<=9 ; numero++){
            if(comprobarRestriccion(tablero,fila,columna,numero)){
                tablero.setCasilla(numero,fila,columna);
                if(ejecutarBC(tablero))
                    return true; 
                tablero.setCasilla(0,fila,columna);
            }
        }*/
        return false;
        
    }
      
    public boolean siguiente(Tablero tablero){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(tablero.getCasilla(i,j)==0){
                    x = i;
                    y = j;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean comprobarRestriccion(Tablero tablero, int coordX, int coordY,int numero){
        for (int columna = 0; columna < 9; columna++)
            if (tablero.getCasilla(coordX,columna) == numero)
                return false;
        
        for (int fila = 0; fila < 9; fila++)
            if (tablero.getCasilla(fila,coordY) == numero)
                return false;
        
        int cuadranteX = coordX/3;
        int cuadranteY = coordY/3;
        for(int i = cuadranteX*3 ; i < (cuadranteX+1)*3; i++)
            for(int j = cuadranteY*3 ; j < (cuadranteY+1)*3; j++)
                if(tablero.getCasilla(i, j) == numero)
                    return false;
        return true;
    }
    /**
     * Se llama desde la clase Interfaz para ejecutar AC.
     * Al final de la función la solución del tablero se debe encontrar en tablero
     * @param tablero
     * @return
     */
    public List<Nodo> conjuntoQ(Tablero tablero){
        List<Nodo> conjunto = new ArrayList<Nodo>();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                if(j+1 < 9){
                    Nodo nodoY = new Nodo(i,j,i,j+1);
                    if(!conjunto.contains(nodoY))
                       conjunto.add(nodoY);
                }
                if(i+1 < 9){
                    Nodo nodoX = new Nodo(i,j,i+1,j);
                    if(!conjunto.contains(nodoX))
                       conjunto.add(nodoX);
                }
                
                if(i+1 < 9 &&j+1 < 9){
                    Nodo nodoXY = new Nodo(i,j,i+1,j+1);
                    if(!conjunto.contains(nodoXY))
                       conjunto.add(nodoXY);
                }
            }
        return conjunto;        
    }
    
    public boolean ejecutarAC(Tablero tablero)
    {
        //Prueba Nodo
        /*Nodo nodo1 = new Nodo(8,4,3,5);
        Nodo nodo2 = new Nodo(3,5,8,4);
        Nodo nodo3 = new Nodo(8,1,3,5);
        Nodo nodo4 = new Nodo(nodo1);
        System.out.println(nodo1);
        System.out.println(nodo2);
        System.out.println(nodo3);
        System.out.println(nodo4);
        if(nodo1.equals(nodo4) && !(nodo1.equals(nodo3)) && nodo1.equals(nodo4))
            System.out.println("Equals correcto");
        else
            System.out.println("Equals incorrecto");*/
        /*
        */
        //Prueba generarConjunto
        /*List<Nodo> conjunto = conjuntoQ(tablero);
        for(Nodo nodo : conjunto){
            System.out.println(nodo);
        }*/
        
        return true;
    }
}

  