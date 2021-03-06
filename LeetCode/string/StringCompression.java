public class StringCompression {

    // Note that group lengths that are 10 or longer will be split into multiple
    // characters in chars.

    // modifying the input array, return the new length of the array.
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }

        // StringBuilder sb = new StringBuilder();

        // count & replace
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                count++;
            } else {
                // sb.append(chars[i]);
                if (count > 2) {
                    for (int j = i; j < chars.length - 1; j++) {
                        chars[j] = chars[j + 1];
                    }
                }
                if (count > 1) {
                    // sb.append(count);
                    chars[i] = (char) (count + '0');
                }
                count = 1;
            }
        }

        System.out.println(chars);
        // chars = sb.toString().toCharArray();
        return chars.length;
    }

    // LeetCode solution
    // Read and Write Heads(pointer)
    public int compressSol(char[] chars) {
        return 0;
    }

    // Sol from discussion.
    public int compressBestSol(char[] chars) {
        int indexAns = 0, index = 0;

        //loop all values 
        while (index < chars.length) {
            char currentChar = chars[index];
            int count = 0;

            //calculate the count
            while (index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            chars[indexAns++] = currentChar;

            //apend the number 
            if (count != 1)
                for (char c : Integer.toString(count).toCharArray())
                    chars[indexAns++] = c;
        }
        
        return indexAns;
    }

    public static void main(String[] args) {
        StringCompression sol = new StringCompression();
        char[] t1 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        char[] t2 = { 'a' };
        char[] t3 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };

        assert sol.compress(t1) == 6 : "T1 Failed";
        assert sol.compress(t2) == 1 : "T2 Failed";
        assert sol.compress(t3) == 4 : "T3 Failed";
    }
}
