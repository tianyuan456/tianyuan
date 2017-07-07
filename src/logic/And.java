package logic;

public class And extends Formula {
	public final Formula left;
	public final Formula right;
	
	And(Formula l, Formula r){
		left=l;
		right=r;
	}

	@Override
	public String makeString() {
		String l = left.makeBracketString();
		String r = right.makeBracketString();
		return l+" and "+r;
	}
	
	@Override
	public boolean equals(Object other){
		if(other instanceof And){
			And aother = (And) other;
			return aother.left.equals(left) && aother.right.equals(right);
		}
		return false;
	}
	
}
