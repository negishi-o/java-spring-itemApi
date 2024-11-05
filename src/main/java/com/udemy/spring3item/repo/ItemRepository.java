package com.udemy.spring3item.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udemy.spring3item.model.Item;

//↓のアノテーションを付ければ、DBアクセスのソースは自動で生成してくるので、不要
//独自でDB操作メソッドが必要であれば、追加してあげる
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
	
}
