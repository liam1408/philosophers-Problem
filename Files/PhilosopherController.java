
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


public class PhilosopherController {

    @FXML
    private ImageView phil4;

    @FXML
    private ImageView phil3;

    @FXML
    private ImageView phil1;

    @FXML
    private ImageView phil2;

    @FXML
    private ImageView phil5;
	
	private final int SIZE = 5;
	private Philosopher[] philosophers = new Philosopher[SIZE];

	private Monitor monitor = new Monitor();
	private Chopsticks[] chopsticks = new Chopsticks[SIZE];
	

	public void initialize() {
		for (int i = 0; i < SIZE; i++) {
			chopsticks[i] = new Chopsticks();
		}
		philosophers[0] = new Philosopher(chopsticks[0], chopsticks[1], phil1, monitor);
		philosophers[1] = new Philosopher(chopsticks[1], chopsticks[2], phil2, monitor);
		philosophers[2] = new Philosopher(chopsticks[2], chopsticks[3], phil3, monitor);
		philosophers[3] = new Philosopher(chopsticks[3], chopsticks[4], phil4, monitor);
		philosophers[4] = new Philosopher(chopsticks[4], chopsticks[0], phil5, monitor);

		
		for (Philosopher philosopher : philosophers) {
			Thread thread = new Thread(philosopher);
			thread.start();
		}
	}
}
