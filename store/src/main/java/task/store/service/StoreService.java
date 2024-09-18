package task.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import customerorder.customerdto.DTO.OrderDto;
import customerorder.customerdto.DTO.StoreDto;
import task.store.OrderClient;
import task.store.mapper.StoreMap;
import task.store.model.Store;
import task.store.repository.StoreRepository;


@Service
public class StoreService {
	
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private StoreMap storeMap;
	
	@Autowired
	private OrderClient ordClient;
	
	public List<StoreDto> gerAllStore(){
		List<Store> store = storeRepo.findAll();
		List<StoreDto> storeDto = new ArrayList<>();
		for(Store s:store) {
			storeDto.add(storeMap.mapToStoreDto(s));
		}
		return storeDto;
	}
	
	public StoreDto getStoreById(@PathVariable Long storeId) {
		Store store = storeRepo.findById(storeId).orElse(null);
		StoreDto storeDto = storeMap.mapToStoreDto(store);
		return storeDto;
		
	}
	
	
	public ResponseEntity<String> deleteStoreById(@PathVariable Long storeId){
		Store store = storeRepo.findById(storeId).orElse(null);
		if(store == null) {
			return  ResponseEntity.ok("store Deleted Successful");
		}else {
		storeRepo.deleteById(storeId);
		return  ResponseEntity.ok("store not found :"+ storeId);
		}
		
	}
	
	public StoreDto updateStore(@PathVariable Long storeId,@RequestBody StoreDto storeDto) {
		Store store = storeRepo.findById(storeId).orElse(null);
		store.setSname(storeDto.getSname());
		store.setAddress(storeDto.getAddress());
		store.setEmail(storeDto.getEmail());
		store.setPhone(storeDto.getPhone());
		StoreDto st =storeMap.mapToStoreDto(storeRepo.save(store));
		return st;
		
	}
	
	public StoreDto createStore(@RequestBody StoreDto storeDto) {
		Store store = storeMap.mapToStore(storeDto);
		StoreDto st =storeMap.mapToStoreDto(storeRepo.save(store));
		return st;
		
		
	}
	
	public List<OrderDto> getOrdersForStore(@PathVariable Long storeId){
		System.out.print("ffffffff");
		return ordClient.getOrdersForStore(storeId);
	}
	public String getName() {
		return ordClient.getName();
	}
}
