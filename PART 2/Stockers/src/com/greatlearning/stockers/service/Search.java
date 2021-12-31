package com.greatlearning.stockers.service;

// search the given key value form the array
public class Search {
	double[] arr;

	public boolean binarySearch(double[] arr, int size, double key) {
		this.arr=arr;
		int left = 0, right = size - 1;
		while(left<=right) {
			int mid = (left + right)/2;
			if(key == arr[mid]) {
				return true;
			} else if(key< arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}
}
