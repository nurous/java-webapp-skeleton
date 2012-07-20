package your_package.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import your_package.domain.model.Thingy;
import your_package.domain.service.CRUDService;

import javax.annotation.Resource;

@Controller
@RequestMapping(ThingyController.ROUTE)
public class ThingyController {

    static final String ROUTE = "/thingy";

    @Resource
    private CRUDService<Thingy> service;

    @RequestMapping
    public String index() {
        return viewName("index");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create(@ModelAttribute("thingy") Thingy thingy) {
        service.create(thingy);
        return "redirect:" + viewName(thingy.getId().toString());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable String id) {
        Thingy thingy = service.retrieve(Integer.parseInt(id));
        return new ModelAndView(viewName("show"), "thingy", thingy);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable String id) {
        return viewName("edit");
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newObject() {
        return viewName("newObject");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id) {
        return viewName("update");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable String id) {
        return viewName("destroy");
    }

    private String viewName(String name) {
        return String.format("%s/%s", ROUTE, name);
    }

}
