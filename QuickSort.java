/**
* Author: Mason Limtiaco
* Sources: https://www.youtube.com/watch?v=SLauY6PpjW4&t=312s "Hacker Rank"
* 02-19-2020
**/

public class QuickSort implements SortingAlgorithm
{
	public void sort(int [] a){
		quickSort(a,0,a.length-1); //quicksort the right side
	}

	public void quickSort(int [] a, int left, int right){
		if(left>=right)
			return;
		int pivot = a[(left+right)/2]; //makes the pivot the middle element of the array
		int index = partition(a,left,right,pivot); //this gives the dividing point between the left and right side
		quickSort(a,left,index-1); //quicksort the left side
		quickSort(a,index,right); //quicksort the right side
	}

	public int partition(int [] a, int left, int right, int pivot){
		while(left<=right){
			while(a[left] < pivot){
				left++;
			}
			while(a[right] > pivot){
				right--;
			}
			if(left<=right){
				swap(a,left,right);
				left++;
				right--;
			}
		}
		return left;
	}

	public void swap(int [] a, int left, int right){
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

}