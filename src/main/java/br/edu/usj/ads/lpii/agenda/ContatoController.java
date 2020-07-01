package br.edu.usj.ads.lpii.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContatoController {
    
    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping(value="/")
    public ModelAndView getListarTodos() {
        List<Contato> lista = contatoRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    @GetMapping(value="/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhe");
        modelAndView.addObject("contato", contato);
        return modelAndView;
    }

    @PostMapping(value="/")
    public String postCadastro(Contato contato) {
        contatoRepository.save(contato);
        return "redirect:/";
    }

    @PostMapping(value="/{contatoId}/telefone")
    public String postCadastroTelefone(@PathVariable Long contatoId, Telefone telefone) {
        Contato contato = contatoRepository.findById(contatoId).get();
        contato.getTelefones().add(telefone);
        contatoRepository.save(contato);
        return "redirect:/{contatoId}";
    }
    
    
}