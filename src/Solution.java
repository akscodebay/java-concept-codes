
public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int minCandyCount = len;
        int indexPrev=-1;
        for(int i=1;i<len;i++){
            System.out.println("i-"+i);
            if(ratings[i-1]>ratings[i] && indexPrev!=i-1){
                minCandyCount++;
                indexPrev=i-1;
                System.out.println("t1-"+indexPrev);
            }
            else if(ratings[i-1]<=ratings[i] && indexPrev!=i-1){
                minCandyCount++;
                indexPrev=i;
                System.out.println("t2-"+indexPrev);
            }
        }
        return minCandyCount;
    }
    public static void main(String[] args) {
		int[] ratings = {1,2,87,87,87,2,1};
		Solution obj = new Solution();
		System.out.println(obj.candy(ratings));

    }

} 