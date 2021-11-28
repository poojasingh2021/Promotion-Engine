package promotionEngine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			List<String> products = new ArrayList<String>();
			int totalProduct = 0;
			System.out.println("Enter total number of products : ");
			totalProduct = Integer.parseInt(br.readLine());
			for (int i = 0; i < totalProduct; i++) {
				System.out.println("Enter the type of product:A,B,C or D : ");
				String product = br.readLine();
				products.add(product);
			}
			PriceCalculator priceCal = new PriceCalculator();
			double totalPrice = priceCal.calculateTotalPrice(products);
			System.out.println("Total Price is : " + totalPrice);
		} catch (Exception e) {
			System.err.println("Error occured");
		}
	}

	public double calculateTotalPrice(List<String> products) {
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