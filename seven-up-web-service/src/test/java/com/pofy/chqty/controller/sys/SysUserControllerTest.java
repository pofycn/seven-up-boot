package com.pofy.chqty.controller.sys;

import com.pofy.chqty.RunService;
import com.pofy.chqty.enums.ResultEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * function - SysUserController 单元测试类
 * @author POFY
 * @date 2018-06-08
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunService.class)
public class SysUserControllerTest {

    @Autowired
    WebApplicationContext wac;

    private MockMvc mvc;

    private MockHttpSession session;

    @Before
    public void setUp(){
        // 初始化MockMvc对象
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
    }

    @Test
    public void getSysUser() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/v1/sysUser/allUsers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$..code").value(ResultEnum.Y.getCode()))
                .andExpect(MockMvcResultMatchers.jsonPath("$..userId").isNotEmpty())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllSysUser() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void updateUser() {
    }
}