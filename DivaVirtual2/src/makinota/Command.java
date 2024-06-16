package makinota;

public class Command {
	private ENUM_COMMAND command;
	private ByteCode instruction;
	private int replace;

	/**
	 * Constructora por defecto de la clase command
	 */
	public Command() {
		this.command = null;
	}

	/**
	 * Segunda constructora,recibe un command y lo inicializa
	 *
	 * @param _command
	 */
	public Command(ENUM_COMMAND _command) {
		this.command = _command;
	}

	/**
	 * Tercera constructora
	 *
	 * @param _command
	 * @param _instruction
	 */
	public Command(ENUM_COMMAND _command, ByteCode _instruction) {
		this.command = _command;
		this.instruction = _instruction;
	}

	/**
	 * Cuarta solo se usa cuando se haya usado el comando REPLACE)
	 *
	 * @param _command
	 * @param _replace
	 */

	public Command(ENUM_COMMAND _command, Integer _replace) {
		this.command = _command;
		this.replace = _replace;
	}

	/**
	 * Devuelve la instrucción
	 * 
	 * @return
	 */
	public ByteCode getInstruction() {
		return instruction;
	}

	/**
	 * Devuelve el argumento del replace
	 * 
	 * @return
	 */
	public Integer getReplace() {
		return replace;
	}

	/**
	 * Metodo booleano el comando que hemos recibido por parametro, le dice a Engine
	 * que ejecute el comando
	 * 
	 * @param _engine
	 * @return true o false
	 */

	public boolean execute(Engine _engine) {
		switch (this.command) {
		case HELP:
			return _engine.help();
		case QUIT:
			return _engine.quit();
		case RUN:
			return _engine.run();
		case NEWINST:
			return _engine.newinst(this);
		case RESET:
			return _engine.reset();
		case REPLACE:
			return _engine.replace(this);
		default:
			return false;
		}
	}

}
