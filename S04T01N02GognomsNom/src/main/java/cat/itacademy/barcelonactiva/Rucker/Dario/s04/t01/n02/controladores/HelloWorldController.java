package cat.itacademy.barcelonactiva.Rucker.Dario.s04.t01.n02.controladores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@Controller
public class HelloWorldController {

    private static Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
    @GetMapping("/HelloWorld")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "unknown") String name, Model model){
        LOG.info("Verificacion funcionamiento metodo saluda punto 1");
        model.addAttribute("name", name);
        LOG.info("Verificacion funcionamiento metodo saluda punto 2");
        return "greeting";
    }

    @GetMapping(value =  {"/HelloWorld2", "/HelloWorld2/{name}"})
    public String greeting2(@PathVariable Optional<String> name, Model model) {
        String name2;
        LOG.info("Verificacion funcionamiento metodo greeting2 punto 1");
        if(!name.isPresent()){
            return "greetingNoName";
        }else {
            name2 = name.get();
        }

        model.addAttribute("name", name2);
        LOG.info("Verificacion funcionamiento metodo greeting2 punto 2");
        return "greeting";
    }



}
