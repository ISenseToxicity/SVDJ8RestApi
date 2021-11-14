package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.Dto.RouteDto;
import nl.hsleiden.svdj8.models.tables.Route;
import nl.hsleiden.svdj8.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(value = "/route")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {

        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<RouteDto> addRoute(@RequestBody final RouteDto routeDto) {
        Route route = routeService.addRoute(Route.from(routeDto));
        return new ResponseEntity<>(routeDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public ResponseEntity<RouteDto> getItem(@PathVariable final Long id) {
        Route route = routeService.getRoute(id);
        return new ResponseEntity<>(RouteDto.from(route), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RouteDto> deleteRoute(@PathVariable final Long id) {
        Route route = routeService.deleteRoute(id);
        return new ResponseEntity<>(RouteDto.from(route), HttpStatus.OK);
    }
}
