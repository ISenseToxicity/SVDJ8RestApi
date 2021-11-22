package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.RouteDAO;
import nl.hsleiden.svdj8.models.tables.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/route", method = RequestMethod.GET)
public class RouteController {

    @Autowired
    public final RouteDAO routeDAO;

    public RouteController(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Route>> getAllRoutes() {
        return new ResponseEntity<>(routeDAO.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Route> getRoute(@PathVariable final Long id) {
        return new ResponseEntity<>(routeDAO.getById(id), HttpStatus.OK);
    }
}
