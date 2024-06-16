package makinota;

public class ByteCodeProgram {
	private ByteCode[] program;
	private int numElements;
	private int size;

	/**
	 * Constructora
	 */
	public ByteCodeProgram() {
		this.size = 10;
		this.program = new ByteCode[this.size];
		this.numElements = 0;
	}

	/**
	 * Hacer una cadena con los estados de la maquina y el programa almacenado,
	 * ejecutado codigo a codigo.
	 * 
	 * @param _cpu
	 * @return
	 */
	public String runProgram(CPU _cpu) {
		String mensaje = "";
		for (int i = 0; i < this.numElements; i++) {
			if (!_cpu.isHalt() && _cpu.execute(this.program[i])) {
				mensaje += "\n-----------------\nEl estado de la máquina tras ejecutar " + this.program[i].getName()
						+ " " + this.program[i].getParam() + " es:\n" + _cpu.toString() + "\n";
			} else if (!_cpu.isHalt()) {
				mensaje += ("No se ha podido ejecutar, ejecución incorrecta");
			}
		}
		_cpu.erase();
		_cpu.runCPU();
		return mensaje;
	}

	/**
	 * Imprime el programa almacenado
	 * 
	 * @return
	 */
	public String toString() {
		String chain = "Programa almacenado:\n";
		for (int i = 0; i < this.numElements; i++) {
			if (this.program[i].getParam() == 0) {
				chain += i + ": " + this.program[i].getName() + "\n";
			} else {
				chain += i + ": " + this.program[i].getName() + " " + this.program[i].getParam() + "\n";
			}
		}
		return chain;
	}

	/**
	 * Rehace el tamaño
	 * 
	 * @param _numElements
	 */
	private void resize(int _numElements) {
		ByteCode[] new_program = new ByteCode[_numElements * 2];
		for (int i = 0; i < this.program.length; i++) {
			new_program[i] = this.program[i];
		}
		this.program = new_program;
	}

	/**
	 * Agrega un bytecode al array
	 * 
	 * @param _byteCode
	 */
	public void addByteCode(ByteCode _byteCode) {
		if (this.numElements >= this.program.length) {
			resize(this.numElements);
			this.program[this.numElements] = _byteCode;
			this.numElements++;
		} else {
			this.program[this.numElements] = _byteCode;
			this.numElements++;
		}
	}

	/**
	 * Reemplaza un bytecode.
	 * 
	 * @param instruccion
	 * @param n
	 * @return
	 */
	public boolean replaceByteCode(ByteCode instruccion, int n) {
		if (n >= this.numElements || n <= -1) {
			return false;
		} else {
			this.program[n] = instruccion;
			return true;
		}
	}

	/**
	 * Resetea el array
	 */
	public void reset() {
		this.numElements = 0;
		this.program = new ByteCode[this.size];
	}

}
