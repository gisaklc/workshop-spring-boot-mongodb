package com.gisaklc.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gisaklc.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	/**consulta usando @query e a sintaxe do mongodb*
	 * "title" é o campo da busca
	 * "?0" é o valor recebido por parametro e 0 pq é o primeiro parametro do metodo
	 * "options = i" ignora letras maiusculas e minusculas
	 **/
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
