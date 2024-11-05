package com.udemy.spring3item.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.udemy.spring3item.model.Item;
import com.udemy.spring3item.repo.ItemRepository;
@Service
public class ItemService {
	
	//明示的なコンスト処理がこのアノテーションで不要！
	@Autowired
	private ItemRepository itemRepository;
	
	@Cacheable("getItems")
	public List<Item> getAllItems(){
		List<Item> allItems = new ArrayList<>();
		//戻り値がList形式でないので、ループでぶん回す
		itemRepository.findAll().forEach(allItems::add);
		
		return allItems;
	}
	
	//この引数の指定で、キャッシュ名+Key値の指定が可能となる
	@Cacheable(value="getItem", key="#itemId")
	public Optional<Item> getItem(Long itemId) {
		//戻り値がOptional型なので、nullチェックもやってくれる
		return itemRepository.findById(itemId);
	}
	
	//このアノテーションで対象名のキャッシュ削除が可能
	@CacheEvict(value="getItems", allEntries=true)
	public void addItem(Item item) {
		itemRepository.save(item);
	}
	
	//複数のキャッシュを削除したい時にこのアノテーションで指定が可能
	@Caching(evict = {
		@CacheEvict(value="getItems", allEntries=true),
		@CacheEvict(value="getItem", key="#itemId")	
	})
	public void updateItem(Long itemId, Item item) {
		if(itemRepository.findById(itemId).get() != null) {
			itemRepository.save(item);
		}
	}
	
	@Caching(evict = {
			@CacheEvict(value="getItems", allEntries=true),
			@CacheEvict(value="getItem", key="#itemId")	
	})
	public void deleteItem(Long itemId) {
		itemRepository.deleteById(itemId);
	}

}
