
public class Alcohol extends Beverage {
	private boolean weekend;
	private final double weekendPrice = 0.60;

	public Alcohol(String name, SIZE size, boolean weekend) {
		super(name, size, TYPE.ALCOHOL);
		this.weekend = weekend;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
	           "Alcohol [weekend=" + weekend + ", weekendPrice=" + weekendPrice + "]" + "\n" +
				"Price =" + this.calcPrice();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alcohol other = (Alcohol) obj;
		if (weekend != other.weekend)
			return false;
		if (Double.doubleToLongBits(weekendPrice) != Double.doubleToLongBits(other.weekendPrice))
			return false;
		return true;
	}

	@Override
	double calcPrice() {
		double price = 0.0;
		price += super.getBasePrice();
		switch (super.getSize()) {
			case SMALL:	break;
			case MEDIUM: price += super.getSizePrice();
						 break;
			case LARGE: price += 2 * super.getSizePrice();
						break;
		}
		price += this.weekend ? this.weekendPrice : 0.0;
		return price;
	}

	public boolean isWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}

	public double getWeekendPrice() {
		return weekendPrice;
	}

}
