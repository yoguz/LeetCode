#include<map>
#include<string>

class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        std::map<char, int> word_count;
        
        for(int i = 0; i < magazine.size(); i++ ){
            if(word_count.find(magazine[i]) == word_count.end()){
                word_count[magazine[i]] = 0;
            }
            
            word_count[magazine[i]] += 1;
        }
        
        for(int i = 0; i < ransomNote.size(); ++i){
            
            if(word_count[ransomNote[i]] == 0){
                return false;
            }
            
            word_count[ransomNote[i]] -= 1;
        }
        
        return true;
        
        
    }
};