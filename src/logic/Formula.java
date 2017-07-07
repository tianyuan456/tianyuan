package logic;

public abstract class Formula {

	public abstract String makeString();
	
	/*
	 * Puts brackets around makeString if the formula is not a symbol
	 */
	public String makeBracketString(){
		if(!this.isSymbol()){
			return "("+makeString()+")";
		}
		return makeString();
	}
	
	public boolean isSymbol(){ return false;}
	
	@Override
	public String toString(){
		return makeString();
	}
	
	/// NEXT
	// public String toTPTP();
	
	// NEXT
	// Factory Methods
	// e.g.
	// Formula.and(a,b);
	
}
