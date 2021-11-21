package nl.hsleiden.svdj8.daos;

import nl.hsleiden.svdj8.models.tables.Route;
import nl.hsleiden.svdj8.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

@Component
public class RouteDAO {
    @Autowired
    private RouteRepository routeRepository;

    public RouteDAO(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public ArrayList<Route> getAll(){
        ArrayList<Route> routes = (ArrayList<Route>) this.routeRepository.findAll();
        routes.sort(Comparator.comparingLong(Route::getRouteID));
        return routes;
    }

    public Route getFirst() {
        return getAll().get(0);
    }

    public Route getById(long id) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        return optionalRoute.orElse(null);
    }

}
