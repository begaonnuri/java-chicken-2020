package domain.menu;

public class MenuAmount {
	private int amount;

	private MenuAmount(int amount) {
		validateBound(amount);
		this.amount = amount;
	}

	public static MenuAmount of(String input) {
		return new MenuAmount(Integer.parseInt(input));
	}

	private void validateBound(int amount) {
		if(amount < 1 || amount > 99){
			throw new IllegalArgumentException("메뉴는 1개 이상 99개 이하만 가능합니다.");
		}
	}
}
