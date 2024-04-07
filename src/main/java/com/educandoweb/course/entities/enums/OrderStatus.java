package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	WHATING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4), 
	CANCELED(5);
	
	private int code;
	
	//Constructor using fields
	private OrderStatus (int code) {
		this.code = code;
	}

	//Metodo getters and setters

	public int getCode() {
		return code;
	}

	//Metodo vai receber um codigo e vai retornar o OrderStatus correspondente ao codigo
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
