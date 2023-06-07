//package day1;
import java.util.*;
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
    
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        for(int i = 0; i <numRows; i++){
            List<Integer> arr = new ArrayList<Integer>();
            for(int j =0 ; j <i+1; j++){
                if(j == 0 || j == i){
                    arr.add(j,1);
                }else{
                    arr.add(j, 
                                pascal.get(i-1).get(j-1) +
                                pascal.get(i-1).get(j)
                           );
                }
            }
            pascal.add(arr);   
        }
        return pascal;
        
    }
}
