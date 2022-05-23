package hu.cardatabase.service;

import hu.cardatabase.service.domain.OwnerDto;

import java.util.List;

public interface OwnerService {

    List<OwnerDto> findAll();
    void save(OwnerDto jogDto);
    void modify(OwnerDto jogDto);
    void delete(OwnerDto jogDto);

    OwnerDto findOne(Long ownerId);
}
