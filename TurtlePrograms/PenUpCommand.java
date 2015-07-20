
public class PenUpCommand implements Command{

	private Turtle turtle;
	
	public PenUpCommand(InterpreterContext context) {
		this.turtle=context.turtle;
	}
	
	@Override
	public void execute() {
		turtle.penUP();
	}

	@Override
	public void undo() {
		turtle.penDown();
	}

	@Override
	public void redo() {
		
	}

}
