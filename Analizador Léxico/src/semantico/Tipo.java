package semantico;

public enum Tipo {
	    VAR_STRING,
	    VAR_BOOLEANO,
	    VAR_NUMERO,
	    OPERADOR,
	    PARENTESES,
	    CTE_STRING,
	    CTE_BOOLEANO,
	    CTE_NUMERO;
	    
	public static String toStr(Tipo tipo) {
	   if(tipo == Tipo.VAR_STRING) return "variavel string";
	   else if(tipo == Tipo.VAR_BOOLEANO) return "variavel booleano";
	   else if(tipo == Tipo.VAR_NUMERO) return "variavel numero";
	   else if(tipo == Tipo.OPERADOR) return "operador";
	   else if(tipo == Tipo.CTE_STRING) return "constante string";
	   else if(tipo == Tipo.CTE_BOOLEANO) return "constante booleano";
	   else if(tipo == Tipo.PARENTESES) return "parenteses";
	   else return "constante numero";
	}
}
