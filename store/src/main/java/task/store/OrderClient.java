package task.store;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import customerorder.customerdto.DTO.OrderDto;

@FeignClient(name= "customer-order" , url="localhost:8000/api/v1/order")
public interface OrderClient {
	
	@GetMapping("/store/{storeId}")
	public List<OrderDto> getOrdersForStore(@PathVariable Long storeId);
	
	@GetMapping("/ord/fegin")
	public String getName() ;
}
