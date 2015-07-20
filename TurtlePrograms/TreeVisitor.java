

public class TreeVisitor extends Visitor{

	InterpreterContext context;
	
	public TreeVisitor(InterpreterContext context) {
		this.context=context;
	}
	
	@Override
	Command visitNonTerminalExp(NonTerminalExpression node) {
		return node.command;
	}

	@Override
	Object visitTerminalExp(TerminalExpresion node) {
		return node.interpretExp(context);
	}

}
