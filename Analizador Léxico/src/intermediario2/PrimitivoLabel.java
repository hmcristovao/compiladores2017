package intermediario2;

	public class PrimitivoLabel  extends PrimitivoComando {
		static int contador = 0;
		private String label;

		public PrimitivoLabel(String _label) {
			super();
			PrimitivoLabel.contador++;
			this.label = _label + "_"+ PrimitivoLabel.contador;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
		
		public String geraCodigoDestino() {
			// gerar o código destino em assembler (JVM do Java - ver material no AVA)
		    return this.label + ": \r\n";
		}

		public String toString() {
			return "\n\nComando primitivo LABEL: " + this.label;
		}
}
