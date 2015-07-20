
public class TurnTurtleExpression extends NonTerminalExpression {
	public TurnTurtleExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		super(left, right);

	}
	@Override
	public Command  interpretExp(InterpreterContext context) {
		int degrees=(int)(getLeft().interpretExp(context));
		this.command = new TurnCommand(degrees,context.turtle);
		if(context.isRepeated())
			context.repeatmnemonics.add(this);
		return this.command;
	}


	@Override
	public Command accept(Visitor v) {
		return v.visitNonTerminalExp(this);

	}
}
