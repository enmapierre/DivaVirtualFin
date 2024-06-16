package makinota;

public class CommandParser {
	/**
	 * Recibe por parametro lo que ha introducido el usuario y se encarga de
	 * parsearlo.
	 * 
	 * @param n
	 * @return depende del comando que ha introducido el usuario
	 */
	public static Command parse(String n) {
		String[] partir = n.toLowerCase().split(" ");
		switch (partir[0]) {
		case "help":
			return new Command(ENUM_COMMAND.HELP);
		case "quit":
			return new Command(ENUM_COMMAND.QUIT);
		case "run":
			return new Command(ENUM_COMMAND.RUN);
		case "reset":
			return new Command(ENUM_COMMAND.RESET);
		case "newinst":
			if (partir.length == 3) {
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(partir[1], partir[2]));
			} else if (partir.length == 2) {
				return new Command(ENUM_COMMAND.NEWINST, ByteCodeParser.parse(partir[1]));
			}

		case "replace":
			return new Command(ENUM_COMMAND.REPLACE, Integer.parseInt(partir[1]));
		default:
			return null;
		}
	}

}
