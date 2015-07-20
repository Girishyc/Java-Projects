
public class PenUpExpression extends NonTerminalExpression {

	public PenUpExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		super(left, right);
	}

	@Override
	public Command interpretExp(InterpreterContext context) {
		this.command = new PenUpCommand(context);
		if (context.isRepeated())
			context.repeatmnemonics.add(this);
		return this.command;

	}

	@Override
	public Command accept(Visitor v) {
		return v.visitNonTerminalExp(this);
	}

}
