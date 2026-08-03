

package com.frisorsystem.BaseBarberSystem.controller;

import com.frisorsystem.BaseBarberSystem.model.Service;
import com.frisorsystem.BaseBarberSystem.repository.ServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")


public class ServiceController {

    private final ServiceRepository serviceRepository;


    public ServiceController(ServiceRepository serviceRepository){
        this.serviceRepository = serviceRepository;
    }


    // Get all services
    @GetMapping
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }


    // Get service by id
    @GetMapping("/{id}")
    public Service getServiceById(@PathVariable Long id){
        return serviceRepository.findById(id).orElse(null);
    }


    // Create service
    @PostMapping
    public Service createService(@RequestBody Service service){
        return serviceRepository.save(service);
    }


    // Delete service
    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id){
        serviceRepository.deleteById(id);
    }


}