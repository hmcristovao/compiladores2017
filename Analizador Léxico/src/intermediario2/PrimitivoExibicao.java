package intermediario2;

import intermediario.*;

public class PrimitivoExibicao extends PrimitivoComando {
	private Expressao expressao;

	public PrimitivoExibicao(Expressao expressao) {
		this.expressao = expressao;
	}

	public void setExpressao(Expressao expressao) {
		this.expressao = expressao;
	}

	public String geraCodigoDestino() {
		String codigoFinal = null;

		codigoFinal = this.expressao.geraCodigoDestino();
		codigoFinal += "getstatic java/lang/System/out Ljava/io/PrintStream; \r\n";
		codigoFinal += "dload_1 \r\n";
		codigoFinal += "invokevirtual java/io/PrintStream/println(D)V \r\n";

		return codigoFinal;
	}

	public String toString() {
		// retornar a concatenação dos atributos da classe, usando toString() para cada
		// um
		return "";
	}
}
