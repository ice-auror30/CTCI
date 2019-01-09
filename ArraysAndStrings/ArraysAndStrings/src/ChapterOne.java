import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IceAuror
 * Solutions to Chapter 1 of CTCI
 */
public class ChapterOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println("Solutions to Chapter 1 of CTCI");
		//		String testString = "You live once, and die once. Better make it work it";
		//		String testString_1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789`-=[];',./~!@#$%^&*()_+{}|:<>?";
		//		System.out.println(isUnique(testString)? "YES": "NO");
		//		System.out.println(isUnique(testString_1)? "YES": "NO");
		//		System.out.println(checkPermutation("abcdefghijklmnopqrstuvwxyz","mnbvcxzlkjhgfdsapoiuytrewq")? "YES": "NO");
		//		System.out.println(checkPermutation("babbababa","abbaa")? "YES": "NO");
		//		System.out.println(uRLify("Mr John Smith      ".toCharArray(), 13));
		//		System.out.println(oneAway("caesar","caesa")? "YES": "NO");
		//		System.out.println(oneAway("caes","baes")? "YES": "NO");
		//		System.out.println(oneAway("daesar","caesar")? "YES": "NO");
		//		System.out.println(oneAway("baluuua","baluaaa")? "YES": "NO");
		//		System.out.println(palindromePermutaiton("Tact Coa")?"YES":"NO");
		//		System.out.println(stringCompression("aabcccccaaaaabcccccaaaaabcccccaaa"));
		//		System.out.println(stringRotation("waterbottle", "erbottlewat")?"YES":"NO");
		//		int[][]M = {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		//		int[][] rotateMatrix = new int[M.length][M.length];
		//		rotateMatrix= rotateMatrix(M);
		//		for(int i=0; i<M.length;i++){
		//			for(int j=0;j<M.length; j++){
		//				System.out.print(rotateMatrix[i][j]+ " ");
		//			}
		//			System.out.println();
		//		}
		//		int[][]M = {{1,2,1,4},{2,0,4,1},{3,4,1,2},{4,1,2,2}};
		//		int[][] zeroMatrix = new int[M.length][M.length];
		//		zeroMatrix= zeroMatrix(M);
		//		for(int i=0; i<M.length;i++){
		//			for(int j=0;j<M.length; j++){
		//				System.out.print(zeroMatrix[i][j]+ " ");
		//			}
		//			System.out.println();
		//		}
		//		int arr1[] = {1,3,5,7,9,11};
		//		int arr2[] = {2,4,6,10};
		//		mergeList(arr1, arr2);
	}

	/**
	 * @param s String input
	 * @return true/false
	 * Checks if the String has all unique characters
	 * RunTime complexity: O(LengthOfString)
	 */
	public static boolean isUnique(String s){
		s = s.toLowerCase();
		boolean allCharacters[] = new boolean[128];
		for (boolean b: allCharacters){
			b = false;
		}
		for (char c: s.toCharArray()){
			if(allCharacters[c]){
				return false;
			}
			else{
				allCharacters[c] = true;
			}
		}
		return true;
	}

	/**
	 * @param string_1 String one
	 * @param string_2 String two
	 * @return true/false
	 * Checks if string 2 is a permutation of string 1
	 * O(nlogn)
	 */
	public static boolean checkPermutation(String string_1, String string_2){
		if (string_1.length()!=string_2.length())
			return false;
		string_1 = sortString(string_1);
		string_2 = sortString(string_2);
		return (string_1.equals(string_2));
	}

	/**
	 * @param stringToBeSorted
	 * @return String with characters sorted alphabetically
	 * Accepts an unsorted string and returns the string with its characters sorted 
	 * O(nlogn)
	 */
	public static String sortString(String stringToBeSorted){
		char[] characterArray = stringToBeSorted.toCharArray();
		java.util.Arrays.sort(characterArray);
		return new String(characterArray);
	}

	/**
	 * @param stringToBeURLified
	 * @param trueLength
	 * @return string that has been URLified
	 * Returns a string after URLifying it
	 * O(n)
	 */
	public static char[] uRLify(char[] stringToBeURLified, int trueLength){
		int space_count = 0;
		int index_offset = 0;
		int stringLength = stringToBeURLified.length;
		for(int i=0; i<trueLength; i++){
			if (stringToBeURLified[i]==' ')
				space_count++;
		}
		index_offset = space_count*2+trueLength;
		for(int j=trueLength-1; j>=0; j--){
			if(stringToBeURLified[j]!= ' '){
				stringToBeURLified[index_offset-1] = stringToBeURLified[j];
				index_offset--;
			}else {
				stringToBeURLified[index_offset-1] = '0';
				stringToBeURLified[index_offset-2] = '2';
				stringToBeURLified[index_offset-3] = '%';
				index_offset = index_offset-3;
			}
		}
		return(stringToBeURLified);
	}

	/**
	 * @param string_1
	 * @param string_2
	 * @return true/false
	 * Checks if one string is only one character manipulation away 
	 * from being the same as the other string
	 * O(n)
	 */
	public static boolean oneAway(String string_1, String string_2){
		switch(checkLengthDifference(string_1, string_2)){
		case 0: return checkReplace(string_1, string_2);
		case 1: return checkRemoveOrInsert(string_1, string_2);
		case 2: return false;
		default: return false;
		}
	}

	/**
	 * @param string_1
	 * @param string_2
	 * @return the difference in length of two strings
	 * Helper method for oneAway
	 * O(1)
	 */
	public static int checkLengthDifference(String string_1, String string_2){
		return(Math.abs(string_1.length()-string_2.length()));
	}

	/**
	 * @param string_1
	 * @param string_2
	 * @return true/false
	 * checks if replacing one character in str 1 will make it equal to str2
	 * O(n)
	 */
	public static boolean checkReplace(String string_1, String string_2){
		int count = 0;
		for(int i=0; i<string_1.length(); i++){
			if(string_1.charAt(i)!=string_2.charAt(i)){
				count++;
			}
		}
		if (count > 1)
			return false;
		else
			return true;
	}

	/**
	 * @param string_1
	 * @param string_2
	 * @return true/false
	 * checks if inserting/removing one character in str_1 will make it equal to str_2
	 * O(n*O(String.contains))
	 */
	public static boolean checkRemoveOrInsert(String string_1, String string_2){
		int count = 0;
		for(char c: string_1.toCharArray()){
			if(!string_2.contains(Character.toString(c))){
				count++;
			}
		}
		if(count>1)
			return false;
		else
			return true;
	}	

	/**
	 * @param str
	 * @return true/false
	 * Checks if the input String is a permutation of a palindrome or not
	 * O(n)
	 */
	public static boolean palindromePermutation(String str){
		str = str.toLowerCase();
		HashMap<Character, Integer> charFreq= new HashMap<Character, Integer>();
		for (int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			if(str.charAt(i)!=' '){
				if(charFreq.containsKey(ch)){
					System.out.print(ch);
					int count = charFreq.get(ch);
					charFreq.replace(ch, ++count);
				}else{
					System.out.print(ch);
					charFreq.put(ch, 1);
				}
			}
		}
		int odd_characters=0;
		for(int count: charFreq.values()){
			System.out.print(count);
			if(count%2 == 1){
				odd_characters++;
			}
		}
		if(odd_characters>1)
			return false;
		return true;
	}

	/**
	 * @param str
	 * @return String
	 * Returns either a compressed string or the original string whichever is shorter
	 * O(n)
	 */
	public static String stringCompression(String str){
		str=str+" ";
		String compressedString = "";
		int charCount=1;
		for(int i =0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				charCount++;
			}else{
				compressedString = compressedString + str.charAt(i)+charCount;
				charCount = 1;
			}
		}
		return ((str.length()-1 > compressedString.length())? compressedString : str.substring(0, str.length()-1));
	}

	/**
	 * @param s1
	 * @param s2
	 * @return true/false
	 * Return if s2 is a rotation of s1 or not
	 * O(1) * O(isSubstring)
	 */
	public static boolean stringRotation(String s1, String s2){
		System.out.println(s1.length() + " " + s2.length());
		if(s1.length()!=s2.length())
			return false;
		String s1s1 = s1+s1;
		return (isSubstring(s1s1, s2));
	}

	/**
	 * @param s1
	 * @param s2
	 * @return true/false
	 * Return if s2 is a substring of s1
	 * O(s1-s2*O(substring))
	 */
	public static boolean isSubstring(String s1, String s2){
		for(int i=0;i<s1.length()-s2.length(); i++){
			System.out.println(s1.substring(i, s2.length()));
			System.out.println(s2);
			System.out.println("---***---");
			if(s1.substring(i, i+s2.length()).equalsIgnoreCase(s2)){
				return true;
			}
		}
		return false;
	}

	/**
	 * @param M
	 * @return rotateMatrix
	 * accepts a 2D array, returns the
	 * array after rotating its contents by 90 degrees
	 * O(n*n)
	 */
	public static int[][] rotateMatrix(int[][] M){
		int N = M.length;
		int[][] rotateMatrix = new int[N][N];
		for(int i=N-1; i>=0;i--){
			for(int j=0;j<N; j++){
				rotateMatrix[j][N-1-i] = M[i][j];
			}
		}		
		return rotateMatrix;
	}

	/**
	 * @param M
	 * @return the Zero Matrix
	 * Convert the row/column of the array to all 0's if one element has 0
	 * O(n*n)
	 */
	public static int[][] zeroMatrix(int[][]M){
		int N = M.length;
		ArrayList<Integer> row_index= new ArrayList<>();
		ArrayList<Integer> column_index= new ArrayList<>();

		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(M[i][j] == 0){
					if(!row_index.contains(i)){
						row_index.add(i);
					}
					if(!column_index.contains(j)){
						column_index.add(j);
					}
				}
			}
		}

		for(int i=0;i<row_index.size();i++){
			for(int j=0;j<N;j++){
				M[row_index.get(i)][j] = 0;
			}
			for(int k=0;k<N;k++){
				M[k][column_index.get(i)] = 0;
			}
		}

		return M;
	}

	public static void mergeList(int[] arr1, int[] arr2){
		int size_arr1 = arr1.length;
		int size_arr2 = arr2.length;
		int merge_arr[] = new int[size_arr1+size_arr2];
		int a1 = 0;
		int a2 = 0;
		int merge_counter = 0;	
		for(int i=0;i< size_arr1+size_arr2; i++){
			merge_counter = i;
			if(arr1[a1]<arr2[a2]){
				merge_arr[i] = arr1[a1];
				System.out.println(merge_arr[i]);
				a1=a1+1;
				if(a1>=size_arr1)
					break;
			}
			else{
				merge_arr[i]= arr2[a2];
				System.out.println(merge_arr[i]);
				a2=a2+1;
				if(a2>=size_arr2)
					break;
			}	
		}
		merge_counter = merge_counter+1;	

		if(a1==size_arr1){
			for(int j=a2;j<size_arr2;j++){
				merge_arr[merge_counter] = arr2[j];
				++merge_counter;
			}
		}else {
			for(int j=a1;j<size_arr1;j++){
				merge_arr[merge_counter] = arr1[j];
				++merge_counter;				
			}
			for(int i=0;i<merge_arr.length;i++){
				System.out.println(merge_arr[i]);
			}
		}
	}
}