package reservaDeAsientos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservaDeAsientos {
	String[][] asientos=new String[10][10];
	Scanner teclado=new Scanner(System.in);
	public void cargarAsientosVacios() {
		for(int f=0;f<10;f++) {
			for(int c=0;c<10;c++) {
				asientos[f][c]="l";
			}
		}
	}
	
	public void mostrarAsientos() {
		for(int f=0;f<10;f++) {
			for(int c=0;c<10;c++) {
				System.out.print("["+asientos[f][c]+"]");
			}
			System.out.println();
		}
	}
	
	public void reservarAsientoSiEstaVacio() {
	    int fila;
	    int columna;
	    String seguir = "";
	    while (!seguir.equals("no")) {
	    	try {
	    		System.out.println("Ingrese la fila en la que desea reservar:");
	    		fila = teclado.nextInt() - 1;
	    		System.out.println("Ingrese la columna en la que desea reservar:");
	    		columna = teclado.nextInt() - 1;
	    		
	    		seguir = this.hacerUnaReservaSiSePuedeYContinuarSiQuiere(fila, columna, seguir);
	    	} catch (InputMismatchException e) {
	            System.out.println("Error: Debe ingresar un número entero. Inténtelo nuevamente.");
	            teclado.next(); 
	    	}
	    }
	}

	
	
	public String hacerUnaReservaSiSePuedeYContinuarSiQuiere(int fila, int columna, String seguir) {
	    if (asientos[fila][columna].equals("l")) {
	        asientos[fila][columna] = "x";
	        System.out.println("Asiento reservado, desea seguir reservando? Ingrese si o no");
	        seguir = teclado.next().toLowerCase();
	        return this.comprobarSiONo(seguir);
	    } else {
	        System.out.println("El asiento ya está reservado, pruebe otra posicion");
	        return seguir;
	    }
	}

	public String comprobarSiONo(String palabra) {
	    while (!palabra.equals("si") && !palabra.equals("no")) {
	        System.out.println("Palabra incorrecta, Ingrese si o no");
	        palabra = teclado.next().toLowerCase();
	    }
	    return palabra;
	}

	
	public static void main(String[] args) {
		ReservaDeAsientos r= new ReservaDeAsientos();
		r.cargarAsientosVacios();
		r.reservarAsientoSiEstaVacio();	
		r.mostrarAsientos();
	}
	
	
}


