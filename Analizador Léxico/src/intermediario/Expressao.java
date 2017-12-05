package intermediario;

import java.util.*;

import parser.CompiladorHell;
import semantico.*;

public class Expressao 
{
	// atributos tais como: lista de itens, linha, expressao infixa etc
	private LinkedList <Item> listaInfixo;
	private LinkedList <Item> listaPosfixo;
	private static final long serialVersionUID = 1L;
	private LinkedList <Item> listaExpressao;
	private int linha;
	private int tamPilha;
	private static int maxPilha;
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
	
	public LinkedList<Item> getListaExpressao() {
		return listaExpressao;
	}

	public void setListaExpressao(LinkedList<Item> listaExpressao) {
		this.listaExpressao = listaExpressao;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getTamPilha() {
		return tamPilha;
	}

	public void setTamPilha(int tamPilha) {
		this.tamPilha = tamPilha;
	}

	public static int getMaxPilha() {
		return maxPilha;
	}

	public static void setMaxPilha(int maxPilha) {
		Expressao.maxPilha = maxPilha;
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
	
	public String geraCodigoDestino() {

		String codigoExpressao="\r\n; expressao: " + this.getListaInfixo() + "\r\n";
		for(Item item : this.listaExpressao){
			if(item.getTipo() == Tipo.CTE_NUMERO){
				if(item.getValor().contains(".")){
					codigoExpressao += "ldc2_w " + item.getValor() + "\r\n";
				} else {
					codigoExpressao += "ldc2_w " + item.getValor() + ".0\r\n";
				}
			}

			else if(item.getTipo() == Tipo.OPERADOR){
				if((item.getValor().equals("+"))){
					if((this.getTipoDados() == Tipo.CTE_NUMERO)){
						codigoExpressao+="dadd\r\n";
					} else if(this.getTipoDados() == Tipo.CTE_STRING){

						codigoExpressao += "astore_"+(Simbolo.getReferencia()+1) +" \r\n";
						codigoExpressao += "astore_"+(Simbolo.getMarcador()) +" \r\n";
						codigoExpressao += "new java/lang/StringBuilder \r\n";
						codigoExpressao += "dup \r\n";
						codigoExpressao += "invokespecial java/lang/StringBuilder/<init>()V \r\n";
						codigoExpressao += "aload_"+(Simbolo.getMarcador()) +" \r\n";
						codigoExpressao += "invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder \r\n";
						codigoExpressao += "aload_"+(Simbolo.getMarcador()+1) +" \r\n";
						codigoExpressao += "invokevirtual java/lang/StringBuilder/append(Ljava/lang/String;)Ljava/lang/StringBuilder \r\n";
						codigoExpressao += "invokevirtual java/lang/StringBuilder/toString()Ljava/lang/String \r\n";

					}
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
				else if(item.getValor().equals("^")){
					codigoExpressao+="invokestatic    java/lang/Math.pow(DD)D\r\n";
				}
				else if(item.getValor().equals("e")){
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "dcmpg\r\n";
					// Verifico se o topo é igual à 1 (ou -1)
					codigoExpressao += "ifne topoUm_"+contAnd+"\r\n";

					// Se o topo da pilha for zero, logo o resultado será sempre 0, já que
					// 0 * (0 | 1) é sempre zero. Retiramos então o topo da pilha, empilhamos 0
					// e partimos para a label final.
					codigoExpressao += "pop2\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "goto final_"+contAnd+"\r\n";

					// Caso o topo seja igual à 1, entra aqui. Empilho 1 e comparo o topo com o
					// próximo, a fim de verificar se são iguais ou não.
					codigoExpressao += "topoUm_"+contAnd+":\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "dcmpg\r\n";
					// Caso seja igual à um, a resposta será um e desvia para a label 1. Senão, a operação
					// de and irá dar zero, portanto empilharemos 0.
					codigoExpressao += "ifne um_"+contAnd+"\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "goto final_"+contAnd+"\r\n";
					// Agora, tendo desempilhado 1, segue para a label 'um' e o empilhamos 1, já que 1x1 == 1.
					codigoExpressao += "um_"+contAnd+":\r\n";
					codigoExpressao += "dconst_1\r\n";
					codigoExpressao += "final_"+contAnd+":\r\n";
					contAnd++;
				}
				else if(item.getValor().equals("AND2")){
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "dcmpg\r\n";
					codigoExpressao += "ifne areaDoUm_"+contAnd2+"\r\n";
					
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "dcmpg\r\n";
					codigoExpressao += "ifne desvioinutil_"+contAnd2+"\r\n";
					
					codigoExpressao += "desvioinutil_"+contAnd2+":\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "goto finalAnd2_"+contAnd2+"\r\n";

					codigoExpressao += "areaDoUm_"+contAnd2+":\r\n";
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "dcmpg\r\n";
					codigoExpressao += "ifne verdadeiro_"+contAnd2+"\r\n";
					
					codigoExpressao += "dconst_0\r\n";
					codigoExpressao += "goto finalAnd2_"+contAnd2+"\r\n";
					
					codigoExpressao += "verdadeiro_"+contAnd2+":\r\n";
					codigoExpressao += "dconst_1\r\n";
					
					codigoExpressao += "finalAnd2_"+contAnd2+":\r\n";
					contAnd2++;
					
				}
				else if(item.getValor().equals("ou")){
					//É necessário empilhar zero para utilizar o dcmpg e testar se o topo é zero
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="dcmpg\r\n";
					//verifica se o topo é igual a 0
					codigoExpressao+="ifeq topoZero_"+contOr+"\r\n";

					//Entra aqui se o topo for 1. 1 ou qualquer coisa = 1
					//retira o topo da pilha
					codigoExpressao+="pop2\r\n";
					//empilha 1
					codigoExpressao+="dconst_1\r\n";
					//vai para o label final
					codigoExpressao+="goto finalOu_"+contOr+"\r\n";

					//Entra aqui se o topo for 0. O resultado de ifeq tem que empilhar 0
					codigoExpressao+="topoZero_"+contOr+":\r\n";
					//empilha zero para poder utilizar o dcmpg
					codigoExpressao+="dconst_0\r\n";
					//compara o topo e o proximo
					codigoExpressao+="dcmpg\r\n";
					//ser for zero vai pro label zero
					codigoExpressao+="ifeq zero_"+contOr+"\r\n";
					//entra aqui se o resultado nao for zero. empilha 1 pois 0 ou 1 = 1
					codigoExpressao+="dconst_1\r\n";
					//vai pro final
					codigoExpressao+="goto finalOu_"+contOr+"\r\n";
					//label zero
					codigoExpressao+="zero_"+contOr+":\r\n";
					//empilha 0 pois 0 ou 0 = 0
					codigoExpressao+="dconst_0\r\n";

					//label final
					codigoExpressao+="finalOu_"+contOr+":\r\n";
					contOr++;
				}
				else if(item.getValor().equals("nao")){
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="dcmpg\r\n";
					codigoExpressao+="ifeq LABEL_0"+contLabel+ "\r\n";
					//se for diferente de zero a reposta é zero
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1)+ "\r\n";
					//se for igual a zero a resposta é 1
					codigoExpressao+="LABEL_0"+contLabel+ ":\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1)+":\r\n";
					contLabel+=2;
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
				else if(item.getValor().equals("!=")){
					codigoExpressao+="dcmpg\r\n";
					//Caso os numeros sejam diferentes armazena 1 na pilha.
					codigoExpressao+="ifeq LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+= ("LABEL_0"+contLabel + ":\r\n");
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel+=2;

				}
				else if(item.getValor().equals(">")){
					codigoExpressao+="dcmpg\r\n"; //True: Push 1; False: Push 0 or -1;
					//Caso o primeiro numero seja maior, armazena 1 na pilha.
					codigoExpressao+="ifgt LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+="LABEL_0"+contLabel+ ":\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
				else if(item.getValor().equals(">=")){
					codigoExpressao+="dcmpg\r\n"; //True: Push 1 or 0; False: Push -1;
					//Caso o primeiro numero seja maior ou igual, armazena 1 na pilha.
					codigoExpressao+="ifge LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+="LABEL_0"+contLabel+ ":\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
				}
				else if(item.getValor().equals("<")){
					codigoExpressao+="dcmpg\r\n";
					//Caso o primeiro numero seja menor, armazena 1 na pilha.
					codigoExpressao+="ifge LABEL_0"+contLabel+ "\r\n";
					codigoExpressao+="dconst_1\r\n";
					codigoExpressao+="goto LABEL_0"+(contLabel+1) +"\r\n";
					codigoExpressao+="LABEL_0"+contLabel + ":\r\n";
					codigoExpressao+="dconst_0\r\n";
					codigoExpressao+="LABEL_0"+(contLabel+1) + ":\r\n";
					contLabel += 2;
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
				
				//questao 3 p2
				else if(item.getValor().equals("R")){
					codigoExpressao+="invokestatic java/lang/Math.sqrt(D)D\r\n";
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