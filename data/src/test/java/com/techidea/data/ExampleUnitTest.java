package com.techidea.data;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.techidea.data.cache.serializer.JsonSerializer;
import com.techidea.domain.entity.LoginUser;

import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.PUT;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testJsonSerializer() {
        JsonSerializer<LoginUser> jsonSerializer = new JsonSerializer<>();
        LoginUser loginUser = new LoginUser();
        loginUser.setId("1");
        loginUser.setPosCode("1111");
        loginUser.setPosId("aaa");
        loginUser.setToken("asdfga");
        loginUser.setUserId("1234");
        loginUser.setUsername("1234");
        loginUser.setUserType("1111");
        String jsonStr = jsonSerializer.serialize(loginUser);
        System.out.println(jsonStr);
        LoginUser loginUser1 = new LoginUser();
        loginUser1 = jsonSerializer.deserialize(jsonStr, LoginUser.class);
        if (loginUser1 != null)
            System.out.println(loginUser1.getToken());
        else
            System.out.println("deserialize ERROR");
        List<LoginUser> loginUserList = new ArrayList<>();
        loginUserList.add(loginUser);
        loginUserList.add(loginUser1);
        JsonSerializer<List<LoginUser>> listJsonSerializer = new JsonSerializer<>();
        String jsonList = listJsonSerializer.serialize(loginUserList, new TypeToken<List<LoginUser>>() {
        });
        System.out.println(jsonStr);
        List<LoginUser> loginUserList1 = new ArrayList<>();
        loginUserList1 = listJsonSerializer.deserialize(jsonList, new TypeToken<List<LoginUser>>() {
        });
        System.out.println("" + loginUserList1.size());
    }

    @Test
    public void testCache(){

    }
}