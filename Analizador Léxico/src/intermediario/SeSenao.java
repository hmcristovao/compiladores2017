package intermediario;

public class SeSenao extends Comando{
	
	private Expressao expSeSenao; 
	private ListaComandos listaComandosCondicaoVerdadeiro;
	private ListaComandos listaComandosCondicaoFalsa;
	
	public SeSenao(Expressao _expSeSenao, ListaComandos _listaComandosCondicaoVerdadeiro, ListaComandos _listaComandosCondicaoFalsa){
		this.expSeSenao = _expSeSenao;
		this.listaComandosCondicaoVerdadeiro = _listaComandosCondicaoVerdadeiro;
		this.listaComandosCondicaoFalsa = _listaComandosCondicaoFalsa;
		
	}


	@Override
	public String toString() {
		return "SeSenao [expSeSenao=" + expSeSenao + ", listaComandosCondicaoVerdadeiro=" + listaComandosCondicaoVerdadeiro + ", listaComandosCondicaoFalsa=" + listaComandosCondicaoFalsa + "]";
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


	public ListaComandos getListaComandosCondicaoFalsa() {
		return listaComandosCondicaoFalsa;
	}


	public void setListaComandosCondicaoFalsa(
			ListaComandos listaComandosCondicaoFalsa) {
		this.listaComandosCondicaoFalsa = listaComandosCondicaoFalsa;
	}
	
	

}
