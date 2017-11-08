/* Generated By:JavaCC: Do not edit this line. CompiladorHell.java */
package parser;

import java.io.*;

import semantica.*;
import apoio.*;

public class CompiladorHell implements CompiladorHellConstants {
	public static Tabela tabela = new Tabela();
	public static void main(String args[]) throws ParseException {
		CompiladorHell analisador = null;
		try {
			analisador = new CompiladorHell(new FileInputStream(Config.nomeArquivoFonte));
			CompiladorHell.inicio();
			System.out.println(tabela.toString());
			System.out.println("Analise lexica e sintatica sem erros!");
		}
		catch(FileNotFoundException e) {
			System.out.println("Erro: arquivo nao encontrado");
		}
		catch(TokenMgrError e) {
			System.out.println("Erro lexico\u005cn" + e.getMessage());
		}
		catch(ParseException e) {
			System.out.println("Erro sintatico\u005cn" + e.getMessage());
		}
	}

	/*
inicio        -> listaComandos() <EOF>
listaComandos -> (comando())* 
comando       -> 
	|comandoDeclaracoVariavel()
	|comandoAtribuicao()
	|comandoEntrada()
	|comandoPrinta()
	|comandoSe()
	|comandoTeste()
	|comandoLaco()
	|comandoLacoMultiplo()
	|comandoLacoMatrix()
	 */
	static final public void inicio() throws ParseException {
		listaComandos();
		jj_consume_token(0);
	}

	static final public void listaComandos() throws ParseException {
		label_1:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case IF:
				case FOR:
				case IN:
				case OUT:
				case TEST:
				case FORMULTIPLE:
				case FORMATRIX:
				case TYPENUM:
				case TYPESTR:
				case TYPEBOOL:
				case VAR:
					;
					break;
				default:
					jj_la1[0] = jj_gen;
					break label_1;
				}
				comando();
			}
	}

	static final public void comando() throws ParseException {
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case TYPENUM:
		case TYPESTR:
		case TYPEBOOL:
			comandoDeclaracaoVariavel();
			break;
		case VAR:
			comandoAtribuicao();
			break;
		case OUT:
			comandoPrinta();
			break;
		case IN:
			comandoPega();
			break;
		case IF:
			comandoSe();
			break;
		case TEST:
			comandoTeste();
			break;
		case FOR:
			comandoLaco();
			break;
		case FORMULTIPLE:
			comandoLacoMultiplo();
			break;
		case FORMATRIX:
			comandoLacoMatrix();
			break;
		default:
			jj_la1[1] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
	}

	/*
comandoDeclaracaoVariavel ->
    (
      <TYPENUM> <VAR> (<ATRIB> <NUM>)?
     ( <VIRG> <VAR> (<ATRIB> <NUM>)? )*
    | 
    <TYPESTR> <VAR> (<ATRIB> <STRING>)?
     ( <VIRG> <VAR> (<ATRIB> <STRING>)? )*
    | 
    <TYPEBOOL> <VAR> (<ATRIB> <BOOL>)?
     ( <VIRG>  <VAR> (<ATRIB> <BOOL>)? )*
    )
    <COMENT>	
	 */
	static final public void comandoDeclaracaoVariavel() throws ParseException {
		Simbolo simb; Token t;
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case TYPENUM:
			jj_consume_token(TYPENUM);
			t = jj_consume_token(VAR);
			simb = new Simbolo(t.image);
			tabela.inclui(simb);
			switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
			case ATRIB:
				jj_consume_token(ATRIB);
				t = jj_consume_token(NUM);

				break;
			default:
				jj_la1[2] = jj_gen;
				;
			}
			label_2:
				while (true) {
					switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
					case VIRG:
						;
						break;
					default:
						jj_la1[3] = jj_gen;
						break label_2;
					}
					jj_consume_token(VIRG);
					t = jj_consume_token(VAR);
					simb = new Simbolo(t.image);
					tabela.inclui(simb);
					switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
					case ATRIB:
						jj_consume_token(ATRIB);
						t = jj_consume_token(NUM);

						break;
					default:
						jj_la1[4] = jj_gen;
						;
					}
				}
			break;
		case TYPESTR:
			jj_consume_token(TYPESTR);
			t = jj_consume_token(VAR);
			simb = new Simbolo(t.image);
			tabela.inclui(simb);
			switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
			case ATRIB:
				jj_consume_token(ATRIB);
				t = jj_consume_token(STRING);

				break;
			default:
				jj_la1[5] = jj_gen;
				;
			}
			label_3:
				while (true) {
					switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
					case VIRG:
						;
						break;
					default:
						jj_la1[6] = jj_gen;
						break label_3;
					}
					jj_consume_token(VIRG);
					t = jj_consume_token(VAR);
					simb = new Simbolo(t.image);
					tabela.inclui(simb);
					switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
					case ATRIB:
						jj_consume_token(ATRIB);
						t = jj_consume_token(STRING);

						break;
					default:
						jj_la1[7] = jj_gen;
						;
					}
				}
			break;
		case TYPEBOOL:
			jj_consume_token(TYPEBOOL);
			t = jj_consume_token(VAR);
			simb = new Simbolo(t.image);
			tabela.inclui(simb);
			switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
			case ATRIB:
				jj_consume_token(ATRIB);
				t = jj_consume_token(BOOL);

				break;
			default:
				jj_la1[8] = jj_gen;
				;
			}
			label_4:
				while (true) {
					switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
					case VIRG:
						;
						break;
					default:
						jj_la1[9] = jj_gen;
						break label_4;
					}
					jj_consume_token(VIRG);
					t = jj_consume_token(VAR);
					simb = new Simbolo(t.image);
					tabela.inclui(simb);
					switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
					case ATRIB:
						jj_consume_token(ATRIB);
						t = jj_consume_token(BOOL);

						break;
					default:
						jj_la1[10] = jj_gen;
						;
					}
				}
			break;
		default:
			jj_la1[11] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		jj_consume_token(COMENT);
	}

	/*
comandoAtribui��o ->  <VAR><ATRIB> exp <COMENT>
exp               ->  expLogica | expAritmetica | expString
	 */
	static final public void comandoAtribuicao() throws ParseException {
		Simbolo simb; Token t;
		t = jj_consume_token(VAR);
		simb = new Simbolo(t.image);
		tabela.inclui(simb);
		jj_consume_token(ATRIB);
		exp();
		jj_consume_token(COMENT);
	}

	/*
comandoPrinta -> <OUT> <AP>
                 exp ((<VIRG>|<PT_VIRG>) exp)*
                 <FP> <COMENT>
	 */
	static final public void comandoPrinta() throws ParseException {
		jj_consume_token(OUT);
		try {
			jj_consume_token(AP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.COMENT, "abre parenteses");
			{if (true) return;}
		}
		exp();
		label_5:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case VIRG:
				case PT_VIRG:
					;
					break;
				default:
					jj_la1[12] = jj_gen;
					break label_5;
				}
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case VIRG:
					jj_consume_token(VIRG);
					break;
				case PT_VIRG:
					jj_consume_token(PT_VIRG);
					break;
				default:
					jj_la1[13] = jj_gen;
					jj_consume_token(-1);
					throw new ParseException();
				}
				exp();
			}
		try {
			jj_consume_token(FP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.COMENT, "fecha parenteses");
			{if (true) return;}
		}
		jj_consume_token(COMENT);
	}

	/*
comandoPega -> <IN><AP><VAR>(<VIRG><VAR>)*<FP><COMENT>
	 */
	static final public void comandoPega() throws ParseException {
		Simbolo simb; Token t;
		jj_consume_token(IN);
		try {
			jj_consume_token(AP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.COMENT, "abre parenteses");
			{if (true) return;}
		}
		t = jj_consume_token(VAR);
		simb = new Simbolo(t.image);
		tabela.inclui(simb);
		label_6:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case VIRG:
					;
					break;
				default:
					jj_la1[14] = jj_gen;
					break label_6;
				}
				jj_consume_token(VIRG);
				jj_consume_token(VAR);
			}
		try {
			jj_consume_token(FP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.COMENT, "fecha parenteses");
			{if (true) return;}
		}
		jj_consume_token(COMENT);
	}

	/*
comandoSe -> <IF><AP> exp <FP>
             <ACH><COMENT>
             listaComandos <FCH>
             (<ELSE><ACH><COMENT>
             listaComandos <FCH>)?
	 */
	static final public void comandoSe() throws ParseException {
		jj_consume_token(IF);
		jj_consume_token(AP);
		exp();
		jj_consume_token(FP);
		jj_consume_token(ACH);
		jj_consume_token(COMENT);
		listaComandos();
		jj_consume_token(FCH);
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case ELSE:
			jj_consume_token(ELSE);
			jj_consume_token(ACH);
			jj_consume_token(COMENT);
			listaComandos();
			jj_consume_token(FCH);
			break;
		default:
			jj_la1[15] = jj_gen;
			;
		}
	}

	/*
comandoTeste() -> <TEST><ACH> (	blocoCondicional )+
            	  ( <OTHERWISE><ACH> <COMENT>
			        listaComandos()
			        <FCH> 
		          )? <FCH>

blocoCondicional -> <AP> exp <FP> <COMENT>
                    <ACH> listaComandos()
	                <FCH> (<BREAK>)? 
	 */
	static final public void comandoTeste() throws ParseException {
		jj_consume_token(TEST);
		jj_consume_token(ACH);
		label_7:
			while (true) {
				blocoCondicional();
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case AP:
					;
					break;
				default:
					jj_la1[16] = jj_gen;
					break label_7;
				}
			}
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case OTHERWISE:
			jj_consume_token(OTHERWISE);
			jj_consume_token(ACH);
			jj_consume_token(COMENT);
			listaComandos();
			jj_consume_token(FCH);
			break;
		default:
			jj_la1[17] = jj_gen;
			;
		}
		jj_consume_token(FCH);
	}

	static final public void blocoCondicional() throws ParseException {
		jj_consume_token(AP);
		exp();
		jj_consume_token(FP);
		jj_consume_token(ACH);
		jj_consume_token(COMENT);
		listaComandos();
		jj_consume_token(FCH);
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case BREAK:
			jj_consume_token(BREAK);
			break;
		default:
			jj_la1[18] = jj_gen;
			;
		}
	}

	/*
comandoLaco -> <FOR> <AP> (<TYPENUM>)? <VAR><ATRIB>
               exp <PT_VIRG>
               exp <PT_VIRG>
               comandoAtribuicao <FP>
               <ACH> <COMENT> listaComandos <FCH>
	 */
	static final public void comandoLaco() throws ParseException {
		Simbolo simb; Token t;
		jj_consume_token(FOR);
		try {
			jj_consume_token(AP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.ACH, "abre parenteses");
			{if (true) return;}
		}
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case TYPENUM:
			jj_consume_token(TYPENUM);
			break;
		default:
			jj_la1[19] = jj_gen;
			;
		}
		t = jj_consume_token(VAR);
		simb = new Simbolo(t.image);
		tabela.inclui(simb);
		jj_consume_token(ATRIB);
		exp();
		jj_consume_token(PT_VIRG);
		exp();
		jj_consume_token(PT_VIRG);
		t = jj_consume_token(VAR);
		simb = new Simbolo(t.image);
		tabela.inclui(simb);
		jj_consume_token(ATRIB);
		exp();
		try {
			jj_consume_token(FP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.ACH, "fecha parenteses");
			{if (true) return;}
		}
		jj_consume_token(ACH);
		jj_consume_token(COMENT);
		listaComandos();
		jj_consume_token(FCH);
	}

	/*
comandoLacoMultiplo -> <FOR_MULTIPLE> <AP> (TYPENUM)inicioLaco <FP>
                <ACH> <COMENT> listaComandos <FCH>
inicioLaco   -> <VAR> contLaco faixa
contLaco     -> <VIRG> <VAR> contLaco faixa <VIRG>
               | <PT_VIRG>
faixa -> exp <TO> exp
        (<STEP> exp)?
	 */
	static final public void comandoLacoMultiplo() throws ParseException {
		jj_consume_token(FORMULTIPLE);
		try {
			jj_consume_token(AP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.ACH, "fecha parenteses");
			{if (true) return;}
		}
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case TYPENUM:
			jj_consume_token(TYPENUM);
			break;
		default:
			jj_la1[20] = jj_gen;
			;
		}
		inicioLaco();
		try {
			jj_consume_token(FP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.ACH, "fecha parenteses");
			{if (true) return;}
		}
		jj_consume_token(ACH);
		jj_consume_token(COMENT);
		listaComandos();
		jj_consume_token(FCH);
	}

	static final public void inicioLaco() throws ParseException {
		Simbolo simb; Token t;
		t = jj_consume_token(VAR);
		simb = new Simbolo(t.image);
		tabela.inclui(simb);
		contLaco();
		faixa();
	}

	static final public void contLaco() throws ParseException {
		Simbolo simb; Token t;
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case VIRG:
			jj_consume_token(VIRG);
			t = jj_consume_token(VAR);
			simb = new Simbolo(t.image);
			tabela.inclui(simb);
			contLaco();
			faixa();
			jj_consume_token(VIRG);
			break;
		case PT_VIRG:
			jj_consume_token(PT_VIRG);
			break;
		default:
			jj_la1[21] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
	}

	static final public void faixa() throws ParseException {
		exp();
		jj_consume_token(TO);
		exp();
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case STEP:
			jj_consume_token(STEP);
			exp();
			break;
		default:
			jj_la1[22] = jj_gen;
			;
		}
	}

	/*
comandoLacoMatrix -> <FORMATRIX> <AP> <VAR>
                    (<VIR> <VAR>)*
	                <PT_VIRG> faixa <FP>
	                <ACH> <COMENT>
	                listaComandos <FCH>	
faixa -> expAritmetica <TO> expAritmetica
        (<STEP> expAritmetica)?
	 */
	static final public void comandoLacoMatrix() throws ParseException {
		Simbolo simb; Token t;
		jj_consume_token(FORMATRIX);
		try {
			jj_consume_token(AP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.ACH, "fecha parenteses");
			{if (true) return;}
		}
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case TYPENUM:
			jj_consume_token(TYPENUM);
			break;
		default:
			jj_la1[23] = jj_gen;
			;
		}
		t = jj_consume_token(VAR);
		simb = new Simbolo(t.image);
		tabela.inclui(simb);
		label_8:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case VIRG:
					;
					break;
				default:
					jj_la1[24] = jj_gen;
					break label_8;
				}
				jj_consume_token(VIRG);
				t = jj_consume_token(VAR);
				simb = new Simbolo(t.image);
				tabela.inclui(simb);
			}
		jj_consume_token(PT_VIRG);
		faixa();
		try {
			jj_consume_token(FP);
		} catch (ParseException e) {
			RecuperacaoErro.recuperaErroPanico(CompiladorHellConstants.ACH, "fecha parenteses");
			{if (true) return;}
		}
		jj_consume_token(ACH);
		jj_consume_token(COMENT);
		listaComandos();
		jj_consume_token(FCH);
	}

	/*
exp           -> expOr   ( <CONCAT>  expOr )*
expOr         -> expAnd   ( <OR>  expAnd )*
expAnd        -> expNot   ( <AND> expNot )*
expNot        -> ( <NOT> )* expRelacional
expRelacional -> expAdit  ( <MAIOR>   expAdit | <MENOR>   expAdit 
                          | <MAIOR_I> expAdit | <MENOR_I> expAdit |
                          | <IGUAL>   expAdit | <DIF>     expAdit )*
expAdit       -> expMult  ( <ADD>  expMult | <SUB> expMult  )*
expMult       -> expPot   ( <MULT> expPot  | <DIV> expPot )*
expPot        -> expToken ( <POT> expPot )?
expToken      -> <NUM> | <ADD><NUM> | <SUB><NUM> | <VAR> | <BOOL> | <STRING> 
                 | <AP> exp <FP>
	 */
	static final public void exp() throws ParseException {
		expOr();
		label_9:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case CONCAT:
					;
					break;
				default:
					jj_la1[25] = jj_gen;
					break label_9;
				}
				jj_consume_token(CONCAT);
				expOr();
			}
	}

	static final public void expOr() throws ParseException {
		expAnd();
		label_10:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case OR:
					;
					break;
				default:
					jj_la1[26] = jj_gen;
					break label_10;
				}
				jj_consume_token(OR);
				expAnd();
			}
	}

	static final public void expAnd() throws ParseException {
		expNot();
		label_11:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case AND:
					;
					break;
				default:
					jj_la1[27] = jj_gen;
					break label_11;
				}
				jj_consume_token(AND);
				expNot();
			}
	}

	static final public void expNot() throws ParseException {
		label_12:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case NOT:
					;
					break;
				default:
					jj_la1[28] = jj_gen;
					break label_12;
				}
				jj_consume_token(NOT);
			}
	expRelacional();
	}

	static final public void expRelacional() throws ParseException {
		expAdit();
		label_13:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case MAIOR:
				case MENOR:
				case MAIOR_I:
				case MENOR_I:
				case IGUAL:
				case DIF:
					;
					break;
				default:
					jj_la1[29] = jj_gen;
					break label_13;
				}
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case MAIOR:
					jj_consume_token(MAIOR);
					expAdit();
					break;
				case MENOR:
					jj_consume_token(MENOR);
					expAdit();
					break;
				case MAIOR_I:
					jj_consume_token(MAIOR_I);
					expAdit();
					break;
				case MENOR_I:
					jj_consume_token(MENOR_I);
					expAdit();
					break;
				case IGUAL:
					jj_consume_token(IGUAL);
					expAdit();
					break;
				case DIF:
					jj_consume_token(DIF);
					expAdit();
					break;
				default:
					jj_la1[30] = jj_gen;
					jj_consume_token(-1);
					throw new ParseException();
				}
			}
	}

	static final public void expAdit() throws ParseException {
		expMult();
		label_14:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case ADD:
				case SUB:
					;
					break;
				default:
					jj_la1[31] = jj_gen;
					break label_14;
				}
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case ADD:
					jj_consume_token(ADD);
					expMult();
					break;
				case SUB:
					jj_consume_token(SUB);
					expMult();
					break;
				default:
					jj_la1[32] = jj_gen;
					jj_consume_token(-1);
					throw new ParseException();
				}
			}
	}

	static final public void expMult() throws ParseException {
		expPot();
		label_15:
			while (true) {
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case MULT:
				case DIV:
					;
					break;
				default:
					jj_la1[33] = jj_gen;
					break label_15;
				}
				switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
				case MULT:
					jj_consume_token(MULT);
					expPot();
					break;
				case DIV:
					jj_consume_token(DIV);
					expPot();
					break;
				default:
					jj_la1[34] = jj_gen;
					jj_consume_token(-1);
					throw new ParseException();
				}
			}
	}

	static final public void expPot() throws ParseException {
		expToken();
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case POT:
			jj_consume_token(POT);
			expPot();
			break;
		default:
			jj_la1[35] = jj_gen;
			;
		}
	}

	static final public void expToken() throws ParseException {
		Simbolo simb; Token t;
		switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
		case NUM:
			t = jj_consume_token(NUM);

			break;
		case ADD:
			jj_consume_token(ADD);
			t = jj_consume_token(NUM);

			break;
		case SUB:
			jj_consume_token(SUB);
			t = jj_consume_token(NUM);

			break;
		case VAR:
			t = jj_consume_token(VAR);
			simb = new Simbolo(t.image);
			tabela.inclui(simb);
			break;
		case BOOL:
			t = jj_consume_token(BOOL);

			break;
		case STRING:
			t = jj_consume_token(STRING);

			break;
		case AP:
			jj_consume_token(AP);
			exp();
			jj_consume_token(FP);
			break;
		default:
			jj_la1[36] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
	}

	static private boolean jj_initialized_once = false;
	/** Generated Token Manager. */
	static public CompiladorHellTokenManager token_source;
	static SimpleCharStream jj_input_stream;
	/** Current token. */
	static public Token token;
	/** Next token. */
	static public Token jj_nt;
	static private int jj_ntk;
	static private int jj_gen;
	static final private int[] jj_la1 = new int[37];
	static private int[] jj_la1_0;
	static private int[] jj_la1_1;
	static {
		jj_la1_init_0();
		jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
		jj_la1_0 = new int[] {0x7a000000,0x7a000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x4000000,0x0,0x0,0x80000000,0x0,0x0,0x0,0x0,0x0,0x0,0x4000,0x400000,0x200000,0x800000,0x1f8000,0x1f8000,0x300,0x300,0xc00,0xc00,0x1000,0x300,};
	}
	private static void jj_la1_init_1() {
		jj_la1_1 = new int[] {0x47006,0x47006,0x800,0x20,0x800,0x800,0x20,0x800,0x800,0x20,0x800,0x7000,0x60,0x60,0x20,0x0,0x80,0x1,0x0,0x1000,0x1000,0x60,0x10,0x1000,0x20,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x78080,};
	}

	/** Constructor with InputStream. */
	public CompiladorHell(java.io.InputStream stream) {
		this(stream, null);
	}
	/** Constructor with InputStream and supplied encoding */
	public CompiladorHell(java.io.InputStream stream, String encoding) {
		if (jj_initialized_once) {
			System.out.println("ERROR: Second call to constructor of static parser.  ");
			System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
			System.out.println("       during parser generation.");
			throw new Error();
		}
		jj_initialized_once = true;
		try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
		token_source = new CompiladorHellTokenManager(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 37; i++) jj_la1[i] = -1;
	}

	/** Reinitialise. */
	static public void ReInit(java.io.InputStream stream) {
		ReInit(stream, null);
	}
	/** Reinitialise. */
	static public void ReInit(java.io.InputStream stream, String encoding) {
		try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
		token_source.ReInit(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 37; i++) jj_la1[i] = -1;
	}

	/** Constructor. */
	public CompiladorHell(java.io.Reader stream) {
		if (jj_initialized_once) {
			System.out.println("ERROR: Second call to constructor of static parser. ");
			System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
			System.out.println("       during parser generation.");
			throw new Error();
		}
		jj_initialized_once = true;
		jj_input_stream = new SimpleCharStream(stream, 1, 1);
		token_source = new CompiladorHellTokenManager(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 37; i++) jj_la1[i] = -1;
	}

	/** Reinitialise. */
	static public void ReInit(java.io.Reader stream) {
		jj_input_stream.ReInit(stream, 1, 1);
		token_source.ReInit(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 37; i++) jj_la1[i] = -1;
	}

	/** Constructor with generated Token Manager. */
	public CompiladorHell(CompiladorHellTokenManager tm) {
		if (jj_initialized_once) {
			System.out.println("ERROR: Second call to constructor of static parser. ");
			System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
			System.out.println("       during parser generation.");
			throw new Error();
		}
		jj_initialized_once = true;
		token_source = tm;
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 37; i++) jj_la1[i] = -1;
	}

	/** Reinitialise. */
	public void ReInit(CompiladorHellTokenManager tm) {
		token_source = tm;
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 37; i++) jj_la1[i] = -1;
	}

	static private Token jj_consume_token(int kind) throws ParseException {
		Token oldToken;
		if ((oldToken = token).next != null) token = token.next;
		else token = token.next = token_source.getNextToken();
		jj_ntk = -1;
		if (token.kind == kind) {
			jj_gen++;
			return token;
		}
		token = oldToken;
		jj_kind = kind;
		throw generateParseException();
	}


	/** Get the next Token. */
	static final public Token getNextToken() {
		if (token.next != null) token = token.next;
		else token = token.next = token_source.getNextToken();
		jj_ntk = -1;
		jj_gen++;
		return token;
	}

	/** Get the specific Token. */
	static final public Token getToken(int index) {
		Token t = token;
		for (int i = 0; i < index; i++) {
			if (t.next != null) t = t.next;
			else t = t.next = token_source.getNextToken();
		}
		return t;
	}

	static private int jj_ntk() {
		if ((jj_nt=token.next) == null)
			return (jj_ntk = (token.next=token_source.getNextToken()).kind);
		else
			return (jj_ntk = jj_nt.kind);
	}

	static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
	static private int[] jj_expentry;
	static private int jj_kind = -1;

	/** Generate ParseException. */
	static public ParseException generateParseException() {
		jj_expentries.clear();
		boolean[] la1tokens = new boolean[52];
		if (jj_kind >= 0) {
			la1tokens[jj_kind] = true;
			jj_kind = -1;
		}
		for (int i = 0; i < 37; i++) {
			if (jj_la1[i] == jj_gen) {
				for (int j = 0; j < 32; j++) {
					if ((jj_la1_0[i] & (1<<j)) != 0) {
						la1tokens[j] = true;
					}
					if ((jj_la1_1[i] & (1<<j)) != 0) {
						la1tokens[32+j] = true;
					}
				}
			}
		}
		for (int i = 0; i < 52; i++) {
			if (la1tokens[i]) {
				jj_expentry = new int[1];
				jj_expentry[0] = i;
				jj_expentries.add(jj_expentry);
			}
		}
		int[][] exptokseq = new int[jj_expentries.size()][];
		for (int i = 0; i < jj_expentries.size(); i++) {
			exptokseq[i] = jj_expentries.get(i);
		}
		return new ParseException(token, exptokseq, tokenImage);
	}

	/** Enable tracing. */
	static final public void enable_tracing() {
	}

	/** Disable tracing. */
	static final public void disable_tracing() {
	}

}
