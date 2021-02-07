package com.paulovarassin.springbootmicroservice.web;

import com.paulovarassin.springbootmicroservice.domain.Tour;
import com.paulovarassin.springbootmicroservice.domain.TourRating;
import com.paulovarassin.springbootmicroservice.domain.TourRatingPk;
import com.paulovarassin.springbootmicroservice.repo.TourRatingRepository;
import com.paulovarassin.springbootmicroservice.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {
    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }

    protected TourRatingController() {
    }


    /**
     * Create a Tour Rating.
     *
     * @param tourId tour identifier
     * @param ratingDto rating data transfer object
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") int tourId,
                                 @RequestBody @Validated RatingDto ratingDto) {
        Tour tour = verifyTour(tourId);
        tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDto.getCustomerId()),
                ratingDto.getScore(), ratingDto.getComment()));
    }


    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId tour identifier
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
    private Tour verifyTour(int tourId) {
        return tourRepository.findById(tourId)
                .orElseThrow(() ->
                        new NoSuchElementException("Tour does not exist: " + tourId));
    }


    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex exception
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }

}
