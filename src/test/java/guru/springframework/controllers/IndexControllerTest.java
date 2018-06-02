package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {
    // we need the service implementation.
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    IndexController controller;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        // create instance for our controller.
        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String viewName = controller.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService, times (1)).getRecipes();
    }
}