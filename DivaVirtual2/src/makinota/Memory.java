package makinota;

public class Memory {
	private Integer[] memory;
	private final int MAX_NUM;
	private int size;
	private boolean isEmpty;

	/**
	 * Constructora
	 */
	public Memory() {
		this.MAX_NUM = 10;
		this.memory = new Integer[MAX_NUM];
		this.size = 10;
		this.isEmpty = true;
	}

	/**
	 * toString construye y devuelve una cadena que representa el estado de la
	 * memoria.
	 * 
	 * @return cadena
	 */
	public String toString() {
		String cadena = "Memoria: ";
		if (isEmpty) {
			return cadena += "---";
		} else {
			for (int i = 0; i < this.memory.length; i++) {
				if (this.memory[i] != null) {
					cadena += (" [" + i + "]: " + this.memory[i] + " ");
				}
			}
			return cadena;
		}
	}

	/**
	 * Se encarga de recibir dos paramentro,posicion valor. La posicion en la que
	 * indicamos cuando hacemos un STORE. El valor de la pila guardandolo en la
	 * posicion x de la memoria.
	 *
	 * @param _pos
	 * @param _valor
	 * @return
	 */
	public boolean write(int _pos, int _valor) {
		if (_pos >= 0) {
			this.isEmpty = false;
			resize(_pos);
			this.memory[_pos] = _valor;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna el elemento el la posicion recibida por parametro. Si en esta no hay
	 * nada escrito retornara un menos uno.
	 * 
	 * @param _pos
	 * @return
	 */
	public int read(int _pos) {
		if (this.memory[_pos] != null && _pos >= 0) {
			return this.memory[_pos];
		} else {
			return -1;
		}
	}

	/**
	 * Redimensiona la memoria
	 * 
	 * @param _pos
	 */
	private void resize(int _pos) {
		if (_pos >= this.size) {
			this.isEmpty = false;
			Integer[] new_memory = new Integer[_pos * 2];
			if (this.size >= 0)
				System.arraycopy(this.memory, 0, new_memory, 0, this.size);
			this.memory = new_memory;
		}
	}
}
