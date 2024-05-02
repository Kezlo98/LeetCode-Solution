package src.com.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _981_TimeBasedKeyValueStore {

    /*
    Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

    Implement the TimeMap class:

    TimeMap() Initializes the object of the data structure.
    void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
    String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".


    Example 1:

    Input
    ["TimeMap", "set", "get", "get", "set", "get", "get"]
    [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
    Output
    [null, null, "bar", "bar", null, "bar2", "bar2"]

    Explanation
    TimeMap timeMap = new TimeMap();
    timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
    timeMap.get("foo", 1);         // return "bar"
    timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
    timeMap.get("foo", 4);         // return "bar2"
    timeMap.get("foo", 5);         // return "bar2"


    Constraints:

    1 <= key.length, value.length <= 100
    key and value consist of lowercase English letters and digits.
    1 <= timestamp <= 107
    All the timestamps timestamp of set are strictly increasing.
    At most 2 * 105 calls will be made to set and get.
     */


    /*
        Solution:
            2 Way to implement which their own Pros and Cons:
                - 1 Map<String, List<Map<Integer,String>> keyTimeValue. Get Key, loop through List to find Value with timeStamp
                    * Pros: Memory
                    * Cons: Time
                - 2 Map:
                    Map<String, Map<Integer, String>> keyTimeValueMap; => store value
                    Map<String, List<Integer>> keyTimeMap; => store list of timestamp refer with key. Can find lowerNearest Index here

                    * Pros: Time
                    * Cons: Memory
     */
    public static void main(String[] args) {
        try {
            TimeMap timeMap = new TimeMap();
            timeMap.set("love", "high", 10);
            timeMap.set("love", "low", 20);
            System.out.printf("\nKey love, Timestamp: 5 " + timeMap.get("love", 5));
            System.out.printf("\nKey love, Timestamp: 10 " + timeMap.get("love", 10));
            System.out.printf("\nKey love, Timestamp: 15 " + timeMap.get("love", 15));
            System.out.printf("\nKey love, Timestamp: 20 " + timeMap.get("love", 20));
            System.out.printf("\nKey love, Timestamp: 25 " + timeMap.get("love", 25));
        }catch (Exception exception){
            System.out.printf("\n Shit, it broke !!\n");
            exception.printStackTrace();
        }
    }

    static class TimeMap {

        Map<String, Map<Integer, String>> keyTimeValueMap;
        Map<String, List<Integer>> keyTimeMap;

        public TimeMap() {
            keyTimeValueMap = new HashMap<>();
            keyTimeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!keyTimeValueMap.containsKey(key)) {
                Map<Integer, String> timeValueMap = new HashMap<>();
                timeValueMap.put(timestamp, value);
                keyTimeValueMap.put(key, timeValueMap);
            } else {
                Map<Integer, String> timeValueMap = keyTimeValueMap.get(key);
                timeValueMap.put(timestamp, value);
            }

            if(!keyTimeMap.containsKey(key)){
                keyTimeMap.put(key,new ArrayList<>());
            }
            List<Integer> timeList = keyTimeMap.get(key);
            if(timeList.isEmpty()){
                timeList.add(timestamp);
                return;
            }
            int lowerNearestIndex = findLowerNearestIndex(timeList, timestamp);
            if(timeList.get(lowerNearestIndex) != timestamp){
                timeList.add(lowerNearestIndex+1,timestamp);
            }
        }

        public String get(String key, int timestamp) {
            if(!keyTimeValueMap.containsKey(key)){
                return null;
            }

            Map<Integer, String> timeValueMap = keyTimeValueMap.get(key);
            if(timeValueMap.containsKey(timestamp)){
                return timeValueMap.get(timestamp);
            }

            List<Integer> listTime = keyTimeMap.get(key);
            int lowerNearestIndex = findLowerNearestIndex(listTime, timestamp);
            return lowerNearestIndex < 0 ? "" : timeValueMap.get(listTime.get(lowerNearestIndex));
        }

        private int findLowerNearestIndex(List<Integer> list, int target){
            int l = 0;
            int r = list.size() - 1;

            while (l <= r){
                int mid = (l + r) / 2;

                if(list.get(mid) == target){
                    return mid;
                }
                 if(list.get(mid) < target){
                     l = mid + 1;
                 } else {
                     r = mid - 1;
                 }
            }

            return l - 1;
        }
    }
}
