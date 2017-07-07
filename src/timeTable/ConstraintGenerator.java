package timeTable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;


public class ConstraintGenerator {

	
	
	public static void main(String[] args){
		
		ConstraintGenerator generator = new ConstraintGenerator(4,6);
		
		// generate constraints
		generator.timeSlotsContainAtMostOneLesson();
		generator.everyLessonIsScheduledInATimeSlot();
		generator.noLessonIsScheduledMoreThanOnce();
		
		//print constraints
		generator.print();
		
	}
	
	// Propositional symbol time_lesson
	// This is true if the lesson is at the time and false otherwise
	String getSymbol(int time, int lesson){
		return "t"+time+"_l"+lesson;
	}

	
	private final int Ntime;
	private final int Nlesson;
	private final Set<String> constraints;
	
	
	public ConstraintGenerator(int Ntime, int Nlesson) {
		this.Ntime = Ntime;
		this.Nlesson = Nlesson;
		this.constraints = new HashSet<String>();
	}

	
	public void print(){
		for(String constraint : constraints){
			System.out.println("fof(a,axiom,"+constraint+").");
		}
	}
	
	String disjunctionFixTime(int time, int excludeLesson){
		
		List<String> disjuncts = new ArrayList<String>();
		for(int lesson=0;lesson<Nlesson;lesson++){
			if(lesson!=excludeLesson){
				String symbol = getSymbol(time,lesson);
				disjuncts.add(symbol);
			}
		}
		
		return StringUtils.join(disjuncts," | ");
	}
	String disjunctionFixLesson(int lesson){
		return disjunctionFixLesson(lesson,Ntime+1);
	}
	String disjunctionFixLesson(int lesson, int excludeTime){
		
		List<String> disjuncts = new ArrayList<String>();
		for(int time=0;time<Ntime;time++){
			if(time!=excludeTime){
				String symbol = getSymbol(time,lesson);
				disjuncts.add(symbol);
			}
		}
		
		return StringUtils.join(disjuncts," | ");
	}	
	
	/*
	 * At one time we can only have one lesson
	 */
	void timeSlotsContainAtMostOneLesson(){
		for(int time=0;time<Ntime;time++){
			for(int lesson=0;lesson<Nlesson;lesson++){
					String symbol = getSymbol(time,lesson);
					String others = disjunctionFixTime(time,lesson);
					String constraint = symbol+" => ~("+others+")";
					constraints.add(constraint);
			}
		}
	}
	
	/*
	 * Every lesson is in time a time slot
	 * At least once
	 */
	void everyLessonIsScheduledInATimeSlot(){
		for(int lesson=0;lesson<Nlesson;lesson++){
			constraints.add(disjunctionFixLesson(lesson));
		}
	}
	/*
	 * A lesson is not in more than one time slot
	 * At most once
	 */
	void noLessonIsScheduledMoreThanOnce(){
		//TODO fill this in
	}
	
}
