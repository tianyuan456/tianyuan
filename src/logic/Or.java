package logic;

public class Or extends Formula {
	public final Formula left;
	public final Formula right;
	
	Or(Formula l, Formula r){
		left=l;
		right=r;
	}
	
	@Override
	public String makeString() {
		String l = left.makeBracketString();
		String r = right.makeBracketString();
		return l+" or "+r;
	}	
	
	
	@Override
	public boolean equals(Object other){
		//TODO
	}	
}
