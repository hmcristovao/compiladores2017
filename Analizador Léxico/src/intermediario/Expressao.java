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

	public void otimizaRelacionalIgual(){
		if(this.listaPosfixo.size() >= 3){
			for(int i = 0; i < this.listaPosfixo.size(); i++){
				if(this.listaPosfixo.get(i).getTipo() == Tipo.CTE_NUMERO){
					if(this.listaPosfixo.get(i + 1).getTipo() == Tipo.CTE_NUMERO){
						if(this.listaPosfixo.get(i + 2).getTipo() == Tipo.OPERADOR
								&& this.listaPosfixo.get(i + 2).getValor().equals("==")){
							float n1 = Float.parseFloat(this.listaPosfixo.get(i).getValor());
							float n2 = Float.parseFloat(this.listaPosfixo.get(i + 1).getValor());
							
							this.listaPosfixo.remove(i + 1);
							this.listaPosfixo.remove(i + 1);
							String exp = "true";
							if(n1 != n2){
								exp = "false";
							}
	
							Item novoItem = new Item(Tipo.CTE_BOOLEANO, exp);
							this.listaPosfixo.set(i, novoItem);
							
						}
					}
				}
			}
		}
	}
	
	public void otimizaConstantes(){
		//percorrendo a lista de posfixo otimizando as constantes
		int qtdSaltos = 0;
		if(this.listaPosfixo.size() >= 3){
			for(int i = 0; i < this.listaPosfixo.size(); i++){
				if(this.listaPosfixo.get(i).getTipo() == Tipo.CTE_NUMERO){
					qtdSaltos++;
					if(this.listaPosfixo.get(i + 1).getTipo() == Tipo.CTE_NUMERO){
						if(this.listaPosfixo.get(i + 2).getTipo() == Tipo.OPERADOR){
							
							if(this.listaPosfixo.get(i + 2).getValor().equals("+") ||
								this.listaPosfixo.get(i + 2).getValor().equals("-")){
								
								
								float termo1 = Float.parseFloat(this.listaPosfixo.get(i).getValor());
								float termo2 = Float.parseFloat(this.listaPosfixo.get(i + 1).getValor());
								if(this.listaPosfixo.get(i + 2).getValor().equals("-")){
									termo2 *= -1;
								}
								termo1 += termo2;
								
								Item novoItem = new Item(Tipo.CTE_NUMERO, String.valueOf(termo1));
								this.listaPosfixo.set(i, novoItem);
								
								this.listaPosfixo.remove(i + 1);
								this.listaPosfixo.remove(i + 1);
								i = (qtdSaltos - 1);
								qtdSaltos = 0;
							}
						}
					}else{
						qtdSaltos = 0;
					}
				}
			}
		}	
	}
}