package com.CursoSBDI.core.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.CursoSBDI.core.services.IMiServicio;

//@Component("miServicioSimple")
//@Primary
public class MiServicioImpl implements IMiServicio {

	@Override
	public String operacion() {
		return "Ejecutando Algun Proceso Batch Simple";
	}

	

}
