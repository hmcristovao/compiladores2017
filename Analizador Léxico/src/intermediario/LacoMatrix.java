package intermediario;

import intermediario2.PrimitivoListaComandos;

import java.util.ArrayList;

import semantico.Simbolo;

public class LacoMatrix extends Comando {
	
	private ArrayList<String> variaveisControle;
	private Expressao expressaoInicial;
	private Expressao expressaoFinal;
	private Expressao expressaoPasso;
	private ListaComandos listaComandos;
	
	public LacoMatrix() { 
	    this.variaveisControle = null;
	    this.expressaoInicial = null;
	    this.expressaoFinal = null;
	    this.expressaoPasso = null;
	    this.listaComandos = null;
    
	}
	public LacoMatrix(ArrayList<String> _variaveisControle, Expressao _expressaoInicial, 
			          Expressao _expressaoFinal, Expressao _expressaoPasso, ListaComandos _listaComandos) 
	{ 
        this.variaveisControle = _variaveisControle;
        this.expressaoInicial = _expressaoInicial;
        this.expressaoFinal = _expressaoFinal;
        this.expressaoPasso = _expressaoPasso;
        this.listaComandos = _listaComandos;
    }
	@Override
	public String toString() {
		return "LacoMatrix [variaveisControle=" + variaveisControle
				+ ", expressaoInicial=" + expressaoInicial
				+ ", expressaoFinal=" + expressaoFinal + ", expressaoPasso="
				+ expressaoPasso + ", listaComandos=" + listaComandos + "]";
	}

	public ArrayList<String> getVariaveisControle() {
		return variaveisControle;
	}
	public void setVariaveisControle(String varControle) {
		this.variaveisControle.add(varControle);
	}
	public Expressao getExpressaoInicial() {
		return expressaoInicial;
	}
	public void setExpressaoInicial(Expressao expressaoInicial) {
		this.expressaoInicial = expressaoInicial;
	}
	public Expressao getExpressaoFinal() {
		return expressaoFinal;
	}
	public void setExpressaoFinal(Expressao expressaoFinal) {
		this.expressaoFinal = expressaoFinal;
	}
	public Expressao getExpressaoPasso() {
		return expressaoPasso;
	}
	public void setExpressaoPasso(Expressao expressaoPasso) {
		this.expressaoPasso = expressaoPasso;
	}
	public ListaComandos getListaComandos() {
		return listaComandos;
	}
	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}

	
	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		/* falta implementar ... */  
		return null;
	}

	

}
