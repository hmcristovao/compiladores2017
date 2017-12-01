package intermediario;

import intermediario2.PrimitivoListaComandos;

import java.util.LinkedList;

// erro: nao esta armazenando a lista de comandos aqui e nem na classe BlocoLacoMultiplo

public class LacoMultiplo extends Comando{
	private LinkedList<BlocoLacoMultiplo> bloco;
	private int contador;
	
	public LacoMultiplo(){
		this.bloco = new LinkedList<BlocoLacoMultiplo>();
		this.contador  = 0;
	}
	public void incluiBloco(BlocoLacoMultiplo novoBloco){
		this.bloco.addLast(novoBloco);
	}
	public void addFaixa (Expressao _expFrom,Expressao _expTo,Expressao _expStep){
		this.bloco.get(contador).addFaixa(_expFrom, _expTo, _expStep);
		this.contador++;
	}


	public String toString() {
		return "\n\nComando Laco Multiplo, lista de blocos = " + this.bloco + 
				", contador = " + this.contador;
	}


	public PrimitivoListaComandos geraCodigoPrimitivo() {  
		/* falta implementar ... */  
		return null;
	}

	

}