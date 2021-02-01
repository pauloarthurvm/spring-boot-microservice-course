package com.paulovarassin.springbootmicroservice.repo;

import com.paulovarassin.springbootmicroservice.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
}
