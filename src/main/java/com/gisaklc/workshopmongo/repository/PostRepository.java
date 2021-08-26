package com.gisaklc.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.gisaklc.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	/**consulta usando @query e a sintaxe do mongodb*
	 * "title" é o campo da busca
	 * " $regex:?0" é o valor recebido por parametro e 0 pq é o primeiro parametro do metodo
	 * "options = i" ignora letras maiusculas e minusculas
	 **/
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	/** search post by fields: "title body or comennts" and between dates**/
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , "
			+ "{ $or:"
			+ " [ { 'title': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'body': { $regex: ?0, $options: 'i' } }, "
			+ "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
