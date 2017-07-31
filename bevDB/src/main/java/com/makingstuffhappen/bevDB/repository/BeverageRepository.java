package com.makingstuffhappen.bevDB.repository;

import com.makingstuffhappen.bevDB.entity.Beverage;
import org.springframework.data.repository.CrudRepository;

/**
 * JPA Repository for the Becverage Entity
 * Created by @author philip on 6/14/17.
 */
public interface BeverageRepository extends CrudRepository<Beverage, Long> {
}
