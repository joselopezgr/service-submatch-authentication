//package com.jlg.submatch.service.user.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jlg.submatch.service.dto.authentication.UserRequestDTO;
//import com.jlg.submatch.service.user.service.UserDomainService;
//import org.junit.jupiter.api.*;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(CreateUserController.class)
//public class CreateUserControllerTest {
//
//    @MockBean
//    UserDomainService authenticationService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @BeforeEach
//    void setUp(WebApplicationContext applicationContext) {
//        mockMvc = MockMvcBuilders
//                .webAppContextSetup(applicationContext)
//                .build();
//    }
//
//    @Nested
//    @DisplayName("Create a User record")
//    class CreateTests {
//        @Mock
//        private User mockUser;
//
//        @Mock
//        private UserRequestDTO userRequest;
//
//        @BeforeEach
//        void setUp() {
//            mockUser = User.builder()
//                    .id("66168ba0da31c80f84ee9999")
//                    .name("name")
//                    .email("email")
//                    .password("password")
//                    .phone("phone")
//                    .address("address")
//                    .role(UserRole.ADMIN)
//                    .build();
//
//            UserRequestDTO userRequest = new UserRequestDTO();
//            userRequest.setName("name");
//            userRequest.setEmail("email");
//            userRequest.setPassword("password");
//            userRequest.setPhone("phone");
//            userRequest.setAddress("address");
//            userRequest.setRole(String.valueOf(UserRole.ADMIN));
//        }
//
//        @Test
//        @DisplayName("will return 201 if a user record was created")
//        void shouldCreateUserRecord() throws Exception {
//
//
//            when(authenticationService.create(any(User.class))).thenReturn(mockUser);
//
//            mockMvc.perform(post("/user")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(objectMapper.writeValueAsString(userRequest)))
//                    .andExpect(status().isCreated());}
//    }
//}
