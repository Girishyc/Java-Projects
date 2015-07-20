

public abstract class Visitor {
	 abstract Command visitNonTerminalExp(NonTerminalExpression exp);
	 abstract Object visitTerminalExp(TerminalExpresion exp);
}
