package promotionEngine;

public enum PromotionsRules {
	RULE_3AS(130), RULE_2BS(45), RULE_CANDD(30);
	private int promoPrice = 0;

	private PromotionsRules(int rule) {
		this.promoPrice = rule;
	}

	public int getPromoPrice() {
		return promoPrice;
	}
	
	public PromotionsRules promoPriceAccToRule(int rule) {
		for (PromotionsRules enumValue : PromotionsRules.values()) {

			if (enumValue.getPromoPrice() == rule)
				return enumValue;

		}
		throw new RuntimeException("Enum value not found");
	}
}
