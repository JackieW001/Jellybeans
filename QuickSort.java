//Michael Ruvinshteyn
//APCS2 pd 1
//HW 15 -- So So Quick
//2017 - 3 - 8

/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Partition the list, and continue to partition either side of the pivot point until the method
               partitions a list of length 1
 *
 * 2a. Worst pivot choice / array state and associated runtime: Pivot - midpoint
                                                                State - pivot is the smallest OR largest item
 *
 * 2b. Best pivot choice / array state and associated runtime: Pivot - midpoint
                                                               States - pivot is the middle item
 *
 * 3. Approach to handling duplicate values in array: When partitioning, assume that a value of equivalence is larger
 *
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int[] o, int x, int y ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( d, i, swapPos );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
        qsortH(d,0,d.length - 1); //calls the helper function on the entire array
    }

    //helper function: sorts the array within the boundaries given by left and right
    public static void qsortH(int arr[], int left, int right) {
	int index = partition(arr, left, right);
	if (left < index - 1){
            qsortH(arr, left, index - 1);
	}
	if (index < right){
            qsortH(arr, index, right);
	}
    }

    //modified partition: automatically assumes the middle index as the pivot point
    public static int partition(int arr[], int left, int right){
	int pivot = arr[(left + right) / 2];
     
	while (left <= right) {
            while (arr[left] < pivot)
		left += 1;
            while (arr[right] > pivot)
		right -= 1;
            if (left <= right) {
		swap(arr,left,right);
		left += 1;
		right -= 1;
            }
	}
	return left;
    }


    //main method for testing
    public static void main( String[] args ) 
    {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);

    }//end main

}//end class QuickSort
