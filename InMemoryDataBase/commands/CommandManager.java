package aoop.assignment3.commands;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class CommandManager implements Serializable {

	private static final long serialVersionUID = 1L;
	public LinkedList<Command> commandHistory;
	public CommandManager commandManager;

	public CommandManager() throws ClassNotFoundException, IOException {
			commandHistory = new LinkedList<Command>();
	}

	public void setCommandHistory(LinkedList<Command> commands) {
		commandHistory = commands;
	}

	public void recordHistory(Command command) {

		try {
			if (isCommandHistoryEmpty()) {
				commandHistory = getCommandHistory();
			} else {
				commandHistory = new LinkedList<Command>();
			}
			commandHistory.add(command);
			saveCommandHistory(commandHistory);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	private boolean isCommandHistoryEmpty() throws IOException,
			ClassNotFoundException {
		return getCommandHistory() != null;
	}

	public void PrintHistory() {
		System.out.println(commandHistory);
	}

	public void eraseCommand() {
		try {
			saveCommandHistory(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveCommandHistory(LinkedList<Command> commandHistory)
			throws IOException {
		try {

			FileOutputStream file = new FileOutputStream("commandHisotory.ser");
			ObjectOutputStream obOutputStream = new ObjectOutputStream(file);
			obOutputStream.writeObject(commandHistory);
			obOutputStream.close();
		} catch (IOException e) {
			System.out.println("Exception in writting Occur");
		}
	}

	@SuppressWarnings("unchecked")
	public LinkedList<Command> getCommandHistory() throws IOException,
			ClassNotFoundException {
		LinkedList<Command> command = new LinkedList<Command>();
		try {
			FileInputStream file = new FileInputStream("commandHisotory.ser");
			ObjectInputStream obInputStream = new ObjectInputStream(file);
			command = (LinkedList<Command>) obInputStream.readObject();
			obInputStream.close();

		} catch (IOException e) {

		}
		return command;

	}

}
