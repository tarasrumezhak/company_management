package com.kindgeek.company_management.controller;

import com.kindgeek.company_management.entity.Position;
import com.kindgeek.company_management.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/position")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Position addNewPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @GetMapping
    public @ResponseBody Iterable<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping(path="{id}")
    public @ResponseBody Position getPositionById(@PathVariable("id") Long id) {
        return positionService.getPositionById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePosition(@PathVariable Long id) {
        positionService.deletePosition(id);
    }

    @PutMapping(path = "{id}")
    public Position updatePosition(@PathVariable("id") Long id, @RequestBody Position newPosition) {
        return positionService.updatePosition(id, newPosition);
    }
}
