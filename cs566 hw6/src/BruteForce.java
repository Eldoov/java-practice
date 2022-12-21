public class BruteForce{
	public static void main(String[] args){

		String string = "gcagtacgcagagagtatacagtacg";
		String pattern = "agtacg";
		int index = match(string, pattern);
		if (index == -1)
			System.out.println(" is not found");

		// for second pattern
		pattern = "agtagg";
		index = match(string, pattern);
		if (index == -1)
			System.out.println(pattern + " is not found");
	}

	//Return index of the matched pattern & return -1 if not found

	static int match(String string, String pattern){
		int count = -1;
		int high = string.length() - pattern.length();
		for (int i = 0; i <= high; i++){ 
			String sub = string.substring(i, i + pattern.length());
			if (sub.equals(pattern)){ 
				count = 1;
				System.out.println(pattern + " is found at index " + i);
			}
		}
		return count;
	}
}