package intermediario;
import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

public class ComandoPrinta extends Comando {
	private LinkedList<Expressao> expressao;
	
	public ComandoPrinta(Expressao expressao){
		this.expressao = new LinkedList<Expressao>();
		this.expressao.add(expressao);
	}

	public void addExpressao(Expressao expressao) {
		this.expressao.add(expressao);
	}
	
	public LinkedList<Expressao> getExpressao() {
		return expressao;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Expressoes: ");
		for (Expressao exp : this.expressao) {
			str.append(exp.toString());
			if(!exp.equals(this.expressao.getLast()))
				str.append(", ");
		}
		return str.toString();
	}	


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		/* falta implementar ... */  
		return null;
	}

	
}