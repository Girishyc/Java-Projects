
public class TurtleRepeatExpression extends NonTerminalExpression {

	public TurtleRepeatExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		super(left, right);
	}
	@Override
	public Command interpretExp(InterpreterContext context) {
			int counter=(int)(this.getLeft().interpretExp(context));
			context.setRepeated(true);
			context.setRepeatCommandCounter(counter);
			return null;
	}

	@Override
	public Command accept(Visitor v) {
		return v.visitNonTerminalExp(this);
	}
	
}
