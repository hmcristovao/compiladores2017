package intermediario2;

	public class PrimitivoLabel  extends PrimitivoComando {
		static int contador = 0;
		private String label;

		public String geraCodigoDestino() {
			return this.label;
		}

		public PrimitivoLabel(String label) {
			super();
			PrimitivoLabel.contador++;
			this.label = label + "_"+ PrimitivoLabel.contador;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String toString() {
			return "\n\nPrimitivoComando PrimitivoLabel: " + this.label;
		}
}
