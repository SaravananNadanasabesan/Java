package studentLocker;

public class lockerProblem {

	public static void main(String[] args) {
		//Initialize the array representing 100 lockers, where false indicates all lockers are closed
		boolean [] lockers = new boolean[100];
		
		//simulation process starts where each student toggle the lockers
		for (int student=1;student<=100;student++) {
			for (int locker=student;locker<=100;locker+=student) {
				//Toggle the locker if it's true (open), set to false (closed), and vice versa
				lockers[locker - 1] = !lockers[locker - 1];
		}
	}
		//Displays the lockers that are open
		System.out.println("The Lockers that are open:");
		for (int i=0; i<lockers.length;i++) {
			if (lockers[i]) { //Print if it locker is true (open)
				System.out.println("Locker " + (i+1) + " is open");
			}
		}
	}
}
