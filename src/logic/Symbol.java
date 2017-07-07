package logic;

public class Symbol extends Formula {

	public final String name;
	
	Symbol(String n){
		name=n;
	}

	public boolean isSymbol(){ return true;}
	
	@Override
	public String makeString() {
		return name;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof Symbol){
			Symbol sother = (Symbol) other;
			return sother.name.equals(name);
		}
		return false;
	}
	
}
