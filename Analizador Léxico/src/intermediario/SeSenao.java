package intermediario;

import intermediario2.*;

public class SeSenao extends Comando{
	
	private Expressao expSeSenao; 
	private ListaComandos listaComandosCondicaoVerdadeiro;
	private ListaComandos listaComandosCondicaoFalsa;
	
	
	public SeSenao(){
		this.expSeSenao = null;
		this.listaComandosCondicaoVerdadeiro = null;
		this.listaComandosCondicaoFalsa = null;		
	}
	public SeSenao(Expressao _expSeSenao, ListaComandos _listaComandosCondicaoVerdadeiro, ListaComandos _listaComandosCondicaoFalsa){
		this.expSeSenao = _expSeSenao;
		this.listaComandosCondicaoVerdadeiro = _listaComandosCondicaoVerdadeiro;
		this.listaComandosCondicaoFalsa = _listaComandosCondicaoFalsa;		
	}


	public String toString() {
		return "\n\nComando Sesenao: expressao condicional: " + this.expSeSenao + 
				"\n- lista de comandos SeSenao condicao verdadeira = " + this.listaComandosCondicaoVerdadeiro + 
				"\n- lista de comandos SeSenao condicao falsa = " + this.listaComandosCondicaoFalsa;
	}


	public Expressao getExpSeSenao() {
		return expSeSenao;
	}


	public void setExpSeSenao(Expressao expSeSenao) {
		this.expSeSenao = expSeSenao;
	}


	public ListaComandos getListaComandosCondicaoVerdadeiro() {
		return listaComandosCondicaoVerdadeiro;
	}


	public void setListaComandosCondicaoVerdadeiro(
			ListaComandos listaComandosCondicaoVerdadeiro) {
		this.listaComandosCondicaoVerdadeiro = listaComandosCondicaoVerdadeiro;
	}


	public ListaComandos getListaComandosCondicaoFalso() {
		return listaComandosCondicaoFalsa;
	}


	public void setListaComandosCondicaoFalso(ListaComandos listaComandosCondicaoFalsa) {
		this.listaComandosCondicaoFalsa = listaComandosCondicaoFalsa;
	}
	

	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
			String labelVerdadeiro  = "labelVerdadeiro";
			String labelFim = "labelFim";
			
			lista.addPrimitivoComando(new PrimitivoSeGoto(expSeSenao, new PrimitivoLabel(labelVerdadeiro)));
			for(Comando c: listaComandosCondicaoFalsa.comandos){
				lista.adicionaTodos(c.geraCodigoPrimitivo());
			}
			
			lista.addPrimitivoComando(new PrimitivoGoto(new PrimitivoLabel(labelFim)));
			lista.addPrimitivoComando(new PrimitivoLabel(labelVerdadeiro));
			
			for(Comando c: listaComandosCondicaoVerdadeiro.comandos){
				lista.adicionaTodos(c.geraCodigoPrimitivo());
			}
			
			lista.addPrimitivoComando(new PrimitivoLabel(labelFim));
		return lista;
	}

	


}
	

