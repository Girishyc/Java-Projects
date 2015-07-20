
public class MoveTurtleExpression extends NonTerminalExpression {
	
	public MoveTurtleExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		super(left, right);
	}
	
	
	public Command interpretExp(InterpreterContext context) {
		this.command = new MoveCommand((int)(getLeft().interpretExp(context)),context.turtle);
		if(context.isRepeated())
		context.repeatmnemonics.add(this);
		return this.command;
	}

	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public Command accept(Visitor v) {
		return v.visitNonTerminalExp(this);
	}

}
