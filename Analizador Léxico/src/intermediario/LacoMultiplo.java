package intermediario;

import java.util.LinkedList;

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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		for(BlocoLacoMultiplo alvo:bloco){	
			alvo.toString();	
		}
		
		return null;
	}
}