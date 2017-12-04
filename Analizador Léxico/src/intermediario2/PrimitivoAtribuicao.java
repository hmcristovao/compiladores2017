package intermediario2;

import parser.CompiladorHell;
import semantico.*;
import intermediario.*;

public class PrimitivoAtribuicao extends PrimitivoComando {
	private Simbolo variavel;
	private Expressao expressao;
	
	// ...
	
	public PrimitivoAtribuicao(Simbolo simbolo, Expressao expressao){ 
		this.variavel = variavel;
		this.expressao = expressao;
	}
	
	public String geraCodigoDestino() {
		// gerar o c�digo destino em assembler (JVM do Java - ver material no AVA)
		String codigoFinal = null;
		
		codigoFinal += "dstore " + variavel.getReferencia() + "\r\n";
		// ...
		return codigoFinal;
	}
	
	public String toString() {
		// retornar a concatena��o dos atributos da classe, usando toString() para cada um
		return variavel.toString() + ", " + expressao.toString();
	}
}
