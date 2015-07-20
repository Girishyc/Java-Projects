

public class TotalDistanceTravel extends Visitor{

	InterpreterContext context;
	
	public TotalDistanceTravel(InterpreterContext context) {
		this.context=context;
	}
	
	@Override
	Command visitNonTerminalExp(NonTerminalExpression node) {
			if(node instanceof MoveTurtleExpression)
			context.turtle.updateTotalMovement((int)(node.getLeft().interpretExp(context)));
			return null;
	}

	@Override
	Command visitTerminalExp(TerminalExpresion node) {
		return null;
	}

}
