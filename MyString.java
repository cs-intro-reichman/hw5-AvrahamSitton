/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        String abcdefgh = "abcdefgh";
        String abcd = "abcd";
        String efgh = "efgh";
        String a2b5 = "aabbbbb";
        String b5 = "bbbbb";
        /*
         * System.out.println(countChar(hello, 'h'));
         * System.out.println(countChar(hello, 'l'));
         * System.out.println(countChar(hello, 'z'));
         * System.out.println(countChar(a2b5, 'a'));
         * System.out.println(countChar(a2b5, 'b'));
         * System.out.println(spacedString(hello));
         * System.out.println(randomNumInReang(1, 2));
         * System.out.println(randomNumInReang(32, 76666));
         * System.out.println(randomNumInReang(32, 77));
         * System.out.println(randomNumInReang(32, 100));
         * System.out.println(randomNumInReang(32, 88));
         * System.out.println(randomNumInReang(32, 123));
         * System.out.println(randomNumInReang(1, 76666));
         * System.out.println(randomNumInReang(3762, 76666));
         * System.out.println(randomNumInReang(3662, 76666));
         * System.out.println(randomNumInReang(3666662, 3666660));
         * System.out.println(randomNumInReang(366666, 0));
         * System.out.println(randomNumInReang(32, 32));
         * System.out.println(subsetOf(hello, hello));
         * System.out.println(subsetOf(a2b5, b5));
         * System.out.println(subsetOf(b5, b5));
         * System.out.println(subsetOf(b5, a2b5));
         * System.out.println(spacedString("fgh  slkg  fghjdf   dgjhdf"));
         * System.out.println(randomStringOfLetters(4));
         * System.out.println(randomStringOfLetters(4455));
         */
        System.out.println(remove("committee", "meet"));
        System.out.println(remove("wqreytiupo", "erio"));
        System.out.println(remove("zmxnvbfghds", "gadfsn"));
        System.out.println(remove("xcZJ<VBn", "xfvnkj"));

        System.out.println(remove("committee", "sgauwskgudfjc"));
        System.out.println(insertRandomly('t', b5));
        System.out.println(insertRandomly('m', hello));
        /*
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         * System.out.println();
         */
    }

    public static int randomNumInReang(int x, int y) {
        int high = x > y ? x : y;
        int low = x < y ? x : y;
        int randomly = (int) ((Math.random()) * (high - low + 1)) + low;
        return randomly;
    }

    public static int indexAt(String str, char ch) {
        int result = -1;
        for (int i = 0; i < str.length(); i++) {
            if (ch == str.charAt(i))
                return i;
        }
        return result;
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c')
     * returns 0.
     * 
     * @param str - a string
     * @param c   - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int cunt = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == ch)
                cunt++;
        }
        return cunt;
    }

    /**
     * Returns true if str1 is a subset string str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns false
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1.length() > str2.length()) {
            return false;

        }
        if (str1.length() == 0)
            return true;
        for (int i = 0; i < str1.length(); i++) {
            if (countChar(str1, str1.charAt(i)) <= countChar(str2, str1.charAt(i)))
                continue;
            else
                return false;

        }

        return true;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String reString = new String();
        if (str.length() == 0)
            return str;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                reString += str.charAt(i);
            if (i != str.length() - 1)
                reString += ' ';
        }
        return reString;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomStr = new String();
        while (n > 0) {
            char ch = (char) (randomNumInReang('a', 'z'));
            randomStr += ch;
            n--;

        }
        return randomStr;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in
     * the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        if (str1.length() == 0)
            return str1;

        boolean[] str11 = new boolean[str1.length()];
        for (int i = 0; i < str11.length; i++)
            str11[i] = false;

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) == str2.charAt(i)) {
                    if (!str11[j])
                        str11[j] = true;
                    break;
                }

            }
        }
        String reString = new String();
        for (int i = 0; i < str1.length(); i++) {
            if (!str11[i]) {
                reString += str1.charAt(i);
            }

        }

        return reString;

    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or
     * "cast", or "cats".
     * 
     * @param ch  - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
        // Generate a random index between 0 and str.length()
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        // Insert the character at the random index
        String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
        return result;
    }
}
/*
 * public class MyString {
 * public static void main(String args[]) {
 * System.out.println(MyString.subsetOf("sap", "space"));
 * System.out.println(MyString.subsetOf("spa", "space"));
 * System.out.println(MyString.subsetOf("pass", "space"));
 * System.out.println(MyString.subsetOf("c", "space"));
 * System.out.println("..." + MyString.spacedString("foobar") + "...");
 * System.out.println(MyString.randomStringOfLetters(3));
 * // Put more tests of your own here.
 * }
 * 
 * 
 * Returns the number of times the given character appears in the given string.
 * 
 * @param str - a string
 * 
 * @param c - a character
 * 
 * @return the number of times c appears in str
 * 
 * public static int countChar(String str, char c) {
 * int cunt = 0;
 * for (int i = 0; i < str.length(); i++) {
 * char temp = str.charAt(i);
 * if (temp == c)
 * cunt++;
 * }
 * return cunt;
 * }
 */
/*
 * Returns true if str1 is a subset string str2, false otherwise.
 * For example, "spa" is a subset of "space", and "pass" is not
 * a subset of "space".
 *
 * @param str1 - a string
 * 
 * @param str2 - a string
 * 
 * @return true is str1 is a subset of str2, false otherwise
 * 
 * public static boolean subsetOf(String str1, String str2) {
 * int temp = 0;
 * if (str1.length() > str2.length() || str1.length() == 0) {
 * return false;
 * 
 * }
 * while (temp < str2.length()) {
 * for (int i = temp; i < str2.length(); i++) {
 * if (str2.charAt(i) != str1.charAt(i))
 * temp++;
 * break;
 * 
 * }
 * if (temp > (str2.length() - str1.length()))
 * return false;
 * 
 * }
 * 
 * return true;
 * }
 */
/*
 * Returns a string which is the same as the given string, with a space
 * character inserted after each character in the given string, except
 * for last character of the string, that has no space after it.
 * Example: if str is "silent", returns "s i l e n t".
 * 
 * @param str - a string
 * 
 * @return a string consisting of the characters of str, separated by spaces.
 * 
 * public static String spacedString(String str) {
 * String reString = new String();
 * if (str.length() == 0)
 * return str;
 * for (int i = 0; i < str.length(); i++) {
 * if (str.charAt(i) != ' ')
 * reString += str.charAt(i);
 * if (i != str.length() - 1)
 * reString += ' ';
 * }
 * return reString;
 * }
 * 
 * public static int randomNumInReang(int x, int y) {
 * int randomly = (int) Math.random() * x + y;
 * return randomly;
 * }
 */

/*
 * Returns a string of n lowercase letters, selected randomly from
 * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
 * letter can be selected more than once.
 * 
 * @param n - the number of letter to select
 * 
 * @return a randomly generated string, consisting of 'n' lowercase letters
 * 
 * public static String randomStringOfLetters(int n) {
 * String randomStr = new String();
 * while (n > 0) {
 * char ch = (char) (randomNumInReang('a', 'z'));
 * randomStr += ch;
 * n--;
 * 
 * }
 * return randomStr;
 * }
 */
/*
 * Returns a string consisting of the string str1, minus all the characters in
 * the
 * string str2. Assumes (without checking) that str2 is a subset of str1.
 * Example: "committee" minus "meet" returns "comit".
 * 
 * @param str1 - a string
 * 
 * @param str2 - a string
 * 
 * @return a string consisting of str1 minus all the characters of str2
 * 
 * public static String remove(String str1, String str2) {
 * if (str1.length() == 0)
 * return str1;
 * String remove = new String();
 * for (int i = 0; i < str1.length(); i++) {
 * char ch = str1.charAt(i);
 * if (countChar(str2, ch) == 0)
 * remove += ch;
 * }
 * return remove;
 * }
 * }
 */
