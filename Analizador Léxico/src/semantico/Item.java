package semantico;

public class Item {
	private Tipo tipo;
	private String valor;
	
	public Item(Tipo _tipo, String _valor){
		this.tipo = _tipo;
		this.valor = _valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
