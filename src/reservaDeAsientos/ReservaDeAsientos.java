package reservaDeAsientos;

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
		boolean reserva=false;
		while(reserva==false) {
			System.out.println("Ingrese la fila en la que desea reservar:");
			fila=teclado.nextInt()-1;
			System.out.println("Ingrese la columna en la que desea reservar:");
			columna=teclado.nextInt()-1;
			
			if(asientos[fila][columna].equals("l")) {
				asientos[fila][columna]="x";
				System.out.println("Asiento reservado");
				reserva=true;
			}else {
				System.out.println("El asiento ya está reservado, pruebe otra posicion");
			}			
		}
	}
	
	public static void main(String[] args) {
		ReservaDeAsientos r= new ReservaDeAsientos();
		r.cargarAsientosVacios();
		r.reservarAsientoSiEstaVacio();	
		r.mostrarAsientos();
		r.reservarAsientoSiEstaVacio();
		r.mostrarAsientos();
	}
	
	
}


