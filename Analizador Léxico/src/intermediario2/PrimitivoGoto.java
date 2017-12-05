package intermediario2;

public class PrimitivoGoto  extends PrimitivoComando {
	private PrimitivoLabel label;
	
	// ...
	
	
	public PrimitivoLabel getLabel() {
		return label;
	}

	public void setLabel(PrimitivoLabel label) {
		this.label = label;
	}

	
	public String geraCodigoDestino() {
		// gerar o código destino em assembler (JVM do Java - ver material no AVA)
		String codigoFinal = null;
		
		return codigoFinal= "goto "+ getLabel();
	}
	
	public String toString() {
		// retornar a concatenação dos atributos da classe, usando toString() para cada um
		return "Foi para o endereço " + getLabel();
	}
}

