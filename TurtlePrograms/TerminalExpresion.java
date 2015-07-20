
public class TerminalExpresion extends TurtleProgramExpression {

	String constantName;

	public TerminalExpresion(String constantName) {
		this.constantName = constantName;
	}

	@Override
	public Object interpretExp(InterpreterContext context) {
		return context.getValue(constantName);

	};

	@Override
	public Command accept(Visitor aVisitor) {
		return null;

	}

}
