package intermediario;

import intermediario2.PrimitivoListaComandos;

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
		return "\n\nComando Sesenao, expressao: " + this.expSeSenao + 
				", lista de comandos condicao verdadeira = " + this.listaComandosCondicaoVerdadeiro + 
				", lista de comandos condicao falsa = " + this.listaComandosCondicaoFalsa;
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
		/* falta implementar ... */  
		return null;
	}

	


}
	

