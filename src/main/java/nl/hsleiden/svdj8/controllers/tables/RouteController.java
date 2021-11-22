package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.RouteDAO;
import nl.hsleiden.svdj8.models.tables.Route;
import nl.hsleiden.svdj8.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    public final RouteDAO routeDAO;

    @Autowired
    public final RouteRepository routeRepository;

    public RouteController(RouteDAO routeDAO, RouteRepository routeRepository) {
        this.routeDAO = routeDAO;
        this.routeRepository = routeRepository;
    }

    @GetMapping(value = "/route/all")
    public ResponseEntity<List<Route>> getAllRoutes() {
        return new ResponseEntity<>(routeDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> getRoute(@PathVariable final Long id) {
        return new ResponseEntity<>(routeDAO.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/route/{id}", method = RequestMethod.PUT)
    Route editRoute(@RequestBody Route editRoute, @PathVariable Long id) throws Exception {

        return routeRepository.findById(id)
                .map(route -> {
                    route.setTotalTime(editRoute.getTotalTime());
//                    route.setResult(editRoute.getResult());
                    return routeRepository.save(route);
                })
                .orElseThrow(() -> new Exception(
                        "No route found with id " + id + "\""));
    }

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    Route addRoute(@RequestBody Route newRoute) {
        return routeRepository.save(newRoute);
    }

    @DeleteMapping("/route/{id}")
    void deleteRoute(@PathVariable Long id) {
        routeRepository.deleteById(id);
    }


}
