package com.nortal.mega.rest;

import com.nortal.mega.service.Building;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-25T18:55:54+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class BuildingDtoMapperImpl implements BuildingDtoMapper {

    @Override
    public BuildingDto map(Building building) {
        if ( building == null ) {
            return null;
        }

        BuildingDto buildingDto = new BuildingDto();

        buildingDto.setId( building.getId() );
        buildingDto.setName( building.getName() );
        buildingDto.setAddress( building.getAddress() );
        buildingDto.setIndex( building.getIndex() );
        buildingDto.setSectorCode( building.getSectorCode() );
        buildingDto.setEnergyUnits( building.getEnergyUnits() );
        buildingDto.setEnergyUnitMax( building.getEnergyUnitMax() );

        return buildingDto;
    }

    @Override
    public Building map(BuildingDto building) {
        if ( building == null ) {
            return null;
        }

        Building building1 = new Building();

        building1.setId( building.getId() );
        building1.setName( building.getName() );
        building1.setAddress( building.getAddress() );
        building1.setIndex( building.getIndex() );
        building1.setSectorCode( building.getSectorCode() );
        building1.setEnergyUnits( building.getEnergyUnits() );
        building1.setEnergyUnitMax( building.getEnergyUnitMax() );

        return building1;
    }

    @Override
    public Building save(BuildingDto building) {
        if ( building == null ) {
            return null;
        }

        Building building1 = new Building();

        building1.setId( building.getId() );
        building1.setName( building.getName() );
        building1.setAddress( building.getAddress() );
        building1.setIndex( building.getIndex() );
        building1.setSectorCode( building.getSectorCode() );
        building1.setEnergyUnits( building.getEnergyUnits() );
        building1.setEnergyUnitMax( building.getEnergyUnitMax() );

        return building1;
    }
}
