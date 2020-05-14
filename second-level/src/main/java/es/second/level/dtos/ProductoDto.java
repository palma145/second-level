package es.second.level.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {

	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "price")
	private String price;
}
