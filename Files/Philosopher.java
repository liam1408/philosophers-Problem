import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Philosopher extends Thread {
	private final int SEED_NUMBER = 4000;
	private Chopsticks left;
	private Chopsticks right;
	private ImageView phil;
	private Monitor monitor;

	private Image myImage1 = new Image(getClass().getResourceAsStream("eating.jpg"));
	private Image myImage2 = new Image(getClass().getResourceAsStream("phil.jpg"));
	public Philosopher(Chopsticks left, Chopsticks right, ImageView phil, Monitor monitor) {
		this.left = left;
		this.right = right;
		this.phil = phil;
		this.monitor = monitor;
	}

	public void run() {
		try {
			while (true) {
				think();
				monitor.pickUp(left, right);
				eat();
				monitor.dropDown(left, right);
			}
		} catch (InterruptedException e) {

		}
	}

	public void eat() throws InterruptedException {
		actionStart(() -> {
			phil.setImage(myImage1);

		});

		Thread.sleep((long) (Math.random() * SEED_NUMBER));
	}

	public void think() throws InterruptedException {
		actionStart(() -> {
			synchronized (phil) {
				phil.setImage(myImage2);
			}
		});

		Thread.sleep((long) (Math.random() * SEED_NUMBER));
	}

	private void actionStart(Runnable action) {
		Platform.runLater(() -> {
			synchronized (phil) {
				if (phil != null) {
					action.run();
				}
			}
		});
	}
}
