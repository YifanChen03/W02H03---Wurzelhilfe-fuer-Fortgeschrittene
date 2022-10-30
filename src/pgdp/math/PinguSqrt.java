package pgdp.math;

public class PinguSqrt {

	public static void sqrt(double n) {
		//declaration + initialization
		int i = 0;
		int c_index = 0;
		int minuend = 0;
		int subtrahend = 0;
		int round = 0;
		String fixed_number = String.valueOf(n);
		String number = String.valueOf(n);
		String[] d_packs;

		c_index = fixed_number.indexOf(".");
		if (fixed_number.substring(0, c_index).length() % 2 != 0) {
			number = "0" + number;
		}
		if (fixed_number.substring(c_index + 1, fixed_number.length()).length() % 2 != 0) {
			number = number + "0";
		}
		number = number.replace(".", "");

		//(unnecessary) prints cleaned up String "number"
		System.out.println(number + "\n");

		d_packs = new String[number.length() / 2];
		for (int r = 0; r <= number.length() - 2; r = r + 2) {
			d_packs[i] = number.substring(r, r + 2);
			i++;
		}

		//(unnecessary) prints all "two-packs"
		for (int r = 0; r < d_packs.length; r++) {
			System.out.println(d_packs[r]);
		}

		//start calculation
		/*minuend = Integer.valueOf(d_packs[0]);
		subtrahend = 1;
		while (minuend >= 0) {
			System.out.println(subtrahend);
			minuend = minuend - subtrahend;
			subtrahend = subtrahend + 2;
			round++;
		}*/
		//System.out.println(round);
		//round has to be reduced by one
		round = round - 1;
	}

	public static void main(String[] args) {
		// test your implementation here
		sqrt(10489.763);
	}

}
