package intermediario;

import intermediario2.*;

import java.util.LinkedList;

public class ListaComandos 
{	
	public LinkedList<Comando> comandos;
	
	public ListaComandos() {
	   this.comandos = new LinkedList<Comando>();
	}
	
	public void add(Comando com) {
		   this.comandos.add(com);
	}
	
	public PrimitivoListaComandos geraListaPrimitivoComando() {
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		for(Comando com : this.comandos) {
			lista.adicionaTodos( com.geraCodigoPrimitivo() );
		}
		return lista;
	}


    public String toString() {
    	return this.comandos.toString();
    }

}
