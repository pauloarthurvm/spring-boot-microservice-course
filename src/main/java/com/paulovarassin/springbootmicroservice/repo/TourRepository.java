package com.paulovarassin.springbootmicroservice.repo;

import com.paulovarassin.springbootmicroservice.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
}
