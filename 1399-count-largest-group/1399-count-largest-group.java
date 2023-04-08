class Solution {
    public int countLargestGroup(int n) {
        int m=(int)Math.log10(n);
        int sum,k;
        int [] sumDigits = new int[m*9+(int)(n/(Math.pow(10,m)))+1];
        for(int i=1;i<=n;i++){
            k=i;
            sum=0;
            while(k>0){
                sum+=k%10;
                k/=10;
            }
            sumDigits[sum]++;
        }
        int max=0;
        int countMax=0;
        for(int i=0;i<sumDigits.length;i++){
            if(max<sumDigits[i]){
                max=sumDigits[i];
                countMax=1;
            }else if(max==sumDigits[i]){
                countMax++;
            }
        }
        return countMax;
    }
}