package intermediario;

public class BlocoLacoMultiplo {
	private String var;
	private Expressao expFrom;
	private Expressao expTo;
	private Expressao expStep;
	
	public BlocoLacoMultiplo(String _var){
		this.var = _var;
	}
	public BlocoLacoMultiplo(Expressao _expFrom,Expressao _expTo,Expressao _expStep){
		this.expFrom = _expFrom;
		this.expTo = _expTo;
		this.expStep = _expStep;
	}
}
