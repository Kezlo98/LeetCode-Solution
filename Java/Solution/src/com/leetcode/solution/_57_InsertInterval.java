package src.com.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class _57_InsertInterval {

    /*
        You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

        Return intervals after the insertion.



        Example 1:

        Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
        Output: [[1,5],[6,9]]
        Example 2:

        Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        Output: [[1,2],[3,10],[12,16]]
        Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


        Constraints:

        0 <= intervals.length <= 104
        intervals[i].length == 2
        0 <= starti <= endi <= 105
        intervals is sorted by starti in ascending order.
        newInterval.length == 2
        0 <= start <= end <= 105
     */

    public static void main(String[] args) {
        int[][] intervals = {{2,5}, {6,7}, {8,9}};
        int[] newIntervals = {0,1};
        int[][] result = insert(intervals, newIntervals);

        System.out.println("Result: ");
        for (int[] interval: result){
            System.out.print("[" + interval[0] + "," + interval[1] + "]");
            System.out.print("  ");
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            int[][] result = new int[1][];
            result[0] = newInterval;
            return result;
        }
        List<int[]> resultList = new ArrayList<>();
        int count = 0;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        for (int[] interval : intervals){
            if(newStart > interval[1]){
                resultList.add(interval);
                count++;
            } else {
                newStart = Math.min(newStart,interval[0]);
                count++;
                if (newEnd < interval[0]){
                    int[] nextInterval = {newStart, newEnd};
                    resultList.add(nextInterval);
                    break;
                } else if(newEnd <= interval[1]){
                    int[] nextInterval = {newStart, interval[1]};
                    resultList.add(nextInterval);
                    break;
                }
            }
        }

        while (count < intervals.length){
            if(newEnd < intervals[count-1][0]){
                count -- ;
            }
            resultList.add(intervals[count]);
            newEnd = intervals[count][1];
            count++;
        }

        if(intervals[count - 1][0] > newEnd){
            resultList.add(intervals[count-1]);
        }

        if(intervals[count - 1][1] < newEnd){
            int[] nextInterval = {newStart, newEnd};
            resultList.add(nextInterval);
        }

        return resultList.toArray(new int[0][]);
    }
}
