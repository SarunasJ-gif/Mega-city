package com.nortal.mega.persistence;

import com.nortal.mega.persistence.entity.BuildingDbo;
import com.nortal.mega.service.Building;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-03T19:54:32+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class BuildingDboMapperImpl implements BuildingDboMapper {

    @Override
    public Building map(BuildingDbo dbo) {
        if ( dbo == null ) {
            return null;
        }

        Building building = new Building();

        building.setId( dbo.getId() );
        building.setName( dbo.getName() );
        building.setAddress( dbo.getAddress() );
        building.setIndex( dbo.getIndex() );
        building.setSectorCode( dbo.getSectorCode() );
        building.setEnergyUnits( dbo.getEnergyUnits() );
        building.setEnergyUnitMax( dbo.getEnergyUnitMax() );

        return building;
    }

    @Override
    public BuildingDbo map(Building building) {
        if ( building == null ) {
            return null;
        }

        BuildingDbo buildingDbo = new BuildingDbo();

        buildingDbo.setId( building.getId() );
        buildingDbo.setName( building.getName() );
        buildingDbo.setAddress( building.getAddress() );
        buildingDbo.setIndex( building.getIndex() );
        buildingDbo.setSectorCode( building.getSectorCode() );
        buildingDbo.setEnergyUnits( building.getEnergyUnits() );
        buildingDbo.setEnergyUnitMax( building.getEnergyUnitMax() );

        return buildingDbo;
    }
}
