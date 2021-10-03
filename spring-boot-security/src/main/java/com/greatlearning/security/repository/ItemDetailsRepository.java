package com.greatlearning.security.repository;

import com.greatlearning.security.entity.ItemDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDetailsRepository extends JpaRepository<ItemDetails, Integer> {

}
