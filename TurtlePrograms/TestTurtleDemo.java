
import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestTurtleDemo {

	Turtle turtle;
	InterpreterContext context;
	SyntaxTreeParser syntaxTreeParser;
	TreeVisitor visitor;
	TotalDistanceTravel movement_visitor;
	List<NonTerminalExpression> treeList;
	ArrayList<Command> commandList;
	Point expectedLocation;

	@Before
	public void SetUp() {
		turtle = new Turtle();
		context = new InterpreterContext(turtle);
		syntaxTreeParser = new SyntaxTreeParser(context);
		visitor = new TreeVisitor(context);
		movement_visitor = new TotalDistanceTravel(context);
		treeList = new ArrayList<NonTerminalExpression>();
		commandList = new ArrayList<Command>();
	}

	@Test
	public void startUpLocationTest() {
		expectedLocation = new Point(0, 0);
		assertEquals(expectedLocation, turtle.location());

	}

	@Test
	public void moveTurnTest() {
		expectedLocation = new Point(40, 10);
		String filename = "program.txt";
		treeList = syntaxTreeParser.parseTurtleProgram(filename);
		for (NonTerminalExpression x : treeList) {
			x.accept(visitor).execute();
		}

		assertEquals(expectedLocation, turtle.location());

	}

	@Test
	public void moveTurnLoopTest() {
		expectedLocation = new Point(0, 0);
		String filename = "program1.txt";
		treeList = syntaxTreeParser.parseTurtleProgram(filename);
		for (NonTerminalExpression x : treeList) {
			x.accept(visitor).execute();
		}

		assertEquals(expectedLocation, turtle.location());

	}

	@Test
	public void totalTurtleMoveTest() {
		int expectedMovement = 95;
		String filename = "program2.txt";
		treeList = syntaxTreeParser.parseTurtleProgram(filename);
		for (NonTerminalExpression x : treeList) {
			x.accept(visitor).execute();
		}

		for (NonTerminalExpression x : treeList) {
			x.accept(movement_visitor);
		}

		assertEquals(expectedMovement, turtle.getTotalMoveMent());

	}

	@Test
	public void undoLocationTest() {
		Point expectedLocationAfterExecute = new Point(100, 0);
		Point expectedLocationAfterUndo = new Point(0, 0);
		String filename = "program3.txt";
		treeList = syntaxTreeParser.parseTurtleProgram(filename);
		for (NonTerminalExpression x : treeList) {
			x.accept(visitor).execute();
		}

		assertEquals(expectedLocationAfterExecute, turtle.location());

		for (NonTerminalExpression x : treeList) {
			x.accept(visitor).undo();
		}
		assertEquals(expectedLocationAfterUndo, turtle.location());
	}

}
