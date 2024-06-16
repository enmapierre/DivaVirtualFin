package makinota;

public class CPU {
	private OpenStack pila;
	private Memory memory;
	private boolean halt;

	/**
	 * Constructora, inicializa los atributos
	 */
	public CPU() {
		this.memory = new Memory();
		this.pila = new OpenStack();
		this.halt = false;
	}

	/**
	 * Arranca la maquina
	 */
	public void runCPU() {
		this.halt = false;
	}

	/**
	 * detiene la CPU cambiando el valor de halt a true.
	 * 
	 * @return this.halt (el halt en true)
	 */
	public boolean stopCPU() {
		this.halt = true;
		return true;
	}

	/**
	 * Resetea la pila y crea unas nuevas
	 * 
	 * @return
	 */
	public boolean reset() {
		this.pila = new OpenStack();
		this.memory = new Memory();
		return true;
	}

	/**
	 * Devuelve un booleano de si la maquina esta parada o no.
	 * 
	 * @return
	 */
	public boolean isHalt() {
		return this.halt;
	}

	/**
	 * Compara codigos del parametro, se llama metodo si consuerda y ejecuta
	 * 
	 * @param instruccion
	 * @return
	 */
	public boolean execute(ByteCode instruccion) {
		switch (instruccion.getName()) {
		case ADD:
			return sumaPila();
		case PUSH:
			return this.pila.push(instruccion.getParam());
		case LOAD:
			return loadMemoria(instruccion.getParam());
		case STORE:
			return storeMemoria(instruccion.getParam());
		case SUB:
			return restarPila();
		case MUL:
			return multiplicarPila();
		case DIV:
			return dividirPila();
		case OUT:
			return outPila();
		case HALT:
			return stopCPU();
		default:
			return false;
		}
	}

	/**
	 * Crea una cadena con la cima de la pila cuando este sea ejecutado e imprimirla
	 * al comienzo de run.
	 *
	 * @return true si la pila no esta vacia.
	 */
	public boolean outPila() {
		runCPU();
		int temp = this.pila.pop();
		this.pila.push(temp);
		System.out.println("La cima de la pila es: " + temp);
		return true;
	}

	/**
	 * Recoge parametro de la memoria de la posicion elegida e introduce en pila
	 * 
	 * @param _pos
	 * @return true
	 */
	public boolean loadMemoria(int _pos) {
		runCPU();
		this.pila.push(this.memory.read(_pos));
		return true;
	}

	/**
	 * Guarda en la memoria el elemento de la cima de la pila y este se introduce en
	 * la posicon que el usuario diga.
	 * 
	 * @param _pos
	 * @return true si la pila no esta vacia
	 */
	public boolean storeMemoria(int _pos) {
		runCPU();
		this.memory.write(_pos, this.pila.pop());
		return true;
	}

	/**
	 * Encargado de llamar al metodo toString del OpenStack
	 * 
	 * @return
	 */
	public String toString() {
		return "\nEstado de la CPU:\n" + memory.toString() + "\n" + pila.toString() + "\n-----------------";
	}

	/**
	 * Borra la memoria y la pila
	 */
	public void erase() {
		this.memory = new Memory();
		this.pila = new OpenStack();
	}

	/**
	 * Suma los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean sumaPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 + e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Resta los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean restarPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 - e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Multiplica los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean multiplicarPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 * e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Divide los 2 ultimos de la pila
	 * 
	 * @return
	 */
	public boolean dividirPila() {
		runCPU();
		if (!this.pila.isEmpty()) {
			int e1 = this.pila.pop();
			if (!this.pila.isEmpty()) {
				int e2 = this.pila.pop();
				int result = e1 / e2;
				this.pila.push(result);
				return true;
			} else {
				this.pila.push(e1);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Agrega un elemento a la pila
	 * 
	 * @param a
	 * @return true si push no ha habido nignun error
	 */
	public boolean push(int a) {
		runCPU();
		this.pila.push(a);
		return true;
	}
}
