package com.udemy.spring3item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.udemy.spring3item.model.Item;
import com.udemy.spring3item.repo.ItemRepository;

//implements CommandLineRunnerでrunメソッドを定義可能
@SpringBootApplication
//キャシュを利用するのでこのアノテーションを指定する
@EnableCaching
public class Spring3itemApplication extends SpringBootServletInitializer 
implements CommandLineRunner{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Spring3itemApplication.class);
	}
	
	@Autowired
	private ItemRepository itemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Spring3itemApplication.class, args);
	}

	@Override
	public void run(String... args) {
		itemRepository.save(new Item("孫悟空", "ドラゴンボール"));
		itemRepository.save(new Item("炭次郎", "鬼滅の刃"));
		itemRepository.save(new Item("遊戯ボーイ", "遊戯王"));
		itemRepository.save(new Item("サトシ", "ポケモン"));
		itemRepository.save(new Item("デク", "ヒロアカ"));
	}
}
