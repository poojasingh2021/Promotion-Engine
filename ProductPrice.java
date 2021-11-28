package promotionEngine;

/**
 * This class is responsible for getting price according to selected product
 */
public class ProductPrice {
	private double getProductPrice(String product) {
		double price = 0;
		switch (product) {
		case "A":
			price = 50;
			break;
		case "B":
			price = 30;
			break;
		case "C":
			price = 20;
			break;
		case "D":
			price = 15;
			break;
		default:
			break;
		}
		return price;
	}

	public double getTotalPriceOfProductA(int count) {
		double price = 0.0;
		try {
			int ruleCount = count % 3;
			if (ruleCount == 0) {
				price = (count / 3) * PromotionsRules.RULE_3AS.getPromoPrice();
			} else {
				price = (count / 3) * PromotionsRules.RULE_3AS.getPromoPrice();
				price += (ruleCount * getProductPrice("A"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}

	public double getTotalPriceOfProductB(int count) {
		double price = 0.0;
		try {
			int ruleCount = count % 2;
			if (ruleCount == 0) {
				price = (count / 2) * PromotionsRules.RULE_2BS.getPromoPrice();
			} else {
				price = (count / 2) * PromotionsRules.RULE_2BS.getPromoPrice();
				price += (ruleCount * getProductPrice("B"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}

	public double getTotalPriceOfProductCAndD(int countC,int countD) {
		double price = 0.0;
		try {
        if(countC == countD) {
        	price = countC * PromotionsRules.RULE_CANDD.getPromoPrice();
        }else {
        	if(countC < countD) {
        		price = countC * PromotionsRules.RULE_CANDD.getPromoPrice();
        		price += (countD - countC) * getProductPrice("D");
        	}else if (countD < countC) {
        		price = countD * PromotionsRules.RULE_CANDD.getPromoPrice();
        		price += (countC - countD) * getProductPrice("C");
        	}
        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}
}
