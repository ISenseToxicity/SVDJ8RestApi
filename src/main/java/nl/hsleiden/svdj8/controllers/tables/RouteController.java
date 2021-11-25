package nl.hsleiden.svdj8.controllers.tables;

import nl.hsleiden.svdj8.daos.RouteDAO;
import nl.hsleiden.svdj8.models.tables.Route;
import nl.hsleiden.svdj8.services.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;

@RestController
public class RouteController {

    @Autowired
    public final RouteDAO routeDAO;

    public RouteController(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }

    @GetMapping(value = "/route/all")
    public List<Route> getAllRoutes() {
        return routeDAO.getAll();
    }

    @GetMapping(value = "/route/{id}")
    public Route getRoute(@PathVariable final Long id) {
        return routeDAO.getById(id);
    }

    @PutMapping(value = "/route/{id}")
    public Route editRoute(@RequestBody Route editRoute, @PathVariable Long id) throws Exception {

        return routeDAO.getByIdOptional(id)
                .map(route -> {
                    route.setTotalTime(editRoute.getTotalTime());
                    return routeDAO.addRoute(route);
                })
                .orElseThrow(() -> new Exception(
                        "No route found with id " + id + "\""));
    }

    @GetMapping(value = "/route")
    public Route addRoute(@RequestBody Route newRoute) {
        return routeDAO.addRoute(newRoute);
    }

    @DeleteMapping("/route/{id}")
    public void deleteRoute(@PathVariable Long id) {
        routeDAO.deleteRoute(id);
    }

    @GetMapping("/route/generatepdf/")
    HttpEntity<byte[]> createPDF(@RequestBody Route route) {
        ByteArrayOutputStream baos = PDFService.createPDF(route);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=result");
        headers.setContentLength(baos.toByteArray().length);
        return new HttpEntity<byte[]>(baos.toByteArray(), headers);
    }
}
