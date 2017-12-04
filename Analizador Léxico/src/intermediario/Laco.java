package intermediario;

import java.util.LinkedList;

import parser.CompiladorHell;
import semantico.Simbolo;
import semantico.Tipo;
import intermediario2.PrimitivoAtribuicao;
import intermediario2.PrimitivoGoto;
import intermediario2.PrimitivoLabel;
import intermediario2.PrimitivoListaComandos;
import intermediario2.PrimitivoSeGoto;

import intermediario.*;

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
		
		String labelInicio = "LabelInicio";
		String labelCont = "LabelCont";
		
		Tipo t = CompiladorHell.tabela.consultaTipo(varControle);
		Simbolo s = new Simbolo(varControle, t);
		
		lista.addPrimitivoComando(new PrimitivoAtribuicao(s, expressaoInicializacao));
		lista.addPrimitivoComando(new PrimitivoLabel(labelInicio));
		lista.addPrimitivoComando(
				new PrimitivoSeGoto(expressaoComparadora, 
						new PrimitivoLabel(labelCont))
		);
		
		for(Comando c: listaComandos.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
				
		lista.addPrimitivoComando(new PrimitivoAtribuicao(s, expressaoIteracao));
		lista.addPrimitivoComando(new PrimitivoGoto(new PrimitivoLabel(labelInicio)));
		
		return lista;
	}

	


}
