package makinota;

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram program;
	private boolean end;
	private CPU cpu;

	/**
	 * Constructora
	 */
	public Engine() {
		program = new ByteCodeProgram();
		end = false;
		cpu = new CPU();
	}

	/**
	 * Limpia la consola
	 */
	public void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.print("\n");
		}
	}

	/**
	 * Ejecuta
	 */
	public void start() {
		Scanner sc = new Scanner(System.in);
		while (!this.end) {
			String instruccion = sc.nextLine();
			Command comando = CommandParser.parse(instruccion);
			System.out.println("Comienza la ejecución de [" + instruccion.toUpperCase() + "]");
			if (comando != null) {
				if (comando.execute(this)) {

				} else {
					System.out.println("No se ha podido ejecutar, ejecución incorrecta.");
				}
			} else {
				System.out.println("No se ha podido ejecutar, comando incorrecto.");
			}

		}
	}

	/**
	 * muestra como funciona la maquina
	 * 
	 * @return
	 */
	public boolean help() {
		System.out.println("HELP" + ": Muestra esta ayuda\n" + "QUIT" + ": Cierra la aplicacion\n" + "RUN"
				+ ": Ejecuta el programa\n" + "NEWINST BYTECODE" + ": Introduce una nueva instrucción al programa\n"
				+ "RESET" + ": Vacia el programa actual\n" + "REPLACE N"
				+ ": Reemplaza la instruccion N por la solicitada al usuario");
		return true;
	}

	/**
	 * Apaga la maquina
	 * 
	 * @return
	 */
	public boolean quit() {
		System.out.println("Maquina Apagada");
		this.end = true;
		return true;
	}

	/**
	 * Ejecuta el programa
	 * 
	 * @return
	 */
	public boolean run() {
		System.out.println(this.program.runProgram(this.cpu));
		System.out.println(this.program.toString());
		return true;
	}

	/**
	 * Introduce un ByteCode al programa y luego imprime por pantalla el programa
	 * almacenado
	 * 
	 * @param _comando
	 * @return
	 */
	public boolean newinst(Command _comando) {
		if (_comando.getInstruction() != null) {
			this.program.addByteCode(_comando.getInstruction());
			System.out.println(this.program.toString());
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Reseta
	 * 
	 * @return
	 */
	public boolean reset() {
		if (this.cpu.reset()) {
			clearScreen();
			System.out.println("Borrando el estado de la máquina");
			this.program.reset();
		} else {
			System.out.println("Algo ha fallado");
		}
		return true;
	}

	/**
	 * Imprime por pantalla una cadena y deja al usuario a introducir una nueva
	 * cadena.
	 * 
	 * @param _comando
	 * @return
	 */
	public boolean replace(Command _comando) {
		if (_comando != null) {
			Scanner sc = new Scanner(System.in);
			String instruccion = sc.nextLine();
			String[] particion = instruccion.split(" ");
			if (particion.length == 1) {
				ByteCode x = ByteCodeParser.parse(particion[0]);
				if (x != null) {
					this.program.replaceByteCode(x, _comando.getReplace());
				} else {
					return false;
				}
			} else {
				ByteCode x = ByteCodeParser.parse(particion[0], particion[1]);
				if (x != null) {
					this.program.replaceByteCode(x, _comando.getReplace());
				} else {
					return false;
				}
			}
			System.out.println(this.program.toString());
			return true;

		} else {
			System.out.println(this.program.toString());
			return false;
		}
	}

}
