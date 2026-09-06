class Solution {

    // plans:
    // 1. create `lookup order`
    // 2. just iterate words[], comparing word[i] and word[i+1], if word[i] > word[i+1] then false, the order of the character will refer to `lookup order`
    // 3. check if word[i].length() < word[i+1].length()

    public void buildLookupAlphabetsOrder(
        Map<Character, Integer> map,
        String order
    ) {
        for (int i = 0; i < order.length(); i++) {
            map.putIfAbsent(order.charAt(i), i);
        }
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> rank = new HashMap<>();
        // build  lookup order
        buildLookupAlphabetsOrder(rank, order);
        // compare
        for (int j = 0; j < words.length - 1; j++) {
            boolean needFurtherCheck = true;
            int minLength = Math.min(words[j].length(), words[j+1].length());
            for (int i = 0; i < minLength; i++) {
                if (
                    rank.get(words[j].charAt(i)) >
                    rank.get(words[j+1].charAt(i))
                )
                    return false;
                else if (
                    rank.get(words[j].charAt(i)) <
                    rank.get(words[j+1].charAt(i))
                ) {
                    needFurtherCheck = false;
                    break;
                }
            }
            if (needFurtherCheck && (words[j].length() > words[j+1].length())) 
                return false;
        }
        return true;
    }
}