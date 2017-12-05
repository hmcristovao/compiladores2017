package intermediario;

import intermediario2.PrimitivoListaComandos;

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
		PrimitivoSeGoto primitivo = new PrimitivoSeGoto();
		LinkedList<PrimitivoLabel> labelLista = new LinkedList<PrimitivoLabel>();
		String label  = "labelCase";
		String labelFim = "labelCaseFim";
		Integer contador = 0;
		for(Condicional i: condicoes){
			PrimitvoLabel pl = new PrimitvoLabel(label+contador);
			labelLista.add(pl);
			lista.addPrimitivoComando(new PrimitivoSeGoto(i.getExpressao(),pl));
			contador++;
		}
		for(Comando c: outroCaso.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
		lista.addPrimitivoComando(new PrimitivoGoto(new PrimitivoLabel(labelFim)));
		
		//Reiniciando a numeração do label
		contador = 0;		
		for(Condicional i: condicoes){
			PrimitivoLabel aux = labelLista.get(contador);
			lista.addPrimitivoComando(new PrimitivoLabel(aux));
				
			for(Comando c: i.getListaComandos().comandos){
				lista.adicionaTodos(c.geraCodigoPrimitivo());
			}
			contador++;
			lista.addPrimitivoComando(new PrimitivoGoto(new PrimitivoLabel(labelFim)));
		}	
		lista.addPrimitivoComando(new PrimitivoLabel(labelFim));
		
		return lista;
	}

	

}
