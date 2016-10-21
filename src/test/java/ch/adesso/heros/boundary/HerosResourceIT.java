package ch.adesso.heros.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import static com.airhacks.rulz.jaxrsclient.JAXRSClientProvider.buildWithURI;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class HerosResourceIT {

    @Rule
    public JAXRSClientProvider commandProvider = buildWithURI("http://adesso.disruptor.ninja:31080/hero-command/resources/heros");

    @Test
    public void containsSpiderman() {
        String testResponse = commandProvider.target().request().get(String.class);
        assertThat(testResponse, containsString("Spiderman"));
    }

}
