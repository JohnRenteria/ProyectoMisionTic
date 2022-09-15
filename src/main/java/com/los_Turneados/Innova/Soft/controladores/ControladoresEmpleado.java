package com.los_Turneados.Innova.Soft.controladores;

import com.los_Turneados.Innova.Soft.modelos.Empleado;
import com.los_Turneados.Innova.Soft.servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping ("/empleado")
@RestController
public class ControladoresEmpleado {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listar(){
        return empleadoService.listar();
    }

    @GetMapping("/{id}")
    public Empleado consultarPorID(@PathVariable("id") Integer id){
        return empleadoService.consultarEmpleadoPorID(id);
    }

    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado){
        return empleadoService.guardarEmpleado(empleado);
    }

    @PutMapping
    public Empleado actualizar(@RequestBody Empleado empleado){
        return empleadoService.actualizarEmpleado(empleado);
    }
    @PatchMapping("/{id}")
    public Empleado actualizarPorId(@PathVariable ("id") Integer id, @RequestBody Map <Object,Object> objectMap){
        return empleadoService.actualizarPorId(id, objectMap);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable ("id") Integer id){
        empleadoService.eliminarEmpleadoPorId(id);
    }
}
