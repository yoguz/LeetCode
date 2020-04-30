class Solution:
    def sortColors(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        index = 0
        for i in range(0,len(nums)):
            if nums[i]==1:
                index = i
                break
        temp = nums[0]
        
        nums[0] = nums[index]
        
        nums[index] = temp
        
        lo = 0
        i = lo + 1
        gt = len(nums)-1
        pivot = nums[lo]
        while i <= gt:
            if nums[i] < pivot:
                temp = nums[i]
                nums[i] = nums[lo]
                nums[lo] = temp
                lo += 1
                i += 1
            elif nums[i] > pivot:
                nums[i], nums[gt] = nums[gt], nums[i]
                gt -= 1
                
            else:
                i+=1
                
            
        
            
        
        
        
if __name__ == "__main__":
    arr = [2,0,2,1,1,0]

    s = Solution()
    s.sortColors(arr)

    print(arr)

