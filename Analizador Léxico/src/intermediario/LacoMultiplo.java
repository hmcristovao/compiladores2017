package intermediario;

import java.util.LinkedList;

public class LacoMultiplo extends Comando{
	private LinkedList<BlocoLacoMultiplo> bloco;
	
	public LacoMultiplo(){
		this.bloco = new LinkedList<BlocoLacoMultiplo>();
	}
	public void inclui(BlocoLacoMultiplo novoBloco){
		this.bloco.addLast(novoBloco);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}