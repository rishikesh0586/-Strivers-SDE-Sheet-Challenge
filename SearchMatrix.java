class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length - 1;
        int a = 0;
       for(int i = 0; i < matrix.length; i++)
       {       if(matrix[i][n] > target)
       {
                a = i;
               break;
       }   
       else if(matrix[i][n] == target)
       {
           return true;
       }
       }

       int start = 0;
       int end = n;
     
        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(matrix[a][mid] == target)
            {
                return true;
            }
            else if(matrix[a][mid] > target)
            {
                end = mid - 1;
                
            }
            else if(matrix[a][mid] < target)
            {
                start = mid + 1;
                
            }
        }

        return false;
    }
}