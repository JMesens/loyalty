package be.ordina.award;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AwardApplication.class)
@WebAppConfiguration(value = "src/main/resources")
@IntegrationTest("server.port:0")
public class AwardServerDocumentation {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation("target/generated-snippets");

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    public void awards() throws Exception {
        this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("awards"));
    }

    @Test
    public void award() throws Exception {
        this.mockMvc.perform(get("/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("award"));
    }

    @Test
    public void awardLoyaltyProgram() throws Exception {
        this.mockMvc.perform(get("/loyaltyProgram/{loyaltyProgramId}", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("awardLoyaltyProgram", pathParameters(parameterWithName("loyaltyProgramId")
                        .description("The id of the loyalty program you want to request."))));
    }

    @Test
    public void awardEligible() throws Exception {
        this.mockMvc.perform(get("/eligibleAwards/{loyaltyProgramId}/{points}", 1, 150).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("awardEligible",pathParameters(parameterWithName("loyaltyProgramId").description("The loyalty program to search in."),
                        parameterWithName("points").description("The available amount of points."))));
    }

}