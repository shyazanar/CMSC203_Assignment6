import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	private int numOfAlcoholDrink;
	private ArrayList<Order> orders;
	private Order currentOrder;

	public BevShop() {
		orders = new ArrayList<Order>(); 
	}

	@Override
	public boolean validTime(int time) {
		if (time < MIN_TIME || time > MAX_TIME) {
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public boolean eligibleForMore() {
		if (currentOrder.findNumOfBeveType(TYPE.ALCOHOL) < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean validAge(int age) {
		if (age < MIN_AGE_FOR_ALCOHOL) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		orders.add(currentOrder);

	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		this.currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		currentOrder.addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for (Order o: orders) {
			total += o.calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		orders.sort(null);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}
	
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	public boolean isMaxFruit(int i) {
		return (MAX_FRUIT == i);
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}

	public void setNumOfAlcoholDrink(int numOfAlcoholDrink) {
		this.numOfAlcoholDrink = numOfAlcoholDrink;
	}


	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	@Override
	public String toString() {
		return "BevShop [numOfAlcoholDrink=" + numOfAlcoholDrink + ", orders=" + orders + ", currentOrder="
				+ currentOrder + ", totalMonthlySale=" + totalMonthlySale() + "]";
	}

}
