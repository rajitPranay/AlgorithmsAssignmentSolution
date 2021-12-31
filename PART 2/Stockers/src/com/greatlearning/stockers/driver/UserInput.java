package com.greatlearning.stockers.driver;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.greatlearning.stockers.service.MergeSort;
import com.greatlearning.stockers.service.PriceStatus;
import com.greatlearning.stockers.service.Search;

public class UserInput implements StocksInterface {
	public static Scanner sc = new Scanner(System.in);

	public void stockDetails() {
		// Get basic details from user
		System.out.println("Enter the Number of Companies");
		int N = sc.nextInt();
		int itr = 0;
		Boolean j = true;
		double[] price = new double[N];
		Boolean[] bool = new Boolean[N];

		// Exception handled for invalid boolean input
		try {
			while (itr < N) {
				int company = itr + 1;
				System.out.println("Enter current stock price of the company " + company);
				price[itr] = (double) sc.nextDouble();

				System.out.println("Whether company's stock price rose today compare to yesterday?");
				bool[itr] = sc.nextBoolean();
				itr++;
			}
		} catch (InputMismatchException e) {
			System.out.print("Invalid input\n\n");
			sc.nextLine();
			j = false;
			stockDetails();
		}

		// services offered
		while (j != false && N != 0) {
			System.out.println("Enter the operation that you want to perform\n"
					+ "1. Display the companies stock prices in ascending order\n"
					+ "2. Display the companies stock prices in descending order\n"
					+ "3. Display the total no of companies for which stock prices rose today\n"
					+ "4. Display the total no of companies for which stock prices declined today\n"
					+ "5. Search a specific stock price\n" + "6. press 0 to exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("AO");
				MergeSort ms = new MergeSort();
				ms.sort(price, 0, price.length - 1);
				for (int jp = price.length - 1; jp >= 0; jp--) {
					System.out.println(price[jp]);
				}
				break;
			case 2:
				// System.out.println("DO");
				MergeSort ms1 = new MergeSort();
				ms1.sort(price, 0, price.length - 1);
				for (int jp = 0; jp < price.length; jp++) {
					System.out.println(price[jp]);
				}
				break;
			case 3:
				// System.out.println("rose today");
				PriceStatus status = new PriceStatus();
				status.rise(bool);
				break;
			case 4:
				// System.out.println("declined today");
				PriceStatus status1 = new PriceStatus();
				status1.decline(bool);
				break;
			case 5:
				System.out.println("Enter the key value");
				double find = (double) sc.nextDouble();
				Search s = new Search();
				// System.out.println(s.binarySearch(price, N, find));
				if (s.binarySearch(price, N, find)) {
					System.out.println("Stock of value " + find + " is present");
				} else {
					System.out.println("Value not found");
				}
				break;
			case 0:
				sc.close();
				j = false;
				System.out.println("Exited Successfully");
				break;
			}
		}
	}
}
