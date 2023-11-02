class Solution {
    int winner=0;
    public int findTheWinner(int n, int k) {
        int index=0;
        k--;
        int temp;
        List<Integer> person = new LinkedList<Integer>();
        int i;
        for(i=1;i<=n;i++)
        {
            person.add(i);
        }
        findWinner(person,k,index);
        return winner;
    }
    public void findWinner(List<Integer> person,int k,int index)
    {
        if(person.size()==1)
        {
            winner=person.get(0);
            return ;
        }
        index = ((index+k)%person.size());
        person.remove(index);
        findWinner(person,k,index);

    }
}