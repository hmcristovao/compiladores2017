package intermediario;


import intermediario2.PrimitivoGoto;
import intermediario2.PrimitivoLabel;
import intermediario2.PrimitivoListaComandos;
import intermediario2.PrimitivoSeGoto;

import java.util.LinkedList;

public class Teste extends Comando {

	private LinkedList<Condicional> condicoes;
	private ListaComandos outroCaso;
	
	public Teste() {
		this.condicoes = new LinkedList<Condicional>();
		this.outroCaso = new ListaComandos();
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
		return "\n\nComando Teste: lista de condicoes = " + this.condicoes +
				"\n- lista de comandos para outro caso = " + this.outroCaso;
	}	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		LinkedList<PrimitivoLabel> labelLista = new LinkedList<PrimitivoLabel>();
		String label  = "labelCase";
		String labelFim = "labelCaseFim";
		Integer contador = 0;
		for(Condicional i: condicoes){
			PrimitivoLabel pl = new PrimitivoLabel(label+contador);
			labelLista.add(pl);
			lista.add(new PrimitivoSeGoto(i.getExpressao(),pl));
			contador++;
		}
		for(Comando c: outroCaso.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
		lista.add(new PrimitivoGoto(new PrimitivoLabel(labelFim)));
		
		//Reiniciando a numera��o do label
		contador = 0;		
		for(Condicional i: condicoes){
			PrimitivoLabel aux = labelLista.get(contador);
			lista.add(aux);
				
			for(Comando c: i.getListaComandos().comandos){
				lista.adicionaTodos(c.geraCodigoPrimitivo());
			}
			contador++;
			lista.add(new PrimitivoGoto(new PrimitivoLabel(labelFim)));
		}	
		lista.add(new PrimitivoLabel(labelFim));
		
		return lista;
	}

	

}
