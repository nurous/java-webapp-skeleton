package your_package.web.views.thingy;

import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import your_package.domain.model.Thingy;
import your_package.web.views.ViewTest;

import static org.junit.Assert.*;

public class ThingyIndexTest extends ViewTest {

    public static final String VIEW_NAME = "thingy/index";

    @Test
    public void shouldDisplayListOfThingies() throws Exception {
        Model model = new BindingAwareModelMap() {{
            put("thingyList", new Thingy[]{new Thingy("Bob")});
        }};
        String result = render(VIEW_NAME, model);

        // TODO: Make this a sensible assertion and implement the view accordingly
        assertEquals("INDEX", result.trim());
    }
}
