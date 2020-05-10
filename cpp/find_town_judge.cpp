#include<unordered_map>
#include<set>

class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        
        if(N==1){
            return 1;
        }
        std::unordered_map<int,int> trust_map;
        std::set<int> trusters;
        
        
        for(auto it = trust.begin(); it != trust.end(); ++it){
            std::vector<int> temp = *it;
             if(trust_map.find(temp[1]) == trust_map.end()){
                    trust_map[temp[1]]= 0;
              }
            trusters.insert(temp[0]);
            trust_map[temp[1]]+= 1;
            
        }
        
        for(auto it = trust_map.begin(); it != trust_map.end(); it++){
            if(it->second == N-1){
                if(trusters.find(it->first) == trusters.end()){
                    return it->first;
            }
            }
        }
        
        return -1;
    }
};