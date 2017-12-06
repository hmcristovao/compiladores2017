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
	private int maxPilha = 0 ;
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
	
	public String toString() {
		return "expressao infixa: "+this.listaInfixo + " - expressao posfixa: " + this.listaPosfixo;
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
		for(Item item : this.getListaPosfixo()){
			if(item.getTipo() == Tipo.CTE_NUMERO){
				if(item.getValor().contains(".")){
					codigoExpressao += "ldc2_w " + item.getValor() + "\r\n";
				} else {
					codigoExpressao += "ldc2_w " + item.getValor() + ".0\r\n";
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

					codigoExpressao+="dcmpg\r\n";
					//Caso os numeros sejam iguais faz um desvio para o LABEL
					//e armazena 1 na pilha.
					codigoExpressao+="ifeq LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+= ("LABEL_0"+contLabel + ":\r\n");
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel+=2;

				}
				
				else if(item.getValor().equals("<=")){
					codigoExpressao+="dcmpg\r\n";
					//Caso o primeiro numero seja menor ou igual, armazena 1 na pilha.
					codigoExpressao+="ifgt LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+="LABEL_0"+contLabel + ":\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
			}
			else if(item.getTipo() == Tipo.CTE_STRING){
				codigoExpressao += "ldc " + item.getValor() + "\r\n";
			}
			else if(item.getTipo() == Tipo.VAR_BOOLEANO || item.getTipo() == Tipo.VAR_STRING || item.getTipo() == Tipo.VAR_NUMERO){
				String nomeDaVariavel = item.getValor();
				int referenciaDaVariavel = CompiladorHell.tabela.consultaReferencia(nomeDaVariavel);
                if( referenciaDaVariavel < 4 ){
                	codigoExpressao += "dload_" + referenciaDaVariavel + "\r\n";
                }
                else{
                	codigoExpressao += "dload " + referenciaDaVariavel + "\r\n";
                }
			}
		}
		return codigoExpressao + "\r\n";
	}

}