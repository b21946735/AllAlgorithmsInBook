public class runlengthencode {

    static String RLE(String bitString){
        boolean bit = false;
        String newBS="";
        bit = (bitString.charAt(0)==0) ? false : true;
        int j = 0;
        while(true){
            int count = 0;
            
            while (bit) {
                j++;
                count ++;
                if (j >= bitString.length()) {
                    for (int i = 0; i < 8-count; i++) {
                        newBS += "0";
                    }
                    newBS  += Integer.toBinaryString(count) +" ";
                    return newBS;
                }
                bit = (bitString.charAt(j)=='0') ? false : true;
            }
            for (int i = 0; i < 8-Integer.toBinaryString(count).length(); i++) {
                newBS += "0";
            }
            newBS += Integer.toBinaryString(count) +" ";
            count = 0;
            while (!bit) {
                j++;
                count ++;
                if (j >= bitString.length()) {
                    for (int i = 0; i < 8-count; i++) {
                        newBS += "0";
                    }
                    newBS  += Integer.toBinaryString(count) +" ";
                    return newBS;
                }
                bit = (bitString.charAt(j)=='0') ? false : true;
            }
            for (int i = 0; i < 8-count; i++) {
                newBS += "0";
            }
            newBS  += Integer.toBinaryString(count) +" ";
            count = 0;
        }
    }
    public static void main(String[] args) {
        String bitString = "11110101111111110011111110101";
        System.out.println(RLE(bitString));
    }
}
