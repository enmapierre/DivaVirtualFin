package makinota;

public class OpenStack {
	private int[] stack;
	private int num_elements;
	private int MAX_NUM;

	/**
	 * Constructora
	 */
	public OpenStack() {
		this.MAX_NUM = 10;
		this.num_elements = 0;
		this.stack = new int[MAX_NUM];
	}

	/**
	 * toString se encarga de crear la cadena. Recorriendo stack imprimiendo los
	 * valores almacenados
	 * 
	 * @return cadena string
	 */
	public String toString() {
		String cadena = "Pila: ";
		if (isEmpty()) {
			return cadena += "---";
		} else {
			for (int i = 0; i < this.num_elements; i++) {
				cadena += (" " + this.stack[i] + " ");
			}
			return cadena;
		}

	}

	/**
	 * Comprueba que la pila no esté vacía
	 * 
	 * @return false si hay elementos, true si no hay
	 */
	public boolean isEmpty() {
		return this.num_elements == 0;
	}

	/**
	 * Recibe por parametro un int y comprueba si el stack esta lleno, si no lo esta
	 * agregara el int recibido en la siguiente posicion libre del array
	 * 
	 * @param _elemento
	 * @return
	 */
	public boolean push(int _elemento) {
		if (this.num_elements < MAX_NUM) {
			this.stack[this.num_elements] = _elemento;
			this.num_elements++;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Devuelve el primer elemento de la pila y lo elimina
	 * 
	 * @return
	 */
	public int pop() {
		if (isEmpty()) {
			return -1;
		} else {
			int ultimo = this.stack[this.num_elements - 1];
			this.num_elements--;
			return ultimo;
		}

	}

}
