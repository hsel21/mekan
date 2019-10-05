
public class Question_1 {

	static int calculateTotalPayment(int init_debt, int interest, int per_repay) {
		
		//Convert to percentages for more intuitive calculations
		double p_interest = interest/100.0;
		double p_per_repay = per_repay/100.0;
		
		double payment = init_debt*p_per_repay; //Monthly payment
		
		if(payment < 50) { //Rounding payment up to 50. Not sure about here.
			payment = 50;
		}
		
		double total_pay = init_debt/10.0; //Initialize total payment with the 10% deposit
		
		double curr_debt = init_debt; 
		
		while(curr_debt > 0) {
			total_pay += payment;
			curr_debt = (curr_debt*(1+p_interest)-payment);
			
			/*if(2*payment > curr_debt) {
				total_pay += curr_debt;
				return (int)total_pay;
			}*/
			
			if(payment > curr_debt) {
				if(curr_debt < 50) {
					total_pay += 50;
					return (int)total_pay;
				}
				total_pay += curr_debt;
				return (int)total_pay;
			}
		}
		return (int)total_pay;
	}


	public static void main(String[]argv) {
		
		System.out.println(calculateTotalPayment(1000,5,10));
	}
}