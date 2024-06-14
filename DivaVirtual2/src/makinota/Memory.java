package makinota;

public class Memory {
	 private Integer[] memory;
	    private final int MAX_NUM;
	    private int size;
	    private boolean isEmpty;

	    public Memory() {
	        this.MAX_NUM = 10;
	        this.memory = new Integer[MAX_NUM];
	        this.size = 10;
	        this.isEmpty = true;
	    }

	    /**
	     * Redimensiona la memoria
	     * @param _pos
	     */
	    private void resize(int _pos) {
	        if (_pos >= this.size) {
	            this.isEmpty = false;
	            Integer[] new_memory = new Integer[_pos * 2];
	            if (this.size >= 0) System.arraycopy(this.memory, 0, new_memory, 0, this.size);
	            this.memory = new_memory;
	        }
	    }

	    /**
	     * toString
	     * Complejidad 0(n)
	     * @return
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
	     * Escribe en la memoria
	     * @param _pos
	     * @param _value
	     * @return
	     */
	    public boolean write(int _pos, int _value) {
	        if (_pos >= 0) {
	            this.isEmpty = false;
	            resize(_pos);
	            this.memory[_pos] = _value;
	            return true;
	        } else {
	            return false;
	        }
	    }

	    /**
	     * Lee de la memoria
	     * @param _pos
	     * @return
	     */
	    public int read(int _pos) {
	        if (this.memory[_pos] != null && _pos>=0) {
	            return this.memory[_pos];
	        } else {
	            return -1;
	        }
	    }
}
