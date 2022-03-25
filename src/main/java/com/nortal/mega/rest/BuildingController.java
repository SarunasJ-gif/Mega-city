package com.nortal.mega.rest;

import com.nortal.mega.persistence.entity.BuildingDbo;
import com.nortal.mega.service.Building;
import com.nortal.mega.service.BuildingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/mega/building")
@Log4j2
public class BuildingController {

    private final BuildingService buildingService;
    private final BuildingDtoMapper buildingDtoMapper;

    @GetMapping
    public ResponseEntity<List<BuildingDto>> getAll() {
        return ResponseEntity.ok(
                buildingService.findAll().stream().map(buildingDtoMapper::map).collect(Collectors.toList())
        );
    }

    @GetMapping("{buildingId}")
    public ResponseEntity<BuildingDto> getBuildingById(@PathVariable Long buildingId) {
        return ResponseEntity.ok(buildingDtoMapper.map(buildingService.findBuildingById(buildingId)));
    }

    @PostMapping("/new")
    public ResponseEntity<BuildingDto> createBuilding(@RequestBody @Valid BuildingDto building) {
        BuildingDbo savedBuilding = buildingService.save(buildingDtoMapper.map(building));
        log.info("Saved building id: {}", savedBuilding.getId());
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<String> updateBuilding(@RequestBody @Valid BuildingDto building) {
        Long id = building.getId();
        Building updateBuilding = buildingService.findBuildingById(id);
        if (building.getAddress() != null) {
            updateBuilding.setAddress(building.getAddress());
        }
        if (building.getIndex() != null && building.getIndex().startsWith("NO")) {
            updateBuilding.setIndex(building.getIndex());
        } else {
            return new ResponseEntity<String>("Index has to start with NO", HttpStatus.BAD_REQUEST);
        }
//        if (building.getSectorCode() != null) {
//            updateBuilding.setSectorCode(building.getSectorCode());
//        }
        if (building.getEnergyUnits() != null && building.getEnergyUnitMax() != null && building.getEnergyUnits() > building.getEnergyUnitMax()) {
            return new ResponseEntity<String>("This building can take a maximum of " + building.getEnergyUnitMax() + " units", HttpStatus.BAD_REQUEST);
        } else {
            updateBuilding.setEnergyUnits(building.getEnergyUnits());
        }
        buildingService.save(updateBuilding);
        return ResponseEntity.ok().build();
    }
}
