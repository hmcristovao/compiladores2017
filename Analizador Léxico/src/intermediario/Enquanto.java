package intermediario;

import parser.CompiladorHell;
import semantico.Simbolo;
import semantico.Tipo;
import intermediario2.*;

public class Enquanto extends Comando {
	
	private Expressao expressaoComparadora;
	private ListaComandos listaComandos;
	
	public Enquanto() { 
		this.expressaoComparadora = null;
		this.listaComandos = null;        
	}

	public Enquanto(Expressao _expressaoComparadora, ListaComandos _listaComandos) { 
        this.expressaoComparadora = _expressaoComparadora;
        this.listaComandos = _listaComandos;
        
	}

	
	public String toString() {
		return "\n\n" + 
				"- expressao de comparadora = " + this.expressaoComparadora + 
				"\n- lista de comandos do Enquanto = " + this.listaComandos;
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
		PrimitivoLabel labelFim = new PrimitivoLabel("LabelFim");
		
		lista.add(new PrimitivoSeGoto(this.expressaoComparadora, labelInicio));
		lista.add(new PrimitivoGoto(labelFim));
		lista.add(labelInicio);
		
		for(Comando c: listaComandos.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
		
		lista.add(new PrimitivoSeGoto(this.expressaoComparadora, labelInicio));
		lista.add(labelFim);
		
		return lista;
	}

	


}
