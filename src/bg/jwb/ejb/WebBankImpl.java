package bg.jwb.ejb;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

import javax.ejb.Stateful;

@Stateful
public class WebBankImpl implements WebBank {

	private static final Map<String, Double> bankAccounts = new HashMap<>();

	@Override
	public Double deposit(String client, Double amount) {

		Double currentAmount = bankAccounts.get(client);

		if (currentAmount == null) {
			currentAmount = 0.0;
		}

		currentAmount += amount;
		bankAccounts.put(client, currentAmount);

		return currentAmount;
	}

	@Override
	public Double withdraw(String client, Double amount) {
		Double currentAmount = bankAccounts.get(client);

		if (currentAmount == null) {
			return 0.0;
		}

		currentAmount -= amount;
		bankAccounts.put(client, currentAmount);

		return currentAmount;
	}

}
