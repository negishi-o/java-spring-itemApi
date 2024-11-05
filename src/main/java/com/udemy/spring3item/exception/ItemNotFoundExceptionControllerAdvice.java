package com.udemy.spring3item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//このクラスの役割としては、独自で例外処理を作成した際に、この例外処理コントローラーが
//どの独自クラスの例外処理メソッドを呼んで、エンドに返すかを判断してくれる
@ControllerAdvice
public class ItemNotFoundExceptionControllerAdvice {

	@ResponseBody
	//これでどの独自クラスの例外処理を処理を利用するか引数に指定するよ
	@ExceptionHandler(ItemNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String itemNotFoundHandler(ItemNotFoundException ex) {
		return ex.getMessage();
	}
}
