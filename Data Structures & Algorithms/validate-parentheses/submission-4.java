class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')', '(');
        map.put(']', '[');

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return false;
                char popped = stack.pop();
                if(map.get(ch) != popped) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
