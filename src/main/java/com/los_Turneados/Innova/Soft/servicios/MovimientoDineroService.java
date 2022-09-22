package com.los_Turneados.Innova.Soft.servicios;

import com.los_Turneados.Innova.Soft.modelos.MovimientoDinero;
import com.los_Turneados.Innova.Soft.repositorios.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class MovimientoDineroService {

    @Autowired
    private MovimientoDineroRepository movimientoDinero;

    public List<MovimientoDinero> listar(){
        return movimientoDinero.findAll();
    }

    public MovimientoDinero guardarMovimiento(MovimientoDinero movimiento){
        return movimientoDinero.save(movimiento);
    }

    public MovimientoDinero consultarMovimientoPorId(String id_transaccion){
        return movimientoDinero.findById(id_transaccion).get();
    }

    public MovimientoDinero actualizarMovimientos(MovimientoDinero movimiento){
        return movimientoDinero.save(movimiento);
    }

    public void eliminarMovimientoporId(String id_transaccion){
        movimientoDinero.deleteById(id_transaccion);
    }

    public MovimientoDinero actualizarPorId(String id, Map<Object,Object> objectMap){
        MovimientoDinero mov= movimientoDinero.findById(id).get();
        objectMap.forEach((key,value)-> {
            Field field = ReflectionUtils.findField(MovimientoDinero.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, mov, value);
        });
        return movimientoDinero.save(mov);
    }

}
