# Jellybeans: Michael R., Manahal T., Jackie W.
##Quick Sort Runtime Classifications

####Run Time Classifications:
#####Best Case: O(nlogn)
#####Average Case: O(nlogn)
#####Worst Case: O(n^2)


####What Constitutes the Best Case:
#####The best case would be one in which the array is always being split into half. Hence, the array would always be partitioned evenly. In the end the partitioned arrays would be as evenly balanced out as possible. First off an array of size n will have n comparisons done. Then when it is partitioned, then n comparisons are done for 2 arrays of size n/2. N comparisons are done again when we have four subarrays of size n/4. Hence the arrays are split with a runtime of O(logn) and then O(n) comparisons are done so the runtime is O(nlogn).

####What Constitutes the Worst Case:
#####The worst case would be an array sorted in reverse order with the first or last index of the array used as the pivot point always. This means that the array will always decrease by 1 after being partitioned. There will be n comparisons first, followed by n-1, then n-2, and so on. Eventually when added together this means that the runtime is O(n^2).

####What Constitutes the Average Case:

