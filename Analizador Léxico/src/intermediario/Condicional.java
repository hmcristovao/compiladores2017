package intermediario;

public class Condicional {
	
	
	private Expressao expressao;
	private ListaComandos listaComandos;

	public Condicional() {
		this.expressao = null;
		this.listaComandos = null;
	}
	
	public Condicional(Expressao expressao, ListaComandos listaComandos) {
		this.expressao = expressao;
		this.listaComandos = listaComandos;
	}

	public Expressao getExpressao() {
		return expressao;
	}
	
	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}
	
	public ListaComandos getListaComandos() {
		return listaComandos;
	}
	
	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}
	
}
