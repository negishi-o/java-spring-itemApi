package com.udemy.spring3item;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.udemy.spring3item.controller.ItemController;
import com.udemy.spring3item.repo.ItemRepository;
import com.udemy.spring3item.service.ItemService;

@SpringBootTest
class Spring3itemApplicationTests {

	@Autowired
	private ItemController itemController;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemService itemService;
	
	//アプリケーションがSpringコンテキストを正常にロードが出来たのか確認するテスト実施
	@Test
	void contextLoads() {
		//AssertJを利用した検証です
		//このファンクションの引数に検証したいものを指定する
		//期待値がnullでないと設定する
		assertThat(itemController).isNotNull();
		assertThat(itemRepository).isNotNull();
		assertThat(itemService).isNotNull();
	}

}
