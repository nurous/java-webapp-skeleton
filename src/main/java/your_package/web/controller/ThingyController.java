package your_package.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(ThingyController.ROUTE)
public class ThingyController {

    static final String ROUTE = "/thingy";

    @RequestMapping
    public String index() {
        return viewName("index");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String create() {
        return viewName("create");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable String id) {
        return viewName("show");
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
