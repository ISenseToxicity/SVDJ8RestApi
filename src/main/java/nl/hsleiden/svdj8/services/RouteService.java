package nl.hsleiden.svdj8.services;

import nl.hsleiden.svdj8.exceptions.NoRouteFoundException;
import nl.hsleiden.svdj8.models.tables.Route;
import nl.hsleiden.svdj8.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public List<Route> getRoutes() {
        return StreamSupport
                .stream(routeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Route getRoute(Long id) {
        return routeRepository.findById(id).orElseThrow(() ->
                new RuntimeException(new NoRouteFoundException(id)));
    }

    public Route deleteRoute(Long id) {
        Route route = getRoute(id);
        routeRepository.delete(route);
        return route;
    }

    public Route editRoute(Long id, Route route) {
        Route routeToEdit = getRoute(id);
        routeToEdit.setTotalTime(routeToEdit.getTotalTime());
        routeToEdit.setGivenAnswerList(route.getGivenAnswerList());
        routeToEdit.setResultId(route.getResultId());
        return route;
    }
}
