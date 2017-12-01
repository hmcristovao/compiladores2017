package intermediario;

import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

public class Teste extends Comando {

	private LinkedList<Condicional> condicoes;
	private ListaComandos outroCaso;
	
	public Teste() {
		this.condicoes = null;
		this.outroCaso = null;
	}

	public Teste(LinkedList<Condicional> condicoes, ListaComandos outroCaso) {
		this.condicoes = condicoes;
		this.outroCaso = outroCaso;
	}

	public LinkedList<Condicional> getCondicoes() {
		return condicoes;
	}

	public void setCondicoes(LinkedList<Condicional> condicoes) {
		this.condicoes = condicoes;
	}
	
	public void addCondicoes(Condicional condicao) {
		this.condicoes.add(condicao);
	}

	public ListaComandos getOutroCaso() {
		return outroCaso;
	}

	public void setOutroCaso(ListaComandos outroCaso) {
		this.outroCaso = outroCaso;
	}
	
	
	
	public String toString() {
		return "\n\nComando Teste, lista de condicoes: " + this.condicoes +
				", lista de comandos para outro caso: " + this.outroCaso;
	}	

	
	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		/* falta implementar ... */  
		return null;
	}

	

}
