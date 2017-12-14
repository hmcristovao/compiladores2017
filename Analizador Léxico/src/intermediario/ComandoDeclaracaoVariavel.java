package intermediario;

import parser.CompiladorHell;
import semantico.Simbolo;
import semantico.Tipo;

import java.util.LinkedList;

import intermediario2.PrimitivoAtribuicao;
import intermediario2.PrimitivoExibicao;
import intermediario2.PrimitivoListaComandos;

public class ComandoDeclaracaoVariavel extends Comando {
	private LinkedList<ComandoAtribuicao> lista;
	
	public ComandoDeclaracaoVariavel(ComandoAtribuicao atrib){
		this.lista = new LinkedList<ComandoAtribuicao>();
		this.lista.add(atrib);
	}
	
	public void addAtrib(ComandoAtribuicao atrib) {
		this.lista.add(atrib);
	}
	
	public LinkedList<ComandoAtribuicao> getAtrib() {
		return lista;
	}

	public String toString() {
		return "\n\nComando Printa: lista de atribuicao da delcaracao: " + this.lista;
	}	
	
	
	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		for(ComandoAtribuicao e: this.lista){
			Simbolo simbolo = CompiladorHell.tabela.consultaSimbolo(e.getVariavel());
			lista.add(new PrimitivoAtribuicao(simbolo, e.getExpressao()));
		}
		return lista;
	}

	
	
}
