package intermediario2;

public class PrimitivoGoto  extends PrimitivoComando {
	private PrimitivoLabel label;
	
	// ...
	public PrimitivoGoto(PrimitivoLabel label) {
		super();
		this.label = label;
	}
	public PrimitivoGoto() {
		
	}
	
	public PrimitivoLabel getLabel() {
		return label;
	}

	public void setLabel(PrimitivoLabel label) {
		this.label = label;
	}

	
	public String geraCodigoDestino() {
		// gerar o c�digo destino em assembler (JVM do Java - ver material no AVA)
	    return "goto " + label.getLabel() + "\r\n";
	}
	
	public String toString() {
		// retornar a concatena��o dos atributos da classe, usando toString() para cada um
		return "\n\nComando primitivo GOTO: label: " + label.toString();
	}

}

