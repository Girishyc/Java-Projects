
public class PenDownCommand implements Command {

	private Turtle turtle;

	public PenDownCommand(InterpreterContext context) {
		this.turtle = context.turtle;
	}

	@Override
	public void execute() {
		turtle.penDown();
	}

	@Override
	public void undo() {
		turtle.penUP();
	}

	@Override
	public void redo() {

	}

}
