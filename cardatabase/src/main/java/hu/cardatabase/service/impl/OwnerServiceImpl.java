package hu.cardatabase.service.impl;

import hu.cardatabase.persistence.entity.OwnerEntity;
import hu.cardatabase.persistence.entitymanager.OwnerDao;
import hu.cardatabase.service.OwnerService;
import hu.cardatabase.service.domain.OwnerDto;
import org.modelmapper.TypeToken;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class OwnerServiceImpl implements OwnerService {
    @Inject
    OwnerDao ownerDao;
    @Inject
    ModelMapper modelMapper;


    @Override
    public List<OwnerDto> findAll() {
        List<OwnerEntity> entities = ownerDao.findAll();
        Type listType = new TypeToken<List<OwnerDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public OwnerDto findOne(Long id) {
        OwnerEntity jog = ownerDao.findOne(id);
        Type listType = new TypeToken<OwnerDto>() {}.getType();
        return modelMapper.map(jog, listType);
    }

    @Override
    public void save(OwnerDto ownerDto) {
        if(ownerDto.getId() != null) {
            modify(ownerDto);
        }else{
            OwnerEntity owner = modelMapper.map(ownerDto, OwnerEntity.class);
            ownerDao.save(owner);
        }
    }

    @Override
    public void modify(OwnerDto ownerDto) {
        OwnerEntity owner = ownerDao.findOne(ownerDto.getId());
        owner.setFirstName(ownerDto.getFirstName());
        owner.setAddress(ownerDto.getLastName());
        owner.setCity(ownerDto.getCity());
        owner.setLastName(ownerDto.getLastName());
        ownerDao.save(owner);
    }

    @Override
    public void delete(OwnerDto owner) {
        OwnerEntity jog = ownerDao.findOne(owner.getId());
        ownerDao.delete(jog);

    }



}
