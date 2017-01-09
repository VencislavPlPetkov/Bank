package bg.jwb.ejb;

import javax.ejb.Local;

@Local
public interface WebBank {

	Double deposit(String client, Double amount);

	Double withdraw(String client, Double amount);

}
