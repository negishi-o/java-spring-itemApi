package com.udemy.spring3item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.spring3item.model.Item;
import com.udemy.spring3item.repo.ItemRepository;
@Service
public class ItemService {
	
	//明示的なコンスト処理がこのアノテーションで不要！
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAllItems(){
		List<Item> allItems = new ArrayList<>();
		//戻り値がList形式でないので、ループでぶん回す
		itemRepository.findAll().forEach(allItems::add);
		
		return allItems;
	}
	
	public Optional<Item> getItem(Long itemId) {
		//戻り値がOptional型なので、nullチェックもやってくれる
		return itemRepository.findById(itemId);
	}
	
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	public void updateItem(Long itemId, Item item) {
		if(itemRepository.findById(itemId).get() != null) {
			itemRepository.save(item);
		}
	}
	
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

}
