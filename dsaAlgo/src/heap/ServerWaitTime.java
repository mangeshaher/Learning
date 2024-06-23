package heap;

import java.util.*;

/*
Amazon Web Services (AWS) is a cloud computing platform with multiple servers. One of the servers is assigned to serve
customer requests.
There are n customer requests placed sequentially in a queue, where the ith request has a maximum waiting time denoted
by wait[i].
That is, if the ith request is not served within wait[i] seconds, then the request expires and it is removed from the
queue. The server processes the request following the First In First Out (FIFO) principle. The 1st request is processed
 first, and the nth request is served last. At each second, the first request in the queue is processed. At the next
 second, the processed request and any expired requests are removed from the queue.

Given the maximum waiting time of each request denoted by the array wait, find the number of requests present in the
queue at every second until it is empty.

Note:

If a request is served at some time instant t, it will be counted for that instant and is removed at the next instant.
The first request is processed at time = 0. A request expires without being processed when time = wait[i]. It must be
processed while time < wait[i].
The initial queue represents all requests at time = 0 in the order they must be processed.
Function Description

Complete the function findRequestsInQueue in the editor.

findRequestsInQueue has the following parameter:

int wait[n]: the maximum waiting time of each request
Returns

int[]: the number of requests in the queue at each instant until the queue becomes empty.

Example 1:

Input: wait = [2, 2, 3, 1]
Output: [4, 2, 1, 0]
*/

public class ServerWaitTime {

    private static List<Integer> activeRequests(List<Integer> wait){
        List<Integer> retval = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        wait.forEach(q::add);

        int lastProcessed = 0;
        for(int t = 0;t<wait.size();t++){
            //checking expired requests
            while(q.size()>0 && q.peek()<=t){
                q.poll();
            }
            //storing count of requests at time t
            retval.add(q.size());
            //processing request
            for(int i = lastProcessed;i<wait.size();i++){
                if(q.contains(wait.get(i))){
                    q.remove(wait.get(i));
                    lastProcessed = i;
                    break;
                }
            }
        }
        return retval;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 1, 1, 1, 1, 7, 1, 9);
        System.out.println(activeRequests(arr).toString());
    }
}
