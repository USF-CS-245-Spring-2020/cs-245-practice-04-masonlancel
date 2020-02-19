public class MergeSort implements SortingAlgorithm{
	public void sort(int [] a){
		mergeSort(a, new int[a.length], 0, a.length-1);	
	}

	public void mergeSort(int [] a, int [] temp, int leftStart, int rightEnd){
		if(leftStart>=rightEnd) //base case
			return;
		int middle = (leftStart + rightEnd)/2; //finds the middle point
		mergeSort(a, temp, leftStart, middle); //breaks down the left side array
		mergeSort(a, temp, middle+1,rightEnd); //breaks down the right side array
		merge(a, temp, leftStart, rightEnd); //merging both sides of the array
	}
	public void merge(int [] a, int [] temp, int leftStart, int rightEnd){
		int leftEnd = (rightEnd + leftStart)/2; //where the left ends (middle)
		int rightStart = leftEnd+1; //where the right starts, (middle + 1)
		int size = rightEnd-leftStart+1; //size of the array

		int left = leftStart; //left index
		int right = rightStart; //right index
		int index = leftStart; //index for temporary array

		while(left <= leftEnd && right <= rightEnd){ //making sure still in bounds of each array (left & right)
			if(a[left]<=a[right]){ //compares for left being less than right
				temp[index] = a[left]; //replaces the index of temp with the left index
				left++; //increases the left index
			}
			else{ //compares for right being less than left
				temp[index] = a[right]; //replaces the index of temp with the right index
				right++; //increase the right index
			}
			index++; //ALWAYS increases the temp array index
		}

		System.arraycopy(a,left,temp,index, leftEnd - left + 1); //copies the rest of the left array into temp
		System.arraycopy(a,right,temp,index, rightEnd - right + 1); //copies the rest of the right array into temo
		System.arraycopy(temp,leftStart,a,leftStart, size); //copies the temp array into "a" array


	}
}
