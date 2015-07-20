
import java.awt.Point;
import java.lang.Math;

public class Turtle {
	private int currentDirection;
	private double radians;
	private Point currentLocation;
	private boolean penUpFlag = false;
	static double pi = 3.14;
	private int totalMoveMent=0;
	public Turtle() {
		double currentX = 0.0, currentY = 0.0;
		currentDirection = 0;
		radians = currentDirection * pi / 180;
		currentLocation = new Point();
		currentLocation.setLocation(currentX, currentY);
	}

	protected void move(int distance) {
		double deltaX, deltaY, newX, newY;
		deltaX = Math.cos(radians) * distance;
		deltaY = Math.sin(radians) * distance;
		newX = currentLocation.getX() + deltaX;
		newY = currentLocation.getY() + deltaY;
		currentLocation.setLocation(newX, newY);
	}

	protected void turn(int degrees) {
		currentDirection += degrees;
		radians = currentDirection * pi / 180;
	}

	protected void penUP() {
		penUpFlag = true;
	}

	protected void penDown() {
		penUpFlag = false;
	}

	protected boolean isPenUp() {
		return penUpFlag;
	}

	protected int direction() {
		return currentDirection;
	}

	protected Point location() {
		return currentLocation;
	}

	protected  void updateTotalMovement(int move){
		totalMoveMent+=move;
	}

	protected  int getTotalMoveMent(){
		return totalMoveMent;
	}
}
