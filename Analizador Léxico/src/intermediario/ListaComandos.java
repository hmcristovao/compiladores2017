package intermediario;

import intermediario2.*;

import java.util.LinkedList;

public class ListaComandos 
{	
	public LinkedList<Comando> comandos;
	
	public void add(Comando com) {
	   System.out.println(com.getClass());
	   System.out.println(com);
	   if(com != null)  
		   this.comandos.add(com);
	}
	
	public PrimitivoListaComandos geraListaPrimitivoComando() {
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		for(Comando com : this.comandos) {
			lista.adicionaTodos( com.geraCodigoPrimitivo() );
		}
		return lista;
	}
}
