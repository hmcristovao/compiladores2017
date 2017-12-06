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
		// gerar o código destino em assembler (JVM do Java - ver material no AVA)
		String codigoFinal = null;
		
		codigoFinal += expressao.geraCodigoDestino();
		codigoFinal += "dstore " + variavel.getReferencia() + "\r\n";
		
		return codigoFinal;
	}
	
	public String toString() {
		// retornar a concatenação dos atributos da classe, usando toString() para cada um
		return this.variavel.toString() + " = " + this.expressao.toString();
	}
}
