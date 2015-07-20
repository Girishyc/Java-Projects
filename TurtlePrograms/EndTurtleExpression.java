public class EndTurtleExpression extends NonTerminalExpression {

	public EndTurtleExpression(TurtleProgramExpression left,
			TurtleProgramExpression right) {
		super(left, right);
	}

	@Override
	public Command interpretExp(InterpreterContext context) {
		int count =1;
		context.setRepeated(false);
		while(count!=context.getRepeatCommandCounter()){
			for(NonTerminalExpression expression:context.repeatmnemonics){
				context.nonTerminalExpressions.add(expression);
			}
			count++;
		}
		return null;
	}

	@Override
	public Command accept(Visitor v) {
		return v.visitNonTerminalExp(this);
	}

}
