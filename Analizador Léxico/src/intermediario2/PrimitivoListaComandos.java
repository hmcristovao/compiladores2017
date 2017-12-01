package intermediario2;

import java.util.LinkedList;

public class PrimitivoListaComandos  {
	public LinkedList<PrimitivoComando> comandos;
	
	public PrimitivoListaComandos() {
		   this.comandos = new LinkedList();
	}
	
	// adiciona uma lista no final
	public void adicionaTodos(PrimitivoListaComandos lista) {
		this.comandos.addAll(lista.comandos);
	}
	
    public String toString() {
    	return this.comandos.toString();
    }
}
