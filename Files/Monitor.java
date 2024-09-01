
public class Monitor {
	public synchronized void pickUp(Chopsticks left, Chopsticks right) throws InterruptedException {
		while (left.isOcc() || right.isOcc()) {
			wait();
		}
		left.setOcc(true);
		right.setOcc(true);
	}

	public synchronized void dropDown(Chopsticks left, Chopsticks right) {
		left.setOcc(false);
		right.setOcc(false);
		notify();
	}
}
