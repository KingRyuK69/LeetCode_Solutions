class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        Set<Integer> freqSet = new HashSet<>();
        int count = 0;

        for (int freq : chars.values()) {
            while (freq > 0 && freqSet.contains(freq)) {
                freq--;
                count++;
            }
            freqSet.add(freq);
        }

        return count;        
    }
}