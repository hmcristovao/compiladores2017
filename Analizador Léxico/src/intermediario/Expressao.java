package intermediario;

import java.util.*;

import parser.CompiladorHell;
import semantico.*;

public class Expressao 
{
	// atributos tais como: lista de itens, expressao infixa etc
	private LinkedList <Item> listaInfixo;
	private LinkedList <Item> listaPosfixo;
	private static final long serialVersionUID = 1L;
	private int maxPilha = 3 ;
	static private int maxPilhaGeral = 0;
	private Tipo tipoDados;
	private static Integer contLabel = 0;
	private static Integer contAnd = 1;
	private static Integer contAnd2 = 1;
	private static Integer contOr = 1;

	//construtor da classe inicializando duas listas
	public Expressao() {
		listaInfixo = new LinkedList<Item>();
		listaPosfixo = new LinkedList<Item>();
	}

	public int getMaxPilha() {
		return this.maxPilha;
	}

	public void setMaxPilha(int maxPilha) {
		this.maxPilha = maxPilha;
	}

	public static int getMaxPilhaGeral() {
		return maxPilhaGeral;
	}

	public static void setMaxPilhaGeral(int maxPilhaGeral) {
		Expressao.maxPilhaGeral = maxPilhaGeral;
	}

	public Tipo getTipoDados() {
		return tipoDados;
	}

	public void setTipoDados(Tipo tipoDados) {
		this.tipoDados = tipoDados;
	}

	public static Integer getContLabel() {
		return contLabel;
	}

	public static void setContLabel(Integer contLabel) {
		Expressao.contLabel = contLabel;
	}

	public static Integer getContAnd() {
		return contAnd;
	}

	public static void setContAnd(Integer contAnd) {
		Expressao.contAnd = contAnd;
	}

	public static Integer getContAnd2() {
		return contAnd2;
	}

	public static void setContAnd2(Integer contAnd2) {
		Expressao.contAnd2 = contAnd2;
	}

	public static Integer getContOr() {
		return contOr;
	}

	public static void setContOr(Integer contOr) {
		Expressao.contOr = contOr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setListaInfixo(LinkedList<Item> listaInfixo) {
		this.listaInfixo = listaInfixo;
	}

	public void setListaPosfixo(LinkedList<Item> listaPosfixo) {
		this.listaPosfixo = listaPosfixo;
	}

	public LinkedList<Item> getListaInfixo() {
		return listaInfixo;
	}

	public LinkedList<Item> getListaPosfixo() {
		return listaPosfixo;
	}

	public void addInfixo(Item _item){
		listaInfixo.add(_item);
	}	
	public void addPosfixo(Item _item){
		listaPosfixo.add(_item);
	}

	public String strExpInfixa() {
		String saida = "";
		for(Item item : this.listaInfixo)
		   saida += item.getValor();	
		return saida;
	}
	
	public String toString() {
		return "expressao infixa: "+this.strExpInfixa() + "  - expressao posfixa: " + this.listaPosfixo;
	}	

	// pega apenas o tipo do primeiro operando
	public Tipo getTipo() {
		return this.getListaInfixo().get(0).getTipo();
	}

	// verifica se o primeiro operando eh string
	public boolean isString() {
		if(this.getTipo() == Tipo.VAR_STRING || this.getTipo() == Tipo.CTE_STRING ) 
			return true;
		else
			return false;
	}

	public void calculaLimitStack() {
		for(Item item : this.listaPosfixo) {
			if(item.getTipo() == Tipo.OPERADOR)
				this.maxPilha--;
			else {
				this.maxPilha++;
				if(this.maxPilha > Expressao.maxPilhaGeral)
					Expressao.maxPilhaGeral = this.maxPilha;
			}
		}
	}

	public String geraCodigoDestino() {
		String codigoExpressao="\r\n; " + this.toString() + "\r\n";
		String nomeDaVariavel;
		int referenciaDaVariavel;
		for(Item item : this.getListaPosfixo()){
			if(item.getTipo() == Tipo.CTE_NUMERO){
				if(item.getValor().contains(".")){
					codigoExpressao += "ldc2_w " + item.getValor() + "\r\n";
				} else {
					codigoExpressao += "ldc2_w " + item.getValor() + ".0\r\n";
				}
			}
			if(item.getTipo() == Tipo.CTE_BOOLEANO){
				if(item.getValor().equals("true"))
					codigoExpressao += "ldc2_w 1.0 \r\n";
				else 
					codigoExpressao += "ldc2_w 0.0 \r\n";
			}
			else if(item.getTipo() == Tipo.CTE_STRING){
				codigoExpressao += "ldc " + item.getValor() + "\r\n";
			}
			else if(item.getTipo() == Tipo.VAR_BOOLEANO || item.getTipo() == Tipo.VAR_NUMERO){
				nomeDaVariavel = item.getValor();
				referenciaDaVariavel = CompiladorHell.tabela.consultaReferencia(nomeDaVariavel);
				if( referenciaDaVariavel < 4 ){
					codigoExpressao += "dload_" + referenciaDaVariavel + "\r\n";
				}
				else {
					codigoExpressao += "dload " + referenciaDaVariavel + "\r\n";
				}
			}
			else if(item.getTipo() == Tipo.VAR_STRING){
				nomeDaVariavel = item.getValor();
				referenciaDaVariavel = CompiladorHell.tabela.consultaReferencia(nomeDaVariavel);
				if( referenciaDaVariavel < 4 ){
					codigoExpressao += "aload_" + referenciaDaVariavel + "\r\n";
				}
				else {
					codigoExpressao += "aload " + referenciaDaVariavel + "\r\n";
				}
			}
			else if(item.getTipo() == Tipo.OPERADOR){
				if((item.getValor().equals("+"))){
					codigoExpressao+="dadd\r\n";
				}
				else if(item.getValor().equals("-")){
					codigoExpressao+="dsub\r\n";
				}
				else if(item.getValor().equals("*")){
					codigoExpressao+="dmul\r\n";
				}
				else if(item.getValor().equals("/")){
					codigoExpressao+="ddiv\r\n";
				}

				else if(item.getValor().equals("==")){

					codigoExpressao+="dcmpg \r\n";
					//Caso os numeros sejam iguais faz um desvio para o LABEL
					//e armazena 1 na pilha.
					codigoExpressao+="ifeq LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_0 \r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+= ("LABEL_0"+contLabel + ":\r\n");
					codigoExpressao+="dconst_1 \r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel+=2;

				}

				else if(item.getValor().equals("<=")){
					codigoExpressao+="dcmpg \r\n";
					//Caso o primeiro numero seja menor ou igual, armazena 1 na pilha.
					codigoExpressao+="ifgt LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1 \r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+="LABEL_0"+contLabel + ": \r\n";
					codigoExpressao+="dconst_0 \r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ": \r\n";
					contLabel += 2;
				}
			}
		}
		return codigoExpressao + "\r\n";
	}
	
	// 0 2 + -> 2
	//posNeutro = 0;
	//i = 2
	public void otimizaNeutroSomaSubExpressao(){
		int posNeutro = 0;
		int numOps = 0;
		int i = 0;
		
		// Mantem o laço enquanto encontrar algum elemento 0
		while(posNeutro != -1){
			posNeutro = -1;
			// Percorre a lista e resolve o primeiro elemento 0 que encontrar
			for(Item item : this.listaPosfixo) {
				//System.out.print(item.getValor() + " ");
				if (item.getTipo() == Tipo.CTE_NUMERO){
					if (item.getValor().equals("0")){
						posNeutro = i;
					}
				}
				else if (item.getTipo() == Tipo.OPERADOR){
					numOps++;
					if ((item.getValor().equals("+") || item.getValor().equals("-")) && posNeutro != -1){
						// verifica se é uma sub-expressao de 3 termos
						if ((i - posNeutro) <= 2){
							this.listaPosfixo.remove(posNeutro);
							this.listaPosfixo.remove(--i);
							numOps--;
							break;
						}
						// caso a sub-expressao tenha mais de 3 termos
						else if (this.listaPosfixo.get(i - numOps*2).getValor().equals("0") || this.listaPosfixo.get(i - 1).getValor().equals("0")){
							this.listaPosfixo.remove(posNeutro);
							this.listaPosfixo.remove(--i);
							numOps--;
							break;
						}
					}
				}
				i++;
			}
			i = 0;
			numOps = 0;
			//System.out.println();
		}
		
	}
	
}