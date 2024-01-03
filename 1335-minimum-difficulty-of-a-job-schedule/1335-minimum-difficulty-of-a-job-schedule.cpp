class Solution {
    int dynamic(vector<vector<int>>&dp,vector<int>& jobDifficulty,int&jobs,int d,int current){
        if(dp[d][current])
            return dp[d][current];
        if(d==1){
            dp[1][current]=*max_element(jobDifficulty.begin()+current,jobDifficulty.end());
            return dp[1][current];
        }
        int ans=1e9;
        int difficulty=-1e9;
        for(int i=current;i<=jobs-d;i++){
            difficulty=max(difficulty,jobDifficulty[i]);
            ans=min(ans,difficulty+dynamic(dp,jobDifficulty,jobs,d-1,i+1));
        }
        return dp[d][current]=ans;
    }
public:
    int minDifficulty(vector<int>& jobDifficulty, int d) {
        int jobs=jobDifficulty.size();
        if(jobs<d)
            return -1;
        if(accumulate(jobDifficulty.begin(),jobDifficulty.end(),0)==0)
            return 0;
        if(jobs==d)
            return accumulate(jobDifficulty.begin(),jobDifficulty.end(),0);
        vector<vector<int>>dp(d+1,vector<int>(jobs,0));
        return dynamic(dp,jobDifficulty,jobs,d,0);
        return dp[d][0];
    }
};