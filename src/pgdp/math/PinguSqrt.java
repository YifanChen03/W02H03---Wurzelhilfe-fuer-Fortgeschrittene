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
		double print_result = 0;
		String result = "";
		String fixed_number = String.format("%1.4f", n);
		String number = String.format("%1.4f", n);
		String[] d_packs;

		if (n < 0) {
			System.out.println("Keine negativen Wurzeln!");
		} else {
			System.out.println("Wurzel aus " + String.valueOf(n) + "\n");
			c_index = fixed_number.indexOf(".");
			if (fixed_number.substring(0, c_index).length() % 2 != 0) {
				number = "0" + number;
			}
			if (fixed_number.substring(c_index + 1, fixed_number.length()).length() % 2 != 0) {
				number = number + "0";
			}
			number = number.replace(".", "");

			d_packs = new String[number.length() / 2];
			for (int r = 0; r <= number.length() - 2; r = r + 2) {
				d_packs[i] = number.substring(r, r + 2);
				i++;
			}

			//start calculation
			minuend = Integer.parseInt(d_packs[number_d_pack]);
			d_minuend = minuend;
			d_result = minuend;
			start_subtrahend = 1;
			subtrahend = 0;

			print_BlockTop(minuend);

			while (d_result >= 0) {
				subtrahend = subtrahend + start_subtrahend + 2 * round;
				d_result = d_minuend - subtrahend;
				round++;
			}
			//round has to be reduced by one
			round = round - 1;
			subtrahend_printer(start_subtrahend, round);
			subtrahend = subtrahend - (start_subtrahend + 2 * (round));
			d_result = minuend - subtrahend;
			result = result + String.valueOf(round);
			number_d_pack = 1;
			print_BlockBottom(d_result, round);

			//begin second round
			if (c_index % 2 != 0) {
				d_packs_l = c_index / 2 + 1;
			} else {
				d_packs_l = c_index / 2;
			}
			for (int r = 0; r < d_packs_l - 1; r++) {
					minuend = Integer.parseInt(d_result + d_packs[number_d_pack]);
					d_minuend = minuend;
					start_subtrahend = Integer.parseInt(String.valueOf(Integer.parseInt(result) * 2) + "1");
					subtrahend = 0;
					d_result = minuend;
					round = 0;

					print_BlockTop(minuend);

					while (d_result >= 0) {
						subtrahend = subtrahend + start_subtrahend + 2 * round;
						d_result = d_minuend - subtrahend;
						round++;
					}
					round = round - 1;
					subtrahend_printer(start_subtrahend, round);
					subtrahend = subtrahend - (start_subtrahend + 2 * (round));
					d_result = minuend - subtrahend;
					result = result + String.valueOf(round);
					number_d_pack = number_d_pack + 1;
					print_BlockBottom(d_result, round);
			}
			//after comma

			if ((fixed_number.length() - c_index - 1) % 2 != 0) {
				d_packs_r = (fixed_number.length() - c_index - 1) / 2 + 1;
			} else {
				d_packs_r = (fixed_number.length() - c_index - 1) / 2;
			}

			for (int r = 0; r < d_packs_r; r++) {
				if (result.substring(d_packs_l, result.length()).length() < 2) {
					minuend = Integer.parseInt(String.valueOf(d_result) + d_packs[number_d_pack]);
					d_minuend = minuend;
					start_subtrahend = Integer.parseInt(String.valueOf(Integer.parseInt(result) * 2) + "1");
					subtrahend = 0;
					d_result = minuend;
					round = 0;
					print_BlockTop(minuend);

					while (d_result >= 0) {
						subtrahend = subtrahend + start_subtrahend + 2 * round;
						d_result = d_minuend - subtrahend;
						round++;
					}
					round = round - 1;
					subtrahend_printer(start_subtrahend, round);
					subtrahend = subtrahend - (start_subtrahend + 2 * (round));
					d_result = minuend - subtrahend;
					result = result + String.valueOf(round);
					number_d_pack = number_d_pack + 1;
					print_BlockBottom(d_result, round);
				}
			}
			//add 00 if there is still a rest
			if (result.substring(d_packs_l, result.length()).length() < 2 && d_result != 0) {
				minuend = Integer.parseInt(String.valueOf(d_result) + "00");
				d_minuend = minuend;
				start_subtrahend = Integer.parseInt(String.valueOf(Integer.parseInt(result) * 2) + "1");
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
			}


			print_result = Double.parseDouble(result.substring(0, d_packs_l) + "." + result.substring(d_packs_l, result.length()));
			result = String.valueOf(print_result);
			System.out.println("Ergebnis: " + result);
		}
	}

	public static void print_BlockTop(int p_minuend) {
		System.out.println(p_minuend);
		System.out.println("--------");
	}

	public static void subtrahend_printer(int s_subtrahend, int r) {
		for (int i = 0; i < r; i++) {
			System.out.println("-" + (s_subtrahend + 2 * i));
		}
	}

	public static void print_BlockBottom(int rest, int digit) {
		System.out.println("--------");
		System.out.println("Rest: " + rest);
		System.out.println("neue Ergebnis Ziffer: " + digit + "\n");
	}

	public static void main(String[] args) {
		// test your implementation here
		//sqrt(101);
		//sqrt(1049.76);

		//sqrt(2147483647); //(erledigt) funktioniert nicht! weil Java String format

		//sqrt(101.231);
		//sqrt(-1);

		//sqrt(0); //idk ob das so passt

		//sqrt(4);

		//sqrt(0.00123); //(erledigt) nur bis 4. Stelle, aber volle Zahl ausgeben

		//sqrt(0.0004); //(erledigt) Ausgabe nur bis 2. Nachkommastelle

		//sqrt(-2147483648);

		//just to update code
	}

}
