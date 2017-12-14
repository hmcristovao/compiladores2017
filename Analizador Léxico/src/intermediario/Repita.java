package intermediario;

import parser.CompiladorHell;
import semantico.Simbolo;

import intermediario2.*;

public class Repita extends Comando {
	
	private String varControle;	
	
	private ListaComandos listaComandos;
	
	public Repita() { 
		this.varControle = null;
		this.listaComandos = null;        
	}

	public Repita(String _varControle,ListaComandos _listaComandos) { 
        this.varControle = _varControle;
        this.listaComandos = _listaComandos;
        
	}

	
	public String toString() {
		return "\n\nComando Repita: variavel de controle = " + this.varControle +  
				"\n- lista de comandos do Repita = " + this.listaComandos;
	}


	public String getVarControle() {
		return varControle;
	}

	public void setVarControle(String varControle) {
		this.varControle = varControle;
	}

	

	public ListaComandos getListaComandos() {
		return listaComandos;
	}

	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		
		PrimitivoLabel labelInicio = new PrimitivoLabel("LabelInicioRepita");
		PrimitivoLabel labelCont = new PrimitivoLabel("LabelCont");
		PrimitivoLabel labelFim = new PrimitivoLabel("LabelFim");
		
		Simbolo simbolo = CompiladorHell.tabela.consultaSimbolo(varControle);
		
		lista.add(labelInicio);
		lista.add(new PrimitivoRepita(simbolo, labelInicio, labelCont, labelFim));
		lista.add(labelCont);
		for(Comando c: listaComandos.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
		lista.add(new PrimitivoGoto(labelInicio));
		lista.add(labelFim);
		
		return lista;
	}

}
