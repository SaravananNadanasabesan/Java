A school has 100 lockers and 100 students. All lockers are closed on the first day of school. As the students enter, the first student, denoted S1, opens every locker. Then the second student, S2, begins with the second locker, denoted L2, and closes every other locker. Student S3 begins with the third locker and changes every third locker (closes it if it was open, and opens it if it was closed). Student S4 begins with locker L4 and changes every fourth locker. Student S5 starts with L5 and changes every fifth locker, and so on, until student S100 changes L100.
After all the students have passed through the building and changed the lockers, which lockers are open? Write a program to find your answer. The program should display the answer like this: 
Locker x is open
Locker y is open
…
Locker z is open
(Hint: Use an array of 100 boolean elements, each of which indicates whether a locker is open (true) or closed (false). Initially, all lockers are closed.)

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
