
public class MoveCommand implements Command {
	private int value;
	private Turtle turtle;

	public MoveCommand(Object object, Turtle turtle) {
		this.value = Integer.parseInt(object.toString());
		this.turtle = turtle;
	}

	public void execute() {
		turtle.move(value);
	}

	public void undo() {
		turtle.move(-value);

	}

	public void redo() {

	}

}
