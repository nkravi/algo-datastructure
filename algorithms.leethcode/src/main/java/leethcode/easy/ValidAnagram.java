package leethcode.easy;


import java.util.Arrays;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		char s1[] = s.toCharArray();
		char s2[] = t.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		return Arrays.toString(s1).equals(Arrays.toString(s2));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidAnagram().isAnagram("", ""));

	}

}
