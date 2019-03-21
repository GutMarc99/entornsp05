package entornsp05;

public class Main {
	
	private static final int NUM_TORRES = 4;

	public static void main(String[] args) {
		Main programa = new Main();
		programa.inici();
	}
	
	public void inici() {
		int[] origen = llenarArray(); //ARRAY CON NÚMEROS DEL 1 AL 4.
		int[] resultado = llenarResultado();
		int[] auxiliar = arrayCero(); //ARRAY LLENO DE 0. 
		int[] destino = arrayCero(); 
		hanoi(0, NUM_TORRES-1, NUM_TORRES-1, origen, auxiliar, destino, resultado);
		
	}
	
	public void hanoi(int posicion, int posicionDestino, int posicionAux, int[] origen, int[] auxiliar, int[] destino, int[] resultado) {
		
		if (destino == resultado) {
			return; 
		} else if (origen[posicion] < destino[posicionDestino+1]) {
			destino[posicionDestino] = origen[posicion];
			origen[posicion] = NUM_TORRES + 1;
			System.out.println("El disco "+destino[posicionDestino]+" se ha movido a destino.");
			if(posicion < NUM_TORRES-1) {
				posicion++;
				} else {
					posicion = 0; 
				}
			if (posicionDestino > 0) {
			posicionDestino--;
			}
			hanoi(posicion, posicionDestino, posicionAux, origen, auxiliar, destino, resultado);
		} else if (origen[posicion] < auxiliar[posicionAux+1]) {
			auxiliar[posicionAux] = origen[posicion];
			origen[posicion] = NUM_TORRES + 1;
			System.out.println("El disco "+auxiliar[posicionAux]+" se ha movido a auxiliar.");
			if(posicion < NUM_TORRES-1) {
			posicion++;
			} else {
				posicion = 0; 
			}
			if (posicionAux > 0) {
			posicionAux--;
			}
			hanoi(posicion, posicionDestino, posicionAux, origen, auxiliar, destino, resultado);
		} else if (destino[posicionDestino+1] < origen[posicion]) {
			origen[posicion] = destino[posicionDestino+1];
			destino[posicionDestino+1] = NUM_TORRES + 1;
			System.out.println("El disco "+origen[posicion]+" se ha movido a origen.");
			posicionDestino++;
			if (posicion > 0) {
			posicion--;
			} 
			hanoi(posicion, posicionDestino, posicionAux, origen, auxiliar, destino, resultado);
		} else if (destino[posicionDestino+1] < auxiliar[posicionAux+1]) {
			auxiliar[posicionAux] = destino[posicionDestino+1];
			destino[posicionDestino+1] = NUM_TORRES + 1;
			System.out.println("El disco "+auxiliar[posicionAux]+" se ha movido a auxiliar.");
			posicionAux++;
			if (posicionDestino > 0) {
			posicionDestino--;
			}
			hanoi(posicion, posicionDestino, posicionAux, origen, auxiliar, destino, resultado);
		} 	else if (auxiliar[posicionAux+1] < destino[posicionDestino+1]) {
			destino[posicionDestino] = auxiliar[posicionAux+1];
			auxiliar[posicionAux+1] = NUM_TORRES + 1;
			System.out.println("El disco "+destino[posicionDestino]+" se ha movido a destino.");
			posicionDestino++;
			if (posicionDestino == 2) {
				posicionDestino = 0; 
			}
			if (posicionAux > 0) {
			posicionAux--;
			}
			hanoi(posicion, posicionDestino, posicionAux, origen, auxiliar, destino, resultado);
		} else if (auxiliar[posicionAux+1] < origen[posicion]) {
			origen[posicion] = auxiliar[posicionAux+1];
			auxiliar[posicionAux+1] = NUM_TORRES + 1;
			System.out.println("El disco "+origen[posicion]+" se ha movido a origen.");
			posicionAux++;
			if (posicion > 0) {
			posicion--;
			}
			hanoi(posicion, posicionDestino, posicionAux, origen, auxiliar, destino, resultado);
		}
	}
	
	public int[] llenarArray() {
		int[] origen = new int[NUM_TORRES];
		for (int i = 0; i < NUM_TORRES; i++) {		
			origen[i] = i+1;
		}
		return origen; 
	}
	
	public int[] arrayCero() {
		int[] array = new int[NUM_TORRES+1];
		for (int i = 0; i < NUM_TORRES+1; i++) {		
			array[i] = NUM_TORRES+1;
		}
		return array; 
	}
	
	public int[] llenarResultado() {
		int[] origen = new int[NUM_TORRES+1];
		for (int i = 0; i < NUM_TORRES; i++) {		
			origen[i] = i+1;
		}
		origen[NUM_TORRES] = NUM_TORRES+1;
		return origen; 
	}
}
