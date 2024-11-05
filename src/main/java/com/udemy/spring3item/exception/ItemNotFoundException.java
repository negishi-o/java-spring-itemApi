package com.udemy.spring3item.exception;

public class ItemNotFoundException extends RuntimeException {
	
	//runtimeExceptionを利用する際のおさほう！！
	private static final long serialVersionUID = 1L;
	
	public ItemNotFoundException(Long itemId) {
		super("コード:" + itemId + "存在しないよ");
	}
}
