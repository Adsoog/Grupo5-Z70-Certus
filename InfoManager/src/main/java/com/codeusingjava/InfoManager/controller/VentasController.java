package com.codeusingjava.InfoManager.controller;

import com.codeusingjava.InfoManager.model.Ventas;
import com.codeusingjava.InfoManager.model.exceptions.ResourceNotFoundExceptions;
import com.codeusingjava.InfoManager.repository.VentasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:4201",maxAge = 3600)
@RestController
@RequestMapping("/api/v5")
public class VentasController {
    @Autowired
    private VentasRepositorio employeeRepository;


    @GetMapping("/employees")
    public List<Ventas> getAllEmployees()
    {
        return employeeRepository.findAll();


    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Ventas> getEmployeeId(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundExceptions {

        Ventas employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundExceptions("Ventas not found for this id : :" + employeeId));
        return ResponseEntity.ok(employee);

    }


    @PostMapping("/employees")
    public Ventas createEmployee(@Validated @RequestBody Ventas employee) {

        return employeeRepository.save(employee);
    }



    @PutMapping("/employees/{id}")
    public ResponseEntity<Ventas> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                 @Validated @RequestBody Ventas employeeDetails) throws ResourceNotFoundExceptions{
        Ventas employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Ventas not found for this id :  :" + employeeId));

        employee.setIdplato(employeeDetails.getIdplato());
        employee.setCedcliente(employeeDetails.getCedcliente());
        employee.setCedusuario(employeeDetails.getCedusuario());
        employee.setDiscapacidad(employeeDetails.getDiscapacidad());
        employee.setFecha(employeeDetails.getFecha());
        employee.setCantidad(employeeDetails.getCantidad());
        employee.setTipopago(employeeDetails.getTipopago());
        employee.setDescuento(employeeDetails.getDescuento());
        employee.setSubtotal(employeeDetails.getSubtotal());
        employee.setTotal(employeeDetails.getTotal());



        final Ventas updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);


    }



    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee (@PathVariable (value= "id") Long employeeId)
            throws ResourceNotFoundExceptions{

        Ventas employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Ventas not found for this id : : " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;

    }
}
