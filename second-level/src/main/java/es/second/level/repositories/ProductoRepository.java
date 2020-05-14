package es.second.level.repositories;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import es.second.level.entities.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, String> {

	@QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
	@Query(value = "SELECT p FROM ProductoEntity p")
	List<ProductoEntity> findAllCache();
}
