package intermediario;

import intermediario2.PrimitivoListaComandos;

public class ComandoAtribuicao extends Comando {
	private String variavel;
	private Expressao expressao;
	
	public ComandoAtribuicao(String variavel, Expressao expressao){
		this.variavel = variavel;
		this.expressao = expressao;
	}
	
	public String getVariavel() {
		return variavel;
	}

	public void setVariavel(String variavel) {
		this.variavel = variavel;
	}

	public Expressao getExpressao() {
		return expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}

	public String toString() {
		return "\n\nComando Atribuicao, variavel: " + this.variavel + ", expressao: " + expressao.toString();
	}
	
	
	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		/* falta implementar ... */  
		return null;
	}
	
	
}
