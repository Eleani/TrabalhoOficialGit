package domain;

import java.util.List;

public interface Persistible <T> {

	void save(T entity);
	
	T getOne(Long id);
	
	T getLatLon(Double latitude, Double longitude);
	
	List<T> getAll();
	
	void delete(T entity);
	
	void update(T entity);
	
	void gravar(T entity);
	
}
