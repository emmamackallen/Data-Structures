import java.util.Scanner;

public class RunwayReservation {
	private static int n;
	private static int k;

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // The total number of requests.
		k = kb.nextInt(); // Grace time between requests.

		// Variables for getting the input.
		String cmd;
		int time = 0;
		String flightname = null;
		String flightnumber = null;
		String source = null;
		String destination = null;
		int curtime = 0; // Current time, initialized to 0.

		// An array of requests. This is the data stored outside of our binary search tree.
		Requests [] reqs = new Requests[n];
		int i = 0;

		// Reading the input. All requests are read from the input file and stored in array reqs.
		while(kb.hasNext()) {
			cmd = kb.next();

			if (cmd.equals("r")) {
				time = kb.nextInt();
				flightname = kb.next();
				flightnumber = kb.next();
				source = kb.next();
				destination = kb.next();

				reqs[i++] = new Requests(cmd, time, flightname, flightnumber, source, destination);
			}
			else {
				time = kb.nextInt();
				reqs[i++] = new Requests(cmd, time);
			}
			kb.nextLine();
		}

		// TODO: Code to process each request and solve the Runway Reservation problem.
		BST t = new BST();

		for (i = 0; reqs[i].getCommand().equals("t"); ++i, curtime += reqs[i].getTime()) {
			t.insert(reqs[i].getTime(), i);
			i++;
		}

		for (i = 0; i < n; ++i) {
			cmd = reqs[i].getCommand();

			if (cmd.equals("r")) {
				int tc = reqs[i].getTime();
				Node p = t.pred(tc);
				Node s = t.succ(tc);

				if ((p == null || tc - p.getTime() >= k) && (s == null || s.getTime() - tc >= k)) {
					t.insert(reqs[i].getTime(), i);
				}
			}

			else {
				int tc = reqs[i].getTime();
				curtime += tc;

				System.out.println("Current time = " + curtime + " units");
				Node cur = t.min();

				while (cur != null && cur.getTime() < curtime) {
					int ind = cur.getReq_index();
					System.out.println(reqs[ind].getAirline());
					t.delete(cur.getTime());
					cur = t.min();
				}
			}
		}
	
		Node timePlane = t.max();
		if (timePlane != null) {
			curtime = timePlane.getTime();
		}

		System.out.println("Current time = " + curtime + " units");
		Node cur = t.min();

		while (cur != null) {
			int ind = cur.getReq_index();
			System.out.println(reqs[ind].getAirline());
			t.delete(cur.getTime());
			cur = t.min();
		}

	}
}
