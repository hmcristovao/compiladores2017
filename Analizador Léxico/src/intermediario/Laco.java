package intermediario;

import intermediario2.PrimitivoListaComandos;

public class Laco extends Comando {
	
	private String varControle;	
	private Expressao expressaoInicializacao;
	private Expressao expressaoComparadora;
	private Expressao expressaoIteracao;
	private ListaComandos listaComandos;
	
	public Laco() { 
		this.varControle = null;
		this.expressaoInicializacao = null;
		this.expressaoComparadora = null;
		this.expressaoIteracao = null;
		this.listaComandos = null;        
	}

	public Laco(String _varControle, Expressao _expressaoInicializacao, Expressao _expressaoComparadora, 
			    Expressao _expressaoIteracao, ListaComandos _listaComandos) { 
        this.varControle = _varControle;
        this.expressaoInicializacao = _expressaoInicializacao;
        this.expressaoComparadora = _expressaoComparadora;
        this.expressaoIteracao = _expressaoIteracao;
        this.listaComandos = _listaComandos;
        
	}

	
	public String toString() {
		return "\n\nComando Laco: variavel de controle = " + this.varControle + 
				"- expressao de inicializacao = " + this.expressaoInicializacao +
				"- expressao de comparadora = " + this.expressaoComparadora + 
				"- expressao de iteracao = " + this.expressaoIteracao + 
				"\n- lista de comandos do Laco = " + this.listaComandos;
	}





	public String getVarControle() {
		return varControle;
	}

	public void setVarControle(String varControle) {
		this.varControle = varControle;
	}

	public Expressao getExpressaoInicializacao() {
		return expressaoInicializacao;
	}

	public void setExpressaoInicializacao(Expressao expressaoInicializacao) {
		this.expressaoInicializacao = expressaoInicializacao;
	}

	public Expressao getExpressaoComparadora() {
		return expressaoComparadora;
	}


	public void setExpressaoComparadora(Expressao expressaoComparadora) {
		this.expressaoComparadora = expressaoComparadora;
	}
	
	public Expressao getExpressaoIteracao() {
		return expressaoIteracao;
	}

	public void setExpressaoIteracao(Expressao expressaoIteracao) {
		this.expressaoIteracao = expressaoIteracao;
	}

	public ListaComandos getListaComandos() {
		return listaComandos;
	}

	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}




	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		/* falta implementar ... */  
		return lista;
	}

	


}
