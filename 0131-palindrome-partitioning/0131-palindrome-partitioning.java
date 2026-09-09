class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        int start = 0;
        backtrack(s, result, current, start);

        return result;
    }

    void backtrack(String s, List<List<String>> result,
                   List<String> current, int start) {

        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {

            String part = s.substring(start, i + 1);

            if (isPalindrome(part)) {
                current.add(part);

                backtrack(s, result, current, i + 1);

                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}