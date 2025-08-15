package com.greedy.parameter;

public class MenuDTO {
	
	/* 커맨드 객체로 이용하기 위애서는 form의 name 속성값과 일치하게 필드명을 작성해야 한다.
	 * 폼의 이름과 dto 변수명은 같애야 한다. 안그러면 호출 불가능*/
	private String name;
	private int price;
	private int categoryCode;
	private String orderableStatus;
	
	/* 커맨드 객체는 기본생성자를 이용하여 인스턴스를 만들기 때문에 기본생성자가 필요하다.*/
	public MenuDTO() {}

	public MenuDTO(String name, int price, int categoryCode, String orderableStatus) {
		super();
		this.name = name;
		this.price = price;
		this.categoryCode = categoryCode;
		this.orderableStatus = orderableStatus;
	}

	/* 요청 파라미터의 name과 일치하는 필드의 setter 메소드를 이용하기 때문에 네이밍 툴에 맞는 setter메소드가 작성되어 있어야 한다.*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getOrderableStatus() {
		return orderableStatus;
	}

	public void setOrderableStatus(String orderableStatus) {
		this.orderableStatus = orderableStatus;
	}

	@Override
	public String toString() {
		return "MenuDTO [name=" + name + ", price=" + price + ", categoryCode=" + categoryCode + ", orderableStatus="
				+ orderableStatus + "]";
	}
	
	
}
