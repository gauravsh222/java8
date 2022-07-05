package dsabyfraz;

/**
  Majority element is element which occurs more than n/2 time in array
 */

public class MajorityElementInArray {

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,2,2,4,2};
        int[] arr = new int[]{1,2,3,6,7,4,2};

        // Using frequency count in map
        findUsingFrequencyCount(arr);

        // Using Moore's Voting algorithm
        System.out.println(findUsingMooresVotingAlgorithm(arr));

    }

    /**
     Iterate over array elements and keep variable as follows,
     -->Candidate = element
     -->Voting = (This value will be decided based on below conditions),
     1. If same element comes in next iteration then increase vote++
     2. If different element comes in next iteration then decrese current voting value vote--
     3. If vote becomes 0 i.e. vote=0, then change candidate to current element

     ==> If majority element really exist then at last candidate variable will hold the majority element.

     */

    private static int findUsingMooresVotingAlgorithm(int[] arr) {
        int candidate = arr[0];
        int vote = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candidate) {
                vote++;
            } else {
                vote--;
            }
            if (vote == 0) {
                candidate = arr[i];
                vote = 1;
            }
        }
        // verify if candidate value is really the majority element,
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candidate) {
                count++;
            }
        }
        if(count > arr.length/2)
            return candidate;
        return -1;
    }

    /**
     count frequency of each element in hash map then iterate over map and find which element has frequency more than n/2 times.
     */
    private static int findUsingFrequencyCount(int[] arr) {
        return 0;
    }




}
