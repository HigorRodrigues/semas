package com.semas.controller;

import java.util.Arrays;
import java.util.List;

import com.semas.enums.Bairros;
import com.semas.enums.TipoBeneficio;
import com.semas.model.Usuario;
import com.semas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private Usuarios usuarios;

    public final static String HOME = "home";

    @RequestMapping()
    public ModelAndView home() {
        return new ModelAndView(HOME);
    }

    @RequestMapping("/novo-usuario")
    public ModelAndView novoUsuario(){
        ModelAndView mv = new ModelAndView("CadastroUsuario");
        mv.addObject(new Usuario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar( @Validated Usuario usuario, Errors errors, 
            RedirectAttributes attr ){

        if( errors.hasErrors() ){
            return "CadastroUsuario";
        }
        
        usuario.setPasta("A1");
        usuarios.save(usuario);
        attr.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
        return "redirect:/user";
    }

    @RequestMapping("/pesquisar")
    public ModelAndView pesquisar(){
        List<Usuario> todosUsuarios = usuarios.findAll();
        ModelAndView mv = new ModelAndView("Pesquisar");
        mv.addObject("todosUsuarios", todosUsuarios);
        return mv;
    }

    @RequestMapping("/mostrar-usuario/{codigo}")
    public ModelAndView mostrarUsuario( @PathVariable("codigo") Usuario usuario){
        ModelAndView mv = new ModelAndView("Abrir");
        mv.addObject(usuario);
        return mv;
    }

    @RequestMapping("/editar-usuario/{codigo}")
    public ModelAndView editarUsuario( @PathVariable("codigo") Usuario usuario){
        ModelAndView mv = new ModelAndView("CadastroUsuario");        
        mv.addObject(usuario);
        return mv;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }    

    @ModelAttribute("todosBairros")
    public List<Bairros> todosBairros(){
        return Arrays.asList(Bairros.values());
    }

    @ModelAttribute("todosTiposBeneficio")
    public List<TipoBeneficio> todosTiposBeneficio(){
        return Arrays.asList(TipoBeneficio.values());
    }
    
}