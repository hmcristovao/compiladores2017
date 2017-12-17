package intermediario;

import intermediario2.PrimitivoListaComandos;
import semantico.Item;
import java.util.HashMap;

public class ComandoSelect extends Comando {
	
	private String variavel;
	private HashMap<Item,ListaComandos> option;

	public String getVariavel() {
		return variavel;
	}
	public void setVariavel(String variavel) {
		this.variavel = variavel;
	}
	public HashMap<Item, ListaComandos> getOption() {
		return option;
	}
	public void setOption(Item item,ListaComandos listaComandos) {		
		this.option.put(item,listaComandos);
	}
	@Override
	public PrimitivoListaComandos geraCodigoPrimitivo() {
		return null;
	}
	@Override
	public String toString() {
		return "\n\nComando Select: variavel: " + this.variavel + "- options: " + this.option.toString();
		
	}
}
