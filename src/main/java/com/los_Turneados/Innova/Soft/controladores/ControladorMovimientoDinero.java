package com.los_Turneados.Innova.Soft.controladores;

import com.los_Turneados.Innova.Soft.modelos.MovimientoDinero;
import com.los_Turneados.Innova.Soft.servicios.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//@RequestMapping ("/MovimientoDinero")
//@RestController
@Controller
public class ControladorMovimientoDinero {

    @Autowired
    private MovimientoDineroService transaccion;

    @GetMapping ("Movimientos")
    public String listar(Model model){
        model.addAttribute("MovimientoDeDinero", transaccion.listar());return ("tablaMovimiento");
    }

    @GetMapping("/{b}")
    public MovimientoDinero consultar(@PathVariable("b") String id){
        return transaccion.consultarMovimientoPorId(id);
    }

    @GetMapping("Movimientos/nuevo")
    public String formularioregistro(Model modelo){
        modelo.addAttribute("insertarMovimiento", new MovimientoDinero());
        return "formulariodemovimientos";
    }

    @PostMapping("Movimientos/guardar")
    public String insertar(MovimientoDinero movimientoDinero){
        transaccion.guardarMovimiento(movimientoDinero);
        return "redirect:/Movimientos";
    }

    @GetMapping("Movimientos/actualizar/{dato}")
    public String formularioActualizar(@PathVariable("dato")String dato,Model modelo){
        MovimientoDinero movimiento = transaccion.consultarMovimientoPorId(dato);
        modelo.addAttribute("actualizarmovimiento", movimiento);
        return "ActualizarMovimientos";
    }

    @PostMapping("Movimientos/actualizar")
    public String actualizar(MovimientoDinero movimientoDinero){
        transaccion.actualizarMovimientos(movimientoDinero);
        return "redirect:/Movimientos";
    }

    @GetMapping("Movimientos/eliminar/{dato}")
    public String eliminarPorId(@PathVariable("dato")String id){
        transaccion.eliminarMovimientoporId(id);
        return "redirect:/Movimientos";
    }

//    @PutMapping
//    public MovimientoDinero actualizar (@RequestBody MovimientoDinero movimientoDinero){
//        return transaccion.actualizarMovimientos(movimientoDinero);
//    }
//
//    @DeleteMapping("/{id}")
//    public void eliminarPorId (@PathVariable("id") Integer id){
//        transaccion.eliminarMovimientoporId(id);
//    }
//
//    @PatchMapping("/{id}")
//    public MovimientoDinero actualizarPorId(@PathVariable ("id") Integer id, @RequestBody Map<Object,Object> objectMap){
//        return transaccion.actualizarPorId(id,objectMap);
//    }
}
