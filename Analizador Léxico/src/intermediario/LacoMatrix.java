package intermediario;

import java.util.ArrayList;

import semantico.Simbolo;

public class LacoMatrix {
	
	private ArrayList<Simbolo> variaveisControle;
	private Expressao expressaoInicial;
	private Expressao expressaoFinal;
	private Expressao expressaoPasso;
	private ListaComandos listaComandos;
	
	public LacoMatrix(ArrayList<Simbolo> _variaveisControle, Expressao _expressaoInicial, Expressao _expressaoFinal, Expressao _expressaoPasso, ListaComandos _listaComandos
			 ) { 
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

	public ArrayList<Simbolo> getVariaveisControle() {
		return variaveisControle;
	}
	public void setVariaveisControle(Simbolo varControle) {
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

}
