package com.los_Turneados.Innova.Soft.servicios;

import com.los_Turneados.Innova.Soft.modelos.Empleado;
import com.los_Turneados.Innova.Soft.modelos.MovimientoDinero;
import com.los_Turneados.Innova.Soft.repositorios.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;


import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository Empleado;

    public List<Empleado> listar(){
        return Empleado.findAll();
    }

    public Empleado guardarEmpleado(Empleado empleado){
        return Empleado.save(empleado);
    }

    public Empleado consultarEmpleadoPorID(Integer id_empleado){
        return Empleado.findById(id_empleado).get();
    }

    public Empleado actualizarEmpleado(Empleado empleado){
        return Empleado.save(empleado);
    }

    public Empleado actualizarPorId(Integer id, Map<Object,Object> objectMap){
        Empleado mov= Empleado.findById(id).get();
        objectMap.forEach((key,value)-> {
            Field field = ReflectionUtils.findField(MovimientoDinero.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, mov, value);
        });
        return Empleado.save(mov);
    }

    public void eliminarEmpleadoPorId(Integer id_empleado){
        Empleado.deleteById(id_empleado);

    }
}
