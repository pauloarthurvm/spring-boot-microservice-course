package com.paulovarassin.springbootmicroservice.service;

import com.paulovarassin.springbootmicroservice.domain.TourPackage;
import com.paulovarassin.springbootmicroservice.repo.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name) {
        return new TourPackage(code, name);
    }

    public Iterable<TourPackage> lookup(){
        return null;
    }

    public long total() {
        return 0;
    }
}
