
public abstract class Beverage {
	private String bevName;
	private TYPE type;
	private SIZE size;
	private final double basePrice = 2.00;
	private final double sizePrice = 1.00;

	public Beverage(String name, SIZE size, TYPE type) {
		this.bevName = name;
		this.size = size;
		this.type = type;
	}
	
	abstract double calcPrice();

	@Override
	public String toString() {
		return "Beverage [name=" + bevName + ", type=" + type + ", size=" + size + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beverage other = (Beverage) obj;
		if (bevName == null) {
			if (other.bevName != null)
				return false;
		} else if (!bevName.equals(other.bevName))
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public String getBevName() {
		return bevName;
	}

	public void setBevName(String name) {
		this.bevName = name;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public double getSizePrice() {
		return sizePrice;
	}

}
