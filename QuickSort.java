//Manahal Tabassum
//APCS2 pd1
//HW15 -- So So Quick
//2017-03-09

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): By first placing the pivot point in the center, you can split
the array into two. Then you can partition both sides and continue this process
on both the left and right hand side of the pivot Pos until the right < left 
at which point the elements will be sorted.
 *
 * 2a. Worst pivot choice / array state and associated runtime: 
The worst choice would be to choose the right or left most index of the array
because in this case the greatest number of comparisons has to be made to the 
pivot number. Also greater number of partitions is run. The run time would be
O(n^2)
 *
 * 2b. Best pivot choice / array state and associated runtime:
The best pivot choice would be the center index of the array as then only n/2 
partitions will be needed and comparison of n-1 values which would make the 
runtime O(nlogn)
 *
 * 3. Approach to handling duplicate values in array:
The partition function handles duplicates by placing them to the left of the Pvt value.
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
    public static void swap( int x, int y, int[] o ) {
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
	    swap( i, swapPos, d );
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
	qsort(d,0,d.length-1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.
    public static int partition(int[] arr, int left, int right, int pvtPos){
	int pvtVal = arr[pvtPos];
	swap( pvtPos, right, arr);
	int stor = left;
	for( int i = left; i < right; i++ ) {
	    if ( arr[i] <= pvtVal) {
		swap( i, stor, arr );
		stor++;}
	}
	swap(stor,right,arr);
	return stor;
    }

    public static void qsort(int[] arr, int left, int right){
	if (left<right){
	    int pvtPos = partition(arr,left,right,(left+right)/2);
	    qsort(arr,left,pvtPos-1);
	    qsort(arr,pvtPos+1,right);
	}
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
