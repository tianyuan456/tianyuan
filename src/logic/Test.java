package logic;

public class Test {

	public static void main(String[] args){
		
		
		
		Formula f1 = new And(new Symbol("a"),new Symbol("b"));		
		Formula f2 = new And(new Symbol("a"),new Symbol("b"));
		
		
		System.out.println(f1.equals(f2));
		
		//Formula g = new Or(f1,new Symbol("c"));
		//System.out.println(g);
	}
	
}
