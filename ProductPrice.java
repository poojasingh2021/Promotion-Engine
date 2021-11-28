package promotionEngine;

/**
 * This class is responsible for getting price according to selected product
 */
public class ProductPrice {
	private int getProductPrice(String product) {
		int price = 0;
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

	public int getTotalPriceOfProductA(int count) {
		int price = 0;
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

	public int getTotalPriceOfProductB(int count) {
		int price = 0;
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

	public int getTotalPriceOfProductCAndD(int countC,int countD) {
		int price = 0;
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
