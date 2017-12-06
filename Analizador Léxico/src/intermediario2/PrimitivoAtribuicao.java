package intermediario2;

import semantico.*;
import intermediario.*;

public class PrimitivoAtribuicao extends PrimitivoComando {
	private Simbolo variavel;
	private Expressao expressao;
	
	public PrimitivoAtribuicao(Simbolo variavel, Expressao expressao){
		this.variavel = variavel;
		this.expressao = expressao;
	}
	
	public String geraCodigoDestino() {
		// gerar o codigo destino em assembler (JVM do Java - ver material no AVA)
		String codigoFinal = "";
		codigoFinal += expressao.geraCodigoDestino();
		codigoFinal += "dstore " + variavel.getReferencia() + "\r\n";
		return codigoFinal;
	}
	
	public String toString() {
		return "\nComando Atribuicao: variavel que recebe: "+this.variavel.toString() + " - expressao: " + this.expressao.toString();
	}
}
