package com.Datarata.Datagenerator.api.data;

import com.datarata.datagenerator.api.data.DataController;
import com.datarata.datagenerator.service.DataService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

// import static org.junit.jupiter.api.Assertions.fail;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(DataController.class)
public class DataControllerTest {

    @MockBean
    private DataService dataService;

    @Autowired
    private MockMvc localMockMvc;
    
    @Test
    public void testGetObserveesLinkedWithDeviceWithFilter() {
        try {
            int size = 10;
            // Mockito.when(this.dataService.generateWord(size)).thenReturn("smart_word");

            // this.localMockMvc.perform(get("/data/char/10"))
            // .andExpect(status().isOk())
            // .andExpect(content().string("smart_word"));

            // Mockito.verify(this.dataService).generateWord(10);
            
        } catch (Exception e) {
            e.printStackTrace();
            // fail(e.getMessage());
        }
    }
}