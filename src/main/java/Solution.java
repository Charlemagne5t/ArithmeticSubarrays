import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            result.add( isArithmetic(nums, l[i], r[i]));
        }
        return result;
    }

    private boolean isArithmetic(int[] nums, int l, int r){
        if(r - l <= 1 ){
            return true;
        }
        PriorityQueue<Integer> sub = new PriorityQueue<>();
        for(int i = l; i <=r; i++){
            sub.add(nums[i]);
        }
        int start = sub.poll();
        int next = sub.poll();
        int dif = start - next;
        while(!sub.isEmpty()){
            start = next;
            next = sub.poll();
            if(start - next != dif){
                return false;
            }
        }
        return true;


    }
}

