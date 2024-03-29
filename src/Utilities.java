package src;
import java.math.BigInteger;
import java.util.ArrayList;


/**
 * This class contains global variables used
 * across the program
 *
 */
public class Utilities {


	public static double DAY_WEIGHT = 2.5;
	public static double CONF_WEIGHT = 2;
	public static double SESS_WEIGHT = 1.5;
	public static int PAPR_WEIGHT = 1;
	public static int THEM_WEIGHT = 1;

	public static int MAX_ITERATIONS = 200;
	public static double CROSSING_RATIO = 0.5;
	
	public static int DURATION = 3;
	public static int NUM_PERIODS = 4;
	
	public static int PRESENTER = 2; 
	public static int AUTHORS = 2; 
	
	public static int AUTHORS_DATABASE_SIZE = 50; 
	public static int THEME_DATABASE_SIZE = 50;
	
	public static int SESSION_THEME = 2; 
	public static int THEME = 2;
	
	public static int AUTHORS_BITS = (int) Math.ceil( Math.log10(AUTHORS) / Math.log10(2.) );
	public static int PRESENTER_BITS = (int) Math.ceil( Math.log10(PRESENTER) / Math.log10(2.) );
	public static int THEME_BITS = (int) Math.ceil( Math.log10(THEME) / Math.log10(2.) ); 
	public static int SESSION_THEME_BITS = (int) Math.ceil( Math.log10(SESSION_THEME) / Math.log10(2.) ); 
	
	
	public static int AUTHORS_PER_PAPER = 2;
	public static int THEMES_PER_PAPER = 1; //maximum number of themes on a paper
	public static int SESSIONS_PER_PERIOD = 1; //number of sessions at the same time
	public static int PAPERS_PER_SESSION = 2; //number of papers in 1 session, the max is 2fullpapers+3shortpapers = 5

	public static int DAYS; 
	public static int DAYSBITS; 
	
	public static SELECTION selection_t;

	public static int POPULATION_SIZE;
	public static int ELITIST_NUMBER;
	
	public static double MUTATION_PROB = 0.01;
	public static double PAIRING_PROB = 0.25;

	/**
	 * Transforms a number to binary in string format
	 * 
	 * @param number
	 *            number to be transformed
	 * @param size
	 *            size of number in binary
	 * @return binary number as a string
	 */
	public static String transform2Bin(int number, int size) {
		return normalize(decToBin(number), size);
	}

	/**
	 * Concatenates 0s to the left of the string to have the desired length
	 * 
	 * @param word
	 *            string to be concatenated
	 * @param length
	 *            desired size
	 * @return string concatenated
	 */
	public static String normalize(String word, int length) {
		int size = length - word.length();

		if (size < 0) {
			System.out.println("Algo de errado n esta certo");
		}

		while (size > 0) {
			size--;
			word = "0".concat(word);
		}

		return word;
	}

	/**
	 * Converts a string on decimal format to binary
	 * 
	 * @param s
	 *            string
	 * @return string in binary
	 */
	public static String decToBin(String s) {
		return new BigInteger(s, 10).toString(2);
	}

	/**
	 * Converts a number on decimal format to binary
	 * 
	 * @param i
	 * @return string in binary
	 */
	public static String decToBin(int i) {
		String s = String.valueOf(i);
		return new BigInteger(s, 10).toString(2);
	}

	/**
	 * Converts a number on binary format to decimal
	 * 
	 * @param i
	 * @return string in binary
	 */
	public static String binToDec(String s) {
		return new BigInteger(s, 2).toString(10);
	}

	/**
	 * Returns the size of a session on a cromossome
	 * 
	 * @return Session size
	 */
	public static int getSessionCount() {
		// Periodo (manhã, tarde...)
		int PERIOD = 2;
		return PERIOD + THEME + DURATION + getPaperSize() * PAPERS_PER_SESSION;
	}

	/**
	 * Returns the size of a paper on a cromossome
	 * 
	 * @return
	 */
	public static int getPaperSize() {
		int ISFULLPAPER = 1;
		// 4 4
		return (PRESENTER + AUTHORS * AUTHORS_PER_PAPER) + (THEME * THEMES_PER_PAPER) + ISFULLPAPER;
	}

	/**
	 * Returns the size of a cromossome
	 * 
	 * @return
	 */
	public static int getCromossomeSize() {
		int cromossomePaper = (DAYS * DAYSBITS) + DAYS * (SESSIONS_PER_PERIOD * getSessionCount());
		// System.out.println("Cromossome size: " + cromossomePaper);
		return cromossomePaper;
	}

	/**
	 * Calculates the discrepancy between representations
	 * 
	 * @param representations
	 *            Representations to be calculated
	 * @return Difference between the max value and the min value
	 */
	public static int calculateRepresentation(ArrayList<Integer> representations) {

		int min = representations.get(0);
		int max = min;
		int size = representations.size();
		for (int i = 0; i < size; i++) {

			int value = representations.get(i);
			if (min > value)
				min = value;
			if (max < value)
				max = value;
		}
		return max - min;
	}

	/**
	 * Verifies if string contains only numbers
	 * @param str
	 * @return
	 */
	public static boolean containsOnlyNumbers(String str) {
		for (int i = 0; i < str.length(); i++) 
			if (!Character.isDigit(str.charAt(i))) 
				return false;		
		
		return true;
	}
}
