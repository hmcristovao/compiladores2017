package intermediario;

import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

// erro: nao esta armazenando a lista de comandos aqui e nem na classe BlocoLacoMultiplo

public class LacoMultiplo extends Comando{
	private LinkedList<BlocoLacoMultiplo> bloco;
	private int contador;
	private ListaComandos listaComandos;
	
	public LacoMultiplo(){
		this.bloco = new LinkedList<BlocoLacoMultiplo>();
		this.contador  = 0;
		this.listaComandos = new ListaComandos();
	}
	public void incluiBloco(BlocoLacoMultiplo novoBloco){
		this.bloco.addLast(novoBloco);
	}
	public void addFaixa (Expressao _expFrom,Expressao _expTo,Expressao _expStep){
		this.bloco.get(contador).addFaixa(_expFrom, _expTo, _expStep);
		this.contador++;
	}
	public ListaComandos getListaComandos() {
		return listaComandos;
	}
	public void setListaComandos(ListaComandos listaComandos) {
		this.listaComandos = listaComandos;
	}
	public String toString() {
		return "\n\nComando Laco Multiplo: lista de blocos = " + this.bloco + 
				"- contador = " + this.contador + this.listaComandos;
	}


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		PrimitivoListaComandos lista = new PrimitivoListaComandos();
		/* falta implementar ... */  
		return lista;
	}

	

}