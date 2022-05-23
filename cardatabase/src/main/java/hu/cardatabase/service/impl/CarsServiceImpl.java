package hu.cardatabase.service.impl;

import hu.cardatabase.persistence.entity.CarsEntity;
import hu.cardatabase.persistence.entitymanager.CarsDao;
import hu.cardatabase.service.CarsService;
import hu.cardatabase.service.domain.CarsDto;
import org.modelmapper.TypeToken;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class CarsServiceImpl implements CarsService {

    @Inject
    CarsDao carsDao;
    @Inject
    ModelMapper modelMapper;


    @Override
    public List<CarsDto> findAll() {
        List<CarsEntity> entities = carsDao.findAll();
        Type listType = new TypeToken<List<CarsDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public CarsDto findOne(Long carid) {
        CarsEntity jog = carsDao.findOne(carid);
        Type listType = new TypeToken<CarsDto>() {}.getType();
        return modelMapper.map(jog, listType);
    }

    @Override
    public void save(CarsDto carsDto) {
        CarsEntity car = modelMapper.map(carsDto, CarsEntity.class);
        carsDao.save(car);
    }

    @Override
    public void modify(CarsDto carsDto) {
        CarsEntity car = carsDao.findOne(carsDto.getId());
        car.setLpNumber(carsDto.getLpNumber());
        carsDao.save(car);
    }

    @Override
    public void delete(CarsDto car) {
        CarsEntity jog = carsDao.findOne(car.getId());
        carsDao.delete(jog);

    }
}
