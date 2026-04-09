class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            int length = str.length();
            sb.append(length).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i<str.length()) {
            int lenStart = i;
            while (str.charAt(i) != '#') {
                i++; 
            }

            String lengthStr = str.substring(lenStart, i);
            System.out.println(lengthStr);
            int length = Integer.parseInt(lengthStr);

            int start = i+1;
            int end = start+length;
            result.add(str.substring(start, end));
            i = end;
        }

        return result;
    }
}
