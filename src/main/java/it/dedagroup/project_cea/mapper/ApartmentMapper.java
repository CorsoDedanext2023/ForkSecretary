package it.dedagroup.project_cea.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import it.dedagroup.project_cea.dto.response.ApartmentDtoResponse;
import it.dedagroup.project_cea.exception.model.NotValidDataException;
import it.dedagroup.project_cea.model.Apartment;

@Component
public class ApartmentMapper {
	public ApartmentDtoResponse toDto(Apartment a) {
		if (a == null)throw new NotValidDataException("Apartment is empty: "+a);
		ApartmentDtoResponse apart = new ApartmentDtoResponse();
		apart.setId(a.getId());
		apart.setUnitNumber(a.getUnitNumber());
		apart.setFloorNumber(a.getFloorNumber());
		apart.setId_condominium(a.getCustomer().getId());
		apart.setId_condominium(a.getCondominium().getId());
		return apart;
	}
	public List<ApartmentDtoResponse> toListDto(List<Apartment> apart){
		if (apart == null || apart.isEmpty())throw new NotValidDataException("List of apartments is empty: "+apart);
		return apart.stream().map(this::toDto).toList();
	}
}
