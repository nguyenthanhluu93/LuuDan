package luunt;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.start();
    }
}
