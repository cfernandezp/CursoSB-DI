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
		
		@Bean("itemsFactura")
		public List<ItemFactura> registrarItems(){
			Producto producto1 = new Producto("Camara Sony", 100);
			Producto producto2 = new Producto("Bicicleta Montañera Monark", 200);
			
			ItemFactura linea1= new ItemFactura(producto1, 2);
			ItemFactura linea2= new ItemFactura(producto2, 4);
			
			return Arrays.asList(linea1,linea2);		
		}
		
		@Bean("itemsFacturaOficina")
		@Primary
		public List<ItemFactura> registrarItemsOficina(){
			Producto producto1 = new Producto("Monitor LG LED 24'' ", 349);
			Producto producto2 = new Producto("NoteBook Azuz C500", 200);
			Producto producto3 = new Producto("Impresora HP", 566);
			Producto producto4 = new Producto("Silla Gamer", 567);
			
			ItemFactura linea1= new ItemFactura(producto1, 2);
			ItemFactura linea2= new ItemFactura(producto2, 4);
			ItemFactura linea3= new ItemFactura(producto3, 4);
			ItemFactura linea4= new ItemFactura(producto4, 4);
			
			return Arrays.asList(linea1,linea2,linea3,linea4);
		
		}
		
}
