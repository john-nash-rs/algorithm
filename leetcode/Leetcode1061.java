class Solution 
{
    public String smallestEquivalentString(String s1, String s2, String baseStr) 
    {
        int[] graph = new int[26];
        for(int i = 0; i < 26; i++) 
            graph[i] = i;
            
        for(int i = 0; i < s1.length(); i++) 
        {
            int first = s1.charAt(i) - 'a';
            int second = s2.charAt(i) - 'a';
            int rootFirst = find(graph, first);
            int rootSecond = find(graph, second);
            if(rootFirst < rootSecond) 
            {
                graph[rootSecond] = rootFirst;
            } 
            else 
            {
                graph[rootFirst] = rootSecond;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++) 
        {
            char ch = baseStr.charAt(i);
            sb.append((char)('a' + find(graph, ch - 'a')));
        }
        return sb.toString();
    }
    
    private int find(int[] graph, int index) 
    {
        while(graph[index] != index) 
        {
            index = graph[index];
        }
        return index;
    }
}
