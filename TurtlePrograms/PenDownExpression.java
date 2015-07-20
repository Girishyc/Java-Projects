
public class PenDownExpression extends NonTerminalExpression {

	public PenDownExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		super(left, right);
	}

	@Override
	public Command interpretExp(InterpreterContext context) {
		this.command  = new PenDownCommand(context);
		if(context.isRepeated())
			context.repeatmnemonics.add(this);
		return this.command;

	}

	@Override
	public Command accept(Visitor v) {
		return v.visitNonTerminalExp(this);
	}

}
