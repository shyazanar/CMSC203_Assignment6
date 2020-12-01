
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double shotPrice = 0.50;
	private final double syrupPrice = 0.50;

	public Coffee(String name, SIZE size, boolean shots, boolean syrup) {
		super(name, size, TYPE.COFFEE);
		this.extraShot = shots;
		this.extraSyrup = syrup;
	}

	@Override
	double calcPrice() {
		double price = 0.0;
		price += super.getBasePrice();
		switch (super.getSize()) {
			case SMALL: break;
			case MEDIUM: price += super.getSizePrice();
						 break;
			case LARGE: price += 2 * super.getSizePrice();
						break;
		}
		price += this.extraShot ? this.shotPrice : 0.0;
		price += this.extraSyrup ? this.syrupPrice : 0.0;
		return price;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" +
			   "Coffee [extraShot=" + extraShot + ", extraSyrup=" + extraSyrup + "]" + "\n" +
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
		Coffee other = (Coffee) obj;
		if (extraShot != other.extraShot)
			return false;
		if (extraSyrup != other.extraSyrup)
			return false;
		return true;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	public double getShotPrice() {
		return shotPrice;
	}

	public double getSyrupPrice() {
		return syrupPrice;
	}	

}
