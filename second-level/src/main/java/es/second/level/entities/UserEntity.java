package es.second.level.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", schema = "second_level")
@Entity
@Cacheable("secondLevelCache")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserEntity {

	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
}
