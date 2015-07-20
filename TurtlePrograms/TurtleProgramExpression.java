

public abstract class TurtleProgramExpression {
	abstract public Object interpretExp(InterpreterContext context);
	abstract public Command accept(Visitor v);
}

