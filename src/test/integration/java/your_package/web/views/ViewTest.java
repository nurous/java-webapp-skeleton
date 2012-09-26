package your_package.web.views;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import javax.annotation.Resource;
import java.util.Locale;

// It would be good if we could replace this with a 'spring-test'/'spring-test-mvc' class to remove the dependency on 'javax.servlet:javax.servlet-api:+'
@ContextConfiguration(locations = {"classpath:spring/mvc-config.xml"}, loader = MockServletContextLoader.class)
public abstract class ViewTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private ViewResolver viewResolver;

    private final Locale locale;

    public ViewTest() {
        this(null);
    }

    public ViewTest(Locale locale) {
        this.locale = (locale == null) ? Locale.getDefault() : locale;
    }

    protected String render(String template, Model model) throws Exception {
        View view = viewResolver.resolveViewName(template, locale);

        MockHttpServletRequest request = prepareRequest();
        MockHttpServletResponse response = prepareResponse();

        view.render(model.asMap(), request, response);

        return response.getContentAsString();
    }

    private MockHttpServletResponse prepareResponse() {
        return new MockHttpServletResponse();
    }

    private MockHttpServletRequest prepareRequest() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addPreferredLocale(locale);
        return request;
    }
}
