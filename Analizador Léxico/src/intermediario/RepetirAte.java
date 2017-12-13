package intermediario;

import parser.CompiladorHell;
import semantico.Simbolo;
import semantico.Tipo;
import intermediario2.*;


public class RepetirAte extends Comando{
	private Expressao expressaoVerdadeira;
	private ListaComandos listaComandos;
	
	public RepetirAte() { 
		this.expressaoVerdadeira = null;
		this.listaComandos = null;        
	}
	
	public RepetirAte(Expressao _expressaoVerdadeira, ListaComandos _listaComandos) { 
        this.expressaoVerdadeira = _expressaoVerdadeira;
        this.listaComandos = _listaComandos;
        
	}

	@Override
	public String toString() {
		return "\n\n" + 
				"- expressao verdadeira = " + this.expressaoVerdadeira + 
				"\n- lista de comandos do RepeteAte = " + this.listaComandos;
	}

	public Expressao getExpressaoVerdadeira() {
		return expressaoVerdadeira;
	}

	public void setExpressaoVerdadeira(Expressao expressaoVerdadeira) {
		this.expressaoVerdadeira = expressaoVerdadeira;
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
		
		lista.add(labelInicio);
		for(Comando c: listaComandos.comandos){
			lista.adicionaTodos(c.geraCodigoPrimitivo());
		}
		lista.add(new PrimitivoSeGoto(this.expressaoVerdadeira, labelFim));
		lista.add(new PrimitivoGoto(labelInicio));
		lista.add(labelFim);
		
		
		return lista;
	}



}
