package hu.cardatabase.service;

import hu.cardatabase.service.domain.CarsDto;

import java.util.List;

public interface CarsService {
    List<CarsDto> findAll();
    void save(CarsDto jogDto);
    void modify(CarsDto jogDto);
    void delete(CarsDto jogDto);

    CarsDto findOne(Long carId);
}
