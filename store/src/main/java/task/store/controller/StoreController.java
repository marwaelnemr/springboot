package task.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customerorder.customerdto.DTO.OrderDto;
import customerorder.customerdto.DTO.StoreDto;
import task.store.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	
	@Autowired
	private StoreService storeSer;
	
	@GetMapping
	public List<StoreDto> getAllStore(){
		return storeSer.gerAllStore();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<StoreDto> getStoreById(@PathVariable Long id){
		StoreDto storeDto =  storeSer.getStoreById(id);
		return ResponseEntity.ok(storeDto);
	}
	
	@PostMapping
	public ResponseEntity<StoreDto> createStore(@RequestBody StoreDto stDto) {
		StoreDto st =  storeSer.createStore(stDto);
		return ResponseEntity.ok(st);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStore(@PathVariable Long id){
		return storeSer.deleteStoreById(id);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<StoreDto>  updateStore(@PathVariable Long id,@RequestBody StoreDto stDto) {
		System.out.print(stDto);
		StoreDto st =storeSer.updateStore(id, stDto);
		return ResponseEntity.ok(st);
	}
	
	@GetMapping("/feign/{storeId}")
	public List<OrderDto> getOrdersForStore(@PathVariable Long storeId){
		return storeSer.getOrdersForStore(storeId);
		
	}
	
	@GetMapping("/ord")
	public String getName() {
		return storeSer.getName();
	}
}
