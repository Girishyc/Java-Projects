
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class InterpreterContext {
	static Hashtable<String, Integer> mnemonics;
	ArrayList<NonTerminalExpression> repeatmnemonics;
	List<NonTerminalExpression> nonTerminalExpressions;
	Turtle turtle;
	private boolean isRepeated;
	private int repeatCommandCounter;

	public InterpreterContext(Turtle turtle) {
		this.turtle = turtle;
		repeatmnemonics = new ArrayList<NonTerminalExpression>();
		nonTerminalExpressions = new ArrayList<NonTerminalExpression>();
		mnemonics = new Hashtable<String, Integer>();
		repeatCommandCounter = 0;
		isRepeated = false;
	}

	protected void setValue(String command, Integer value) {
		mnemonics.put(command, value);
	}

	protected int getValue(String command) {
		return mnemonics.get(command).intValue();
	}

	protected boolean contains(String command) {
		return (mnemonics.containsKey(command));

	}

	protected boolean isRepeated() {
		return isRepeated;
	}

	protected void setRepeated(boolean isRepeated) {
		this.isRepeated = isRepeated;
	}

	protected int getRepeatCommandCounter() {
		return repeatCommandCounter;
	}

	protected void setRepeatCommandCounter(int repeatCommandCounter) {
		this.repeatCommandCounter = repeatCommandCounter;
	}
}
