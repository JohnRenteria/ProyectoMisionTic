package com.los_Turneados.Innova.Soft.controladores;

import com.los_Turneados.Innova.Soft.modelos.Empleado;
import com.los_Turneados.Innova.Soft.modelos.Empresa;
import com.los_Turneados.Innova.Soft.servicios.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

//@RequestMapping ("/empleado")
@Controller
//@RestController
public class ControladoresEmpleado {

    @Autowired
    private EmpleadoService empleadoService;


   @GetMapping("empleado")
    public String listar(Model modelo){
        modelo.addAttribute("Empleado", empleadoService.listar());
        return ("TabladeRegistroUsuario");
    }

    @GetMapping("empleado/nuevo")
    public String RegistroUsuario(Model modelo){
        modelo.addAttribute("empleadoinsertar", new Empleado());
        return "RegistrarUsuario";
    }

    @PostMapping("empleado/guardar")
    public String InsertarUsuario( Empleado Emp){
        empleadoService.guardarEmpleado(Emp);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/actualizar/{dato}")
    public String ActualizarEmpleado(@PathVariable ("dato") String dato, Model modelo){
        Empleado empleado=empleadoService.consultarEmpleadoPorID(dato);
        modelo.addAttribute("empleadoactualizar", empleado);
        return "RegistroActualizar";
    }

    @PostMapping("empleado/actualizar")
    public String actualizar(Empleado Emp){
        empleadoService.actualizarEmpleadoProrId(Emp);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/eliminar/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") String id){
        empleadoService.eliminarEmpleadoPorId(id);
        return ("redirect:/empleado");
    }
}

  /*  @GetMapping
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
*/