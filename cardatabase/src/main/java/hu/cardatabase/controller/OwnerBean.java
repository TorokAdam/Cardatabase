package hu.cardatabase.controller;

import hu.cardatabase.service.CarsService;
import hu.cardatabase.service.OwnerService;
import hu.cardatabase.service.domain.CarsDto;
import hu.cardatabase.service.domain.OwnerDto;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named(value = "ownerBean")
@ViewScoped
public class OwnerBean implements Serializable {
    @Inject
    OwnerService ownerService;
    @Inject
    CarsService carsService;

    private List<OwnerDto> ownerDtos;
    private List<CarsDto> carsDtos;
    private OwnerDto selectedOwner;
    private OwnerDto newOwnerDto;
    private CarsDto selectedCar;
    private CarsDto newCarDto;
    private Long selectedCarOwnerId;

    @PostConstruct
    public void init(){
        ownerDtos = ownerService.findAll();
        carsDtos = carsService.findAll();
        selectedOwner = new OwnerDto();
        newOwnerDto = new OwnerDto();
        selectedCar = new CarsDto();
        newCarDto = new CarsDto();
        selectedCarOwnerId = null;
    }

    public void save(){
        ownerService.save(newOwnerDto);
        init();
    }

    public void saveCar(){
        newCarDto.setOwner(ownerService.findOne(selectedCarOwnerId));
        carsService.save(newCarDto);
        init();
    }

    public void rowSelect(){
        newOwnerDto = selectedOwner;
    }

    public void rowUnSelect(){
        newOwnerDto = null;
    }


    public void rowSelectCar(){
        newCarDto = selectedCar;
        selectedCarOwnerId = selectedCar.getOwner().getId();
    }

    public void rowUnSelectCar(){
        newCarDto = null;
        selectedCarOwnerId = null;
    }

    public void delete(){
        ownerService.delete(selectedOwner);
        init();
    }

    public void deleteCar(){
        selectedCar.setOwner(ownerService.findOne(selectedCarOwnerId));
        carsService.delete(selectedCar);
        init();
    }

    public List<OwnerDto> getOwnerDtos() {
        return ownerDtos;
    }

    public void setOwnerDtos(List<OwnerDto> ownerDtos) {
        this.ownerDtos = ownerDtos;
    }

    public List<CarsDto> getCarsDtos() {
        return carsDtos;
    }

    public void setCarsDtos(List<CarsDto> carsDtos) {
        this.carsDtos = carsDtos;
    }

    public OwnerDto getSelectedOwner() {
        return selectedOwner;
    }

    public void setSelectedOwner(OwnerDto selectedOwner) {
        this.selectedOwner = selectedOwner;
    }

    public OwnerDto getNewOwnerDto() {
        return newOwnerDto;
    }

    public void setNewOwnerDto(OwnerDto newOwnerDto) {
        this.newOwnerDto = newOwnerDto;
    }

    public CarsDto getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(CarsDto selectedCar) {
        this.selectedCar = selectedCar;
    }

    public CarsDto getNewCarDto() {
        return newCarDto;
    }

    public void setNewCarDto(CarsDto newCarDto) {
        this.newCarDto = newCarDto;
    }

    public Long getSelectedCarOwnerId() {
        return selectedCarOwnerId;
    }

    public void setSelectedCarOwnerId(Long selectedCarOwnerId) {
        this.selectedCarOwnerId = selectedCarOwnerId;
    }
}
