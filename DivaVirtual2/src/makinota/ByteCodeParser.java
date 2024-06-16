package makinota;

public class ByteCodeParser {

	/**
	 * devuelve el bytecode
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public static ByteCode parse(String n, String m) {
		switch (n.toLowerCase()) {
		case "push":
			return new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(m));
		case "load":
			return new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(m));
		case "store":
			return new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(m));
		}
		return null;
	}

	/**
	 * devuelve el bytecode
	 * 
	 * @param _i
	 * @return
	 */
	public static ByteCode parse(String _i) {
		switch (_i.toLowerCase()) {
		case "add":
			return new ByteCode(ENUM_BYTECODE.ADD);
		case "sub":
			return new ByteCode(ENUM_BYTECODE.SUB);
		case "mul":
			return new ByteCode(ENUM_BYTECODE.MUL);
		case "div":
			return new ByteCode(ENUM_BYTECODE.DIV);
		case "out":
			return new ByteCode(ENUM_BYTECODE.OUT);
		case "halt":
			return new ByteCode(ENUM_BYTECODE.HALT);
		}
		return null;
	}

}
