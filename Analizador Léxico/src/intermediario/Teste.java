package intermediario;

import java.util.LinkedList;

public class Teste extends Comando {

	private LinkedList<Condicional> condicoes;
	private ListaComandos outroCaso;
	
	
	
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
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		for(Condicional condicao:condicoes){	
			condicao.toString();	
		}
		outroCaso.toString();
		return null;
	}

}
