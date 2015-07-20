
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SyntaxTreeParser {
	private InterpreterContext turtleContext;

	TurtleProgramExpression expression = null;

	public SyntaxTreeParser(InterpreterContext context) {
		turtleContext = context;
	}

	private NonTerminalExpression parseNonTerminalExpression(String instruction) {
		String[] inputString = instruction.split("\\s+");
		NonTerminalExpression npExpression = null;
		if (instruction.contains("move")) {
			if (!turtleContext.contains(inputString[1])) {
				Integer value = Integer.parseInt(inputString[1]);
				turtleContext.setValue(inputString[1], value);
			}
			npExpression = new MoveTurtleExpression(new TerminalExpresion(
					inputString[1]), null);
			npExpression.interpretExp(turtleContext);
		} else if (instruction.contains("turn")) {
			if (!turtleContext.contains(inputString[1])) {
				Integer value = Integer.parseInt(inputString[1]);
				turtleContext.setValue(inputString[1], value);
			}
			npExpression = new TurnTurtleExpression(new TerminalExpresion(
					inputString[1]), null);
			npExpression.interpretExp(turtleContext);
		} else if (instruction.contains("penUp")) {
			npExpression = new PenUpExpression(new TerminalExpresion(
					inputString[0]), null);
			npExpression.interpretExp(turtleContext);
		} else if (instruction.contains("penDown")) {
			npExpression = new PenDownExpression(new TerminalExpresion(
					inputString[0]), null);
			npExpression.interpretExp(turtleContext);
		} else if (instruction.contains("end")) {
			npExpression = new EndTurtleExpression(new TerminalExpresion(
					inputString[0]), null);
			npExpression.interpretExp(turtleContext);
		} else if (instruction.contains("repeat")) {
			if (inputString.length > 1) {
				if (!turtleContext.contains(inputString[1])) {
					Integer value = Integer.parseInt(inputString[1]);
					turtleContext.setValue(inputString[1], value);
				}
				npExpression = new TurtleRepeatExpression(
						new TerminalExpresion(inputString[1]), null);
				npExpression.interpretExp(turtleContext);
			}
		}

		return npExpression;

	}

	public List<NonTerminalExpression> parseTurtleProgram(String filename) {
		try {

			String inst;
			FileReader fileReader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((inst = bufferedReader.readLine()) != null) {
				String[] inputString = inst.split("\\s+");
				if (inst.contains("$") && inst.contains("=")) {
					Integer value = Integer.parseInt(inputString[2]);
					turtleContext.setValue(inputString[0], value);
					turtleContext.setValue(inputString[2], value);
				} else {
					expression = parseNonTerminalExpression(inst);
					if (!inst.contains("repeat") && !inst.contains("end"))
						if ((null != expression))
							turtleContext.nonTerminalExpressions
							.add((NonTerminalExpression) expression);
				}
			}
			bufferedReader.close();
			return turtleContext.nonTerminalExpressions;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return turtleContext.nonTerminalExpressions;
	}

}
