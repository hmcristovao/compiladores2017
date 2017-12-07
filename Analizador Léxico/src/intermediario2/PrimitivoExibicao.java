package intermediario2;

import intermediario.*;
import semantico.Tipo;

public class PrimitivoExibicao extends PrimitivoComando {
	private Expressao expressao;

	public PrimitivoExibicao(Expressao expressao) {
		this.expressao = expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}

	public String geraCodigoDestino() {
		String codigoFinal = "";

		codigoFinal += "getstatic java/lang/System/out Ljava/io/PrintStream; \r\n";
		codigoFinal += this.expressao.geraCodigoDestino();
		if(this.expressao.isString())
			codigoFinal += "invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V \r\n";
		else
			codigoFinal += "invokevirtual java/io/PrintStream/println(D)V \r\n";

		return codigoFinal;
	}

	public String toString() {
		// retornar a concatenação dos atributos da classe, usando toString() para cada
		// um
		return "\n\nComando primitivo EXIBICAO: " + this.expressao.toString();
	}
}
