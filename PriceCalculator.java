package promotionEngine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PriceCalculator {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] products = null;
			int totalProduct = 0;
			System.out.println("Enter total number of products : ");
			totalProduct = Integer.parseInt(br.readLine());
			products = new String[totalProduct];
			for (int i = 0; i < totalProduct; i++) {
				System.out.println("Enter the type of product:A,B,C or D : ");
				String product = br.readLine();
				products[i] = product;
			}
			PriceCalculator priceCal = new PriceCalculator();
			int totalPrice = priceCal.calculateTotalPrice(products);
			System.out.println("Total Price is : " + totalPrice);
		} catch (Exception e) {
			System.err.println("Error occured");
		}
	}

	public int calculateTotalPrice(String[] products) {
		int countA =0, countB =0, countC = 0, countD = 0;
		for (String product : products) {
			if (product.equals("A")) {
				countA++;
			} else if (product.equals("B")) {
				countB++;
			} else if (product.equals("C")) {
				countC++;
			} else if (product.equals("D")) {
				countD++;
			}
		}
		ProductPrice prdPrice = new ProductPrice();
        int totalPrice = 0;
        if(countA > 0) {
        	totalPrice += prdPrice.getTotalPriceOfProductA(countA);
        }
        if(countB > 0) {
        	totalPrice += prdPrice.getTotalPriceOfProductB(countB);
        }
        if(countC > 0 || countD > 0) {
        	totalPrice += prdPrice.getTotalPriceOfProductCAndD(countC, countD);
        }
		return totalPrice;

	}
}
