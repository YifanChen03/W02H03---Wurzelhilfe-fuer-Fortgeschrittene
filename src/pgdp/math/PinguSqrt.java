package pgdp.math;

public class PinguSqrt {

	public static void sqrt(double n) {
		//declaration + initialization
		int i = 0;
		int d_packs_l = 0;
		int d_packs_r = 0;
		int c_index = 0;
		int minuend = 0;
		int d_minuend = 0;
		int d_result = 0;
		int subtrahend = 0;
		int start_subtrahend = 0;
		int round = 0;
		int number_d_pack = 0;
		String result = "";
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
		//System.out.println(number + "\n");

		d_packs = new String[number.length() / 2];
		for (int r = 0; r <= number.length() - 2; r = r + 2) {
			d_packs[i] = number.substring(r, r + 2);
			i++;
		}

		//(unnecessary) prints all "two-packs"
		/*for (int r = 0; r < d_packs.length; r++) {
			System.out.println(d_packs[r]);
		}*/

		//start calculation
		minuend = Integer.valueOf(d_packs[number_d_pack]);
		d_minuend = minuend;
		d_result = minuend;
		start_subtrahend = 1;
		subtrahend = 0;
		while (d_result >= 0) {
			subtrahend = subtrahend + start_subtrahend + 2 * round;
			d_result = d_minuend - subtrahend;
			round++;
		}
		//round has to be reduced by one
		round = round - 1;
		subtrahend = subtrahend - (start_subtrahend + 2 * (round));
		d_result = minuend - subtrahend;
		result = result + String.valueOf(round);
		number_d_pack = 1;

		//begin second round
		//System.out.println(c_index);
		if (c_index % 2 != 0) {
			d_packs_l = c_index / 2 + 1;
		} else {
			d_packs_l = c_index / 2;
		}
		for (int r = 0; r < d_packs_l - 1; r++) {
			minuend = Integer.valueOf(d_result + d_packs[number_d_pack]);
			d_minuend = minuend;
			start_subtrahend = Integer.valueOf(String.valueOf(Integer.valueOf(result) * 2) + "1");
			subtrahend = 0;
			d_result = minuend;
			round = 0;

			while (d_result >= 0) {
				subtrahend = subtrahend + start_subtrahend + 2 * round;
				d_result = d_minuend - subtrahend;
				round++;
			}
			round = round - 1;
			subtrahend = subtrahend - (start_subtrahend + 2 * (round));
			d_result = minuend - subtrahend;
			result = result + String.valueOf(round);

			number_d_pack = number_d_pack + 1;
			//(unnecessary) just for visualization
			//System.out.println(result);
			//System.out.println(d_result);
		}

		//after comma

		if ((fixed_number.length() - c_index - 1) % 2 != 0) {
			d_packs_r = (fixed_number.length() - c_index - 1) / 2 + 1;
		} else {
			d_packs_r = (fixed_number.length() - c_index - 1) / 2;
		}
		//System.out.println(d_packs_r);
		for (int r = 0; r < d_packs_r; r++) {
			minuend = Integer.valueOf(d_result + d_packs[number_d_pack]);
			d_minuend = minuend;
			start_subtrahend = Integer.valueOf(String.valueOf(Integer.valueOf(result) * 2) + "1");
			subtrahend = 0;
			d_result = minuend;
			round = 0;

			while (d_result >= 0) {
				subtrahend = subtrahend + start_subtrahend + 2 * round;
				d_result = d_minuend - subtrahend;
				round++;
			}
			round = round - 1;
			subtrahend = subtrahend - (start_subtrahend + 2 * (round));
			d_result = minuend - subtrahend;
			result = result + String.valueOf(round);

			//(unnecessary) just for visualization
			number_d_pack = number_d_pack + 1;

			//result = result.substring(0, c_index) + ""
		}
	}

	public static void main(String[] args) {
		// test your implementation here
		sqrt(4);
	}

}
