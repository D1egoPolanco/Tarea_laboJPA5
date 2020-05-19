package com.uca.capas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.app.dao.EstudianteDAO;
import com.uca.capas.app.domain.Estudiante;

import java.util.List;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private EstudianteDAO estudianteDAO;

    @RequestMapping("/inicio")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        Estudiante inicio = new Estudiante();
        mav.addObject("estudiante",inicio);
        mav.setViewName("index");
        return mav;
    }
    @RequestMapping("/insertarEstudiante")
    public ModelAndView insert(@Valid @ModelAttribute Estudiante estudiante, BindingResult result){
        ModelAndView mav = new ModelAndView();
        
        System.out.println(result + " errores");
        if(result.hasErrors()) {
        	mav.setViewName("index");
        }else {
        	 try {
                 estudianteDAO.insert(estudiante);
                 Estudiante student = new Estudiante();
                 mav.addObject("estudiante", student);
                 mav.setViewName("index");
             }catch (Exception e){
                 e.printStackTrace();
             }
        }
        return mav;
    }
    @RequestMapping("/lista")
    public ModelAndView lista(){
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;
        try {
            estudiantes = estudianteDAO.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("lista");
        return mav;
    }
}
