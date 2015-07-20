

public class TurnCommand implements Command {
	private int degrees;
	private Turtle turtle;

	public TurnCommand(Object object, Turtle turtle) {
		this.degrees = Integer.parseInt(object.toString());
		this.turtle = turtle;
	}

	@Override
	public void execute() {
		turtle.turn(degrees);
	}

	@Override
	public void undo() {
		turtle.turn(-degrees);
	}

	@Override
	public void redo() {

	}

}
