package intermediario;

import parser.CompiladorHell;
import semantico.*;
import intermediario2.*;

public class IfLoop extends Comando {
	
	private String varControladora;
	private Expressao expressaoComparadora;
	private Expressao expressaoLoop;
	private ListaComandos listaComandos;
	
	public IfLoop() {
		this.varControladora = null;
		this.expressaoComparadora = null;
		this.listaComandos = null;        
	}
	
	public IfLoop(String _varControladora , Expressao _expressaoComparadora, 
			    ListaComandos _listaComandos) { 
        this.varControladora = _varControladora;
        this.expressaoComparadora = _expressaoComparadora;
        this.listaComandos = _listaComandos;
        
	}

	public String toString() {
		return "\n\nComando IfLoop: valor de controle = " + this.varControladora +
				"- expressao de comparadora = " + this.expressaoComparadora +
				"\n- lista de comandos do IfLoop = " + this.listaComandos;
	}



	public String getExpressaoControladora() {
		return varControladora;
	}

	public void setVarControladora(String varControladora) {
		this.varControladora = varControladora;
	}

	public Expressao getExpressaoComparadora() {
		return expressaoComparadora;
	}


	public void setExpressaoComparadora(Expressao expressaoComparadora) {
		this.expressaoComparadora = expressaoComparadora;
	}

	public ListaComandos getListaComandos() {
		return listaComandos;
	}

	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}
	
    
	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		
		PrimitivoLabel labelInicio = new PrimitivoLabel("LabelInicio");
		PrimitivoLabel labelCont = new PrimitivoLabel("LabelCont");
		PrimitivoLabel labelFim = new PrimitivoLabel("LabelFim");
		
		lista.add(new PrimitivoSeGoto(expressaoComparadora, labelInicio));
		lista.add(new PrimitivoGoto(labelFim));
		lista.add(labelInicio);
		lista.add(new PrimitivoLoop(labelCont, varControladora,0));
		lista.add(labelCont);
		for(Comando c: listaComandos.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
		lista.add(new PrimitivoLoop(labelCont, varControladora,1));
		lista.add(labelFim);
		return lista;
	}

	


}
