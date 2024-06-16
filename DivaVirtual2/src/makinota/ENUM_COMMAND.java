package makinota;

public enum ENUM_COMMAND {
	HELP, QUIT, NEWINST(1), RUN, RESET, REPLACE(1);

	private int valueArg;

	/**
	 * Constructora por defecto
	 */
	ENUM_COMMAND() {
		this.valueArg = 0;
	}

	/**
	 * Segunda constructora
	 * 
	 * @param n
	 */
	ENUM_COMMAND(int n) {
		this.valueArg = n;
	}

	/**
	 * Devuelve el número de parámetros que tiene un comando
	 * 
	 * @return this.valueArg
	 */
	public int getValueArg() {
		return this.valueArg;
	}
}
