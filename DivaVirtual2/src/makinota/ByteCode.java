package makinota;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;

	/**
	 * Constructoa
	 * 
	 * @param _enumBytecode
	 */
	public ByteCode(ENUM_BYTECODE _enumBytecode) {
		this.name = _enumBytecode;
	}

	/**
	 * Segunda constructora
	 * 
	 * @param _enumBytecode
	 * @param _param
	 */
	public ByteCode(ENUM_BYTECODE _enumBytecode, int _param) {
		this.param = _param;
		this.name = _enumBytecode;
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		return this.name.toString() + " " + param;
	}

	/**
	 * devuleve el nombre
	 * 
	 * @return
	 */
	public ENUM_BYTECODE getName() {
		return this.name;
	}

	/**
	 * devuleve el parametro
	 * 
	 * @return
	 */
	public int getParam() {
		return this.param;
	}

}
