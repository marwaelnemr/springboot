package task.store.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import customerorder.customerdto.DTO.StoreDto;
import task.store.model.Store;
@Component
public class StoreMap {
	@Autowired
	private  ModelMapper modelMapper;

	public StoreMap(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}
	
	
	public StoreDto mapToStoreDto(Store store) {
		StoreDto storeDto = modelMapper.map(store, StoreDto.class);
		return storeDto;
	}
	
	public Store mapToStore(StoreDto storeDto) {
		Store store = modelMapper.map(storeDto, Store.class);
		return store;
	}
	
}
