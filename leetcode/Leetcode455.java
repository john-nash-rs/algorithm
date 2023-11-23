class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        System.out.println(Arrays.toString(g));
        int currentChild = 0;
        int currentCookie = 0;
        int totalChildren = g.length;
        int totalCookie = s.length;
        int contentChild = 0;
        while(currentChild < totalChildren && currentCookie < totalCookie){
            int greedOfCurrentChild = g[currentChild];
            int sizeOfCurrentCookie = s[currentCookie];
            if(sizeOfCurrentCookie >= greedOfCurrentChild){
                contentChild = contentChild + 1;
                currentChild = currentChild + 1;
            }
            currentCookie = currentCookie + 1;
        }
        return contentChild;
    }
}
