# Jellybeans: Michael R., Manahal T., Jackie W.
##Quick Sort Runtime Classifications

###Run Time Classifications:
#####Best Case: O(nlogn)
#####Average Case: O(nlogn)
#####Worst Case: O(n^2)


###What Constitutes the Best Case:
#####The best case would be one in which the array is always being split into half. Hence, the array would always be partitioned evenly. In the end the partitioned arrays would be as evenly balanced out as possible. First off an array of size n will have n comparisons done. Then when it is partitioned, then n comparisons are done for 2 arrays of size n/2. N comparisons are done again when we have four subarrays of size n/4. Hence the arrays are split with a runtime of O(logn) and then O(n) comparisons are done so the runtime is O(nlogn).

###What Constitutes the Worst Case:
#####The worst case would be an array sorted in reverse order with the first or last index of the array used as the pivot point always. This means that the array will always decrease by 1 after being partitioned. There will be n comparisons first, followed by n-1, then n-2, and so on. Eventually when added together this means that the runtime is O(n^2).

###What Constitutes the Average Case:
#####The average case occurs the most often if the values of the array are in a random order. In our code, we chose the value at the middle of the array to be our pivot point. With each pass of the array through quickSort, the array will split between the numbers less than the pivot value and the numbers greater than the pivot value, which the array into two subarrays, but unlike in the best case, the two subarrays aren't always of length n/2. However, more than likely, the subarrays will split roughly evenly, depending on the pivot value. Within each array, N comparisions are done again to the new pivot points within the subarray. The splitting of the array into subarrays is O(logn) and there are n comparisions being made, which have a O(n) runtime. Therefore, the general/ average runtime of QuickSort is (nlogn);

###How We Tested Run Time:
#####We tested the runtimes by running our algorithm and checking for time within the terminal using time or Measure-Command{....} in the case of Windows Powershell. When checking for the best and average case we presumed that the runtime would be the same. This is because the average case was an array of random integers and our algo used pivot point as the middle and in the best case the pivot point would always be the middle index. For this reason we said that the run time of the average and best case should be the same. We tested the run time on arrays of size 1, 10, 100, 1000, and 10000.

#####In the case of the worst case, in our algo we accounted for picking the first index always as pivot point in a reverse sorted array. We also tested this in the terminal. In order to test for the worst case, we had to modify our algo so that the pivot point would always be the first index. 

###Our Data:
#####Our data can be found here along with graphs which help to classify runtime: https://docs.google.com/document/d/1VZsGI31gtV_SJPDS0OqiYE3mCv-xSxtQCw8hGMxV-nk/pub

###How Pivot Selection and Data Arrangement Affect Execution Time:
#####Both the best case and worst case senarios demonstarte how pivot selection and data arrangement affect execution time. In the worst case senario, the most swaps and comparisions are being made if the array is in reverse order and we choose the last index of the array as our pivot point. However, in the best case, and even the average case, the data is being divided roughly in half, allowing us to cut our time from O(n^2) to at least O(logn) since we can go through the two subarrays at the sime time.
