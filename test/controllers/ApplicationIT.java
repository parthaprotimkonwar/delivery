package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.route;
import static play.test.Helpers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import play.GlobalSettings;
import play.mvc.Result;
import play.test.WithApplication;

/**
 * An integration test focused on testing our routes configuration and interactions with our controller.
 * However we can mock repository interactions here so we don't need a real db.
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationIT extends WithApplication {

    private static final Long SOME_ID = 1L;
    private static final CharSequence SOME_CONTENT_MESSAGE = "Found id: 1 of person/people";

    /*private Application app;

    @Mock
    private PersonRepository repo;*/

    @Before
    public void setUp() throws Exception {
        //app = new Application(repo);

        final GlobalSettings global = new GlobalSettings() {
            @Override
            public <A> A getControllerInstance(Class<A> aClass) {
                return (A) app;
            }
        };

        start(fakeApplication(global));
    }

    @Test
    public void indexSavesDataAndReturnsId() {
        /*final Person person = new Person();
        person.id = SOME_ID;
        when(repo.save(any(Person.class))).thenReturn(person);
        when(repo.findOne(SOME_ID)).thenReturn(person);*/

        final Result result = route(fakeRequest(GET, "/"));

        assertEquals(OK, status(result));
        assertTrue(contentAsString(result).contains(SOME_CONTENT_MESSAGE));
    }

}
