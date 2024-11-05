package com.udemy.spring3item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.udemy.spring3item.model.Item;
import com.udemy.spring3item.repo.ItemRepository;

//implements CommandLineRunnerでrunメソッドを定義可能
@SpringBootApplication
public class Spring3itemApplication implements CommandLineRunner{

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
