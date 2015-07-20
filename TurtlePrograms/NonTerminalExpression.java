
public abstract class NonTerminalExpression extends TurtleProgramExpression {

	private TurtleProgramExpression left;
	private TurtleProgramExpression right;
	protected Command command;
	
	public NonTerminalExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public abstract Command interpretExp(InterpreterContext context);

	@Override
	public String toString() {
		return null;
	}
	
	public  TurtleProgramExpression getLeft() {
		return left;
	}

	@Override
	public abstract Command accept(Visitor aVisitor);

}
