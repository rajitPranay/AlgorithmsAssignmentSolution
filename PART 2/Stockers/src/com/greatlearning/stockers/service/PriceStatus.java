package com.greatlearning.stockers.service;

// class to get the rise/decline status of the stock value
public class PriceStatus {
	Boolean[] arr;

	public void rise(Boolean[] arr) {
		this.arr = arr;
		int itr = 0, count = 0;
		while (itr < arr.length) {
			if (arr[itr]) {
				count++;
			}
			itr++;
		}
		System.out.println("Total no of companies whose stock price rose today : " + count);
	}

	public void decline(Boolean[] arr) {
		this.arr = arr;
		int itr = 0, count = 0;
		while (itr < arr.length) {
			if (!arr[itr]) {
				count++;
			}
			itr++;
		}
		System.out.println("Total no of companies whose stock price declined today : " + count);
	}

}
