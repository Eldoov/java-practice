public class KMP{
	public static void main(String[] args){

		String string = "gcagtacgcagagagtatacagtacg";
		String pattern = "agtacg";
		int index = matchKMP(string, pattern);
		if (index == -1)
			System.out.println(" is not Found");

		// for second pattern
		pattern = "agtagg";
		index = matchKMP(string, pattern);
		if (index == -1)
			System.out.println(pattern + " is not Found");
	}


	static void preprocess(String pattern, int M, int[] index){
		
		int num = 0, i = 1;
		index[0] = 0; 

		while (i < M){
			if (pattern.charAt(i) == pattern.charAt(num)){
				num++;
				index[i] = num;
				i++;
			}else{ 
				if (num != 0)
					num = index[num - 1];
				else{
					index[i] = num;
					i++;
				}
			}
		}
	}

	static int matchKMP(String string, String pattern){

		int count = -1;
		int M = pattern.length();
		int N = string.length();
		int index[] = new int[M];
		int j = 0; 

		preprocess(pattern, M, index);
		
		int i = 0; 
		while (i < N){
			if (pattern.charAt(j) == string.charAt(i)){
				j++;
				i++;
			}
			if (j == M){
				count = 1;
				System.out.println(pattern + " is found at index " + (i - j));
				j = index[j - 1];
			}
			else if (i < N && pattern.charAt(j) != string.charAt(i)){
				if (j != 0)
					j = index[j - 1];
				else
					i = i + 1;
			}
		}
		return count;
	}

}