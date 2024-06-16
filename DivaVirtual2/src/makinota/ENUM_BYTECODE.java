package makinota;

public enum ENUM_BYTECODE {
	PUSH(1), LOAD(1), STORE(1), ADD, SUB, MUL, DIV, OUT, HALT;

	private int valueArg;

	/**
	 * Constructora por defcto
	 */
	ENUM_BYTECODE() {
		this(0);
	}

	/**
	 * Segunda constructora
	 * 
	 * @param n indica el numero siguiente de un ByteCode
	 */
	ENUM_BYTECODE(int n) {
		this.valueArg = n;
	}

	/**
	 * Devuelve el número de parámetros que tiene una instrucción
	 * 
	 * @return this.valueArg
	 */
	public int getValueArg() {
		return this.valueArg;
	}
}
