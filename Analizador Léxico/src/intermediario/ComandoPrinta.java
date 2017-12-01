package intermediario;
import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

public class ComandoPrinta extends Comando {
	private LinkedList<Expressao> expressao;
	
	public ComandoPrinta(Expressao expressao){
		this.expressao = new LinkedList<Expressao>();
		this.expressao.add(expressao);
	}

	public void addExpressao(Expressao expressao) {
		this.expressao.add(expressao);
	}
	
	public LinkedList<Expressao> getExpressao() {
		return expressao;
	}

	public String toString() {
		return "\n\nComando Printa: lista de expressoes: " + this.expressao;
	}	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		/* falta implementar ... */  
		return lista;
	}

	
}