package com.grocery.repo;

import com.grocery.Entity.GroceryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepo extends JpaRepository <GroceryItems,Long> {

}
