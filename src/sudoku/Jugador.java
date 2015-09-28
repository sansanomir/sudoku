/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sudoku;

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
    
    public boolean ejecutarBC(Tablero tablero){
        int fila, columna;
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
        }
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
    public boolean ejecutarAC(Tablero tablero)
    {
        return true;
    }
}

  