package com.paulovarassin.springbootmicroservice.service;

import com.paulovarassin.springbootmicroservice.domain.Difficulty;
import com.paulovarassin.springbootmicroservice.domain.Region;
import com.paulovarassin.springbootmicroservice.domain.Tour;
import com.paulovarassin.springbootmicroservice.domain.TourPackage;
import com.paulovarassin.springbootmicroservice.repo.TourPackageRepository;
import com.paulovarassin.springbootmicroservice.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String tourPackageName, Map<String, String> details) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(() ->
                new RuntimeException("Tour package does not exist: " + tourPackageName));
        return tourRepository.save(new Tour(title, tourPackage, details));
    }

    public long total() {
        return tourRepository.count();
    }

}
