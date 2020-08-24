package com.example.Assignmnet1.Assignment1;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Integer> 
{
	@Modifying
	@Transactional
	@Query(value="delete from Book b where b.cost>1000",nativeQuery=true)
	public void deleteByCosts();
	
	@Modifying
	@Transactional
	@Query(value="update Book set author_name=:newname where author_name like 'Will %' ",nativeQuery=true)
	public void updateByAuthorNames(String newname);

}
