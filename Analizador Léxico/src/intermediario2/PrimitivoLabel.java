package intermediario2;

public class PrimitivoLabel  extends PrimitivoComando {
	private String label;
	
	// ...
	
	public PrimitivoLabel(String label){
		this.label = label;
	}
	
	public String geraCodigoDestino() {
		// gerar o código destino em assembler (JVM do Java - ver material no AVA)
		String codigoFinal = null;
		// ...
		return codigoFinal;
	}
	
	public String toString() {
		// retornar a concatenação dos atributos da classe, usando toString() para cada um
		return "";
	}
}
