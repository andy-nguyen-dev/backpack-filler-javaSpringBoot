package com.example.power_reviews;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class BackpackControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnOkStatus_whenBagSizeOver11() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/backpack/fill")
                        .param("bagSize", "27")) // Replace "someParamName" with the actual parameter name
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBadRequest_whenBagSizeUnder11() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/backpack/fill")
                        .param("bagSize", "7")) // Replace "someParamName" with the actual parameter name
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnBadRequest_whenBagSizeParamMissing() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/backpack/fill")
                        .param("bagSize", "")) // Empty string, not null
                .andExpect(status().isBadRequest());
    }

}
