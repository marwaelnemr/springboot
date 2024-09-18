package task.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import task.store.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long>{
 
}
