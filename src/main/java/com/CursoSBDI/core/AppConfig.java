package com.CursoSBDI.core;


import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.CursoSBDI.core.models.domain.ItemFactura;
import com.CursoSBDI.core.models.domain.Producto;
import com.CursoSBDI.core.serviceImpl.MiServicioComplejoImpl;
import com.CursoSBDI.core.serviceImpl.MiServicioImpl;
import com.CursoSBDI.core.services.IMiServicio;

@Configuration
public class AppConfig {
		
		@Primary
		@Bean("MiServicioSimple")
		public IMiServicio registrarMiServicio() {
			return new MiServicioImpl();
		}
		
		
		@Bean("MiServicioComplejo")
		public IMiServicio registrarMiServicioComplejo() {
			return new MiServicioComplejoImpl();
		}
		
		@Bean("ItemsFactura")
		public List<ItemFactura> registrarItems(){
			Producto producto1 = new Producto("Camara Sony", 1020);
			Producto producto2 = new Producto("Bicicleta", 200);
			
			ItemFactura linea1= new ItemFactura(producto1, 2);
			ItemFactura linea2= new ItemFactura(producto2, 4);
			
			return Arrays.asList(linea1,linea2);
		
		}
}
