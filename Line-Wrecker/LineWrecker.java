import java.util.Scanner;

class Logic {
	boolean running;
	byte guesses = 0;
	byte[] locations = new byte[3];

void setup() {
	byte rand = (byte) ((Math.random() * (6))+1);
	for(byte i = 0; i < locations.length; i++)
		locations[i] = (byte) (rand+i);
	running = true;

	System.out.println("- A row of three cells are hiding into a Byte.");
	System.out.println("- Hit them by typing in a number between one and eight!");
}

String check(String input) {
	int guess = 0;

	try { guess = Integer.parseInt(input); }
	catch(Exception e) {}

	String output = "You hit any bit";

	for(byte i = 0; i < locations.length; i++) {
		if (guess <= 0 || guess > 8) {
			output = "You should hit between 1 and 8";
			guesses--;
			break; }
		if (guess == locations[i]) {
			locations[i] = 0;
			output = "You hit a bit!"; }
		if (locations[0]==0 && locations[1]==0 && locations[2]==0) {
			output = "You won! It took you " + guesses + " guesses!";
			running = false;	}
		}
	return output;
	}
}

class LineWrecker {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		Logic game = new Logic();
		game.setup();

		while(game.running) {
		System.out.print("> ");
		game.guesses++;
		System.out.println("- " + game.check(in.next()) + "\n"); }
	}
}