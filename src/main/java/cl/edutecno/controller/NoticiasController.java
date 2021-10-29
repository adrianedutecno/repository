package cl.edutecno.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller//etiqueta para indicar que es una clase controller
public class NoticiasController {
	
	//logger para dar información de lo que ocurre en la ejecución
	private final static Logger logger = LoggerFactory.getLogger(NoticiasController.class); 

	@RequestMapping(method = RequestMethod.GET,value = "/")
	//@GetMapping("/")
    public String Main(Model modelo) {
		
    	String nombre = "src/main/resources/static/noticias.txt";
    	ArrayList<String> publicaciones = new ArrayList<String>();

    	try {
    		
    		FileReader fr = new FileReader(nombre);//archivo que vamos a leer
    		BufferedReader br = new BufferedReader(fr);//buffer para almacenar el archivo que vamos leyendo
            String data = br.readLine();//leyendo cada linea y almacenandola en un string
            while (data != null) {//verificando si existen más lineas
            	publicaciones.add(data);//agregando cada linea de noticias a una posición del arreglo
//            	["Noticia@@datos de noticia@@enlace imagen noticia", "Noticia@@datos de noticia@@enlace imagen noticia", "Noticia@@datos de noticia@@enlace imagen noticia"]
            	logger.info("Se ha añadido correctamente una noticia");
                data = br.readLine();//leyendo la linea siguiente
            }
            br.close();
            fr.close();
            
    	} catch (Exception e) {
    		logger.error("Error leyendo el fichero "+ nombre + ": " + e);
    	}
    						//["Noticia@@datos de noticia@@enlace imagen noticia", "Noticia@@datos de noticia@@enlace imagen noticia", "Noticia@@datos de noticia@@enlace imagen noticia"]
    	String noticia1[] = publicaciones.get(0).split("@@");
    	String noticia2[] = publicaciones.get(1).split("@@");
    	String noticia3[] = publicaciones.get(2).split("@@");
    	String noticia4[] = publicaciones.get(3).split("@@");
    	String noticia5[] = publicaciones.get(4).split("@@");
    	
    	
    	modelo.addAttribute("noticia1",noticia1);
    	modelo.addAttribute("noticia2",noticia2);
    	modelo.addAttribute("noticia3",noticia3);
    	modelo.addAttribute("noticia4",noticia4);
    	modelo.addAttribute("noticia5",noticia5);
        return "index"; 
    }
	
	
	//@RequestMapping(method = RequestMethod.GET,value = "/")
	//@GetMapping("/")
    public ModelAndView Main() {
		
    	String nombre = "src/main/resources/static/noticias.txt";
    	ArrayList<String> publicaciones = new ArrayList<String>();
    	
    	try {
    		
    		FileReader fr = new FileReader(nombre);
    		BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            while (data != null) {
            	publicaciones.add(data);
            	logger.info("Se ha añadido correctamente una noticia");
                data = br.readLine();
            }
            br.close();
            fr.close();
            
    	} catch (Exception e) {
    		logger.error("Error leyendo el fichero "+ nombre + ": " + e);
    	}

    	String noticia1[] = publicaciones.get(0).split("@@");
    	String noticia2[] = publicaciones.get(1).split("@@");
    	String noticia3[] = publicaciones.get(2).split("@@");
    	String noticia4[] = publicaciones.get(3).split("@@");
    	String noticia5[] = publicaciones.get(4).split("@@");
    	
    	ModelAndView modelAndView = new ModelAndView();

    	modelAndView.addObject("noticia1",noticia1);
    	modelAndView.addObject("noticia2",noticia2);
    	modelAndView.addObject("noticia3",noticia3);
    	modelAndView.addObject("noticia4",noticia4);
    	modelAndView.addObject("noticia5",noticia5);
    	
    	modelAndView.setViewName("index");
        return modelAndView; 
    }
}
