package com.aierx.boot.service.rs;

import com.aierx.boot.BaseTest;
import com.aierx.boot.dao.UserDao;
import com.aierx.boot.model.po.UserPO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


class OtherServiceTest extends BaseTest {
    @InjectMocks
    private OtherService otherService;

    @Mock
    private UserDao userDao;

    @Mock
    private UserService userService;

    /**
     * Method under test: {@link OtherService#otherFun(UserPO)}
     */
    @Test
    void testOtherFun() throws Exception {
        when(this.userDao.updateUserById((UserPO) any())).thenReturn(123);
        UserPO userPO = new UserPO("janedoe", "iloveyou", "42", "User Age");

        this.otherService.otherFun(userPO);
        verify(this.userDao).updateUserById((UserPO) any());
        assertEquals("other", userPO.getUserName());
        assertEquals("100", userPO.getUserId());
    }

    /**
     * Method under test: {@link OtherService#otherFun(UserPO)}
     */
    @Test
    void testOtherFun2() throws Exception {
        when(this.userDao.updateUserById((UserPO) any())).thenReturn(123);
        UserPO userPO = new UserPO("janedoe", "iloveyou", "10086", "User Age");

        this.otherService.otherFun(userPO);
        assertEquals(0, userPO.getId());
        assertEquals(0, userPO.getVersion());
        assertEquals("iloveyou", userPO.getUserPassword());
        assertEquals("janedoe", userPO.getUserName());
        assertEquals("10086", userPO.getUserId());
        assertEquals("User Age", userPO.getUserAge());
    }

    /**
     * Method under test: {@link OtherService#otherFun(UserPO)}
     */
    @Test
    void testOtherFun3() throws Exception {
        when(this.userDao.updateUserById((UserPO) any())).thenReturn(123);
        UserPO userPO = new UserPO("janedoe", "iloveyou", "42", "30");

        this.otherService.otherFun(userPO);
        verify(this.userDao).updateUserById((UserPO) any());
        assertEquals("other", userPO.getUserName());
        assertEquals("111", userPO.getUserId());
    }

    /**
     * Method under test: {@link OtherService#otherFun(UserPO)}
     */
    @Test
    void testOtherFun4() throws Exception {
        when(this.userDao.updateUserById((UserPO) any())).thenReturn(123);
        assertThrows(Exception.class, () -> this.otherService.otherFun(new UserPO()));
    }

    /**
     * Method under test: {@link OtherService#otherFun(UserPO)}
     */
    @Test
    void testOtherFun5() throws Exception {
        when(this.userDao.updateUserById((UserPO) any())).thenReturn(123);
        assertThrows(Exception.class, () -> this.otherService.otherFun(null));
    }

    /**
     * Method under test: {@link OtherService#otherFun(UserPO)}
     */
    @Test
    void testOtherFun6() throws Exception {
        when(this.userDao.updateUserById((UserPO) any())).thenReturn(123);

        UserPO userPO = new UserPO();
        userPO.setUserId("42");
        assertThrows(Exception.class, () -> this.otherService.otherFun(userPO));
    }

    /**
     * Method under test: {@link OtherService#findUser()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindUser() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
        //       at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //       at java.util.ArrayList.get(ArrayList.java:435)
        //       at com.aierx.boot.service.rs.OtherService.findUser(OtherService.java:48)
        //   In order to prevent findUser()
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findUser().
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.userService.getUser((String) any())).thenReturn(new ArrayList<>());
        this.otherService.findUser();
    }

    /**
     * Method under test: {@link OtherService#findUser()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindUser2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
        //       at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //       at java.util.ArrayList.get(ArrayList.java:435)
        //       at com.aierx.boot.service.rs.OtherService.findUser(OtherService.java:48)
        //   In order to prevent findUser()
        //   from throwing IndexOutOfBoundsException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findUser().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<UserPO> userPOList = new ArrayList<>();
        userPOList.add(new UserPO("janedoe", "iloveyou", "42", "1"));
        when(this.userService.getUser((String) any())).thenReturn(userPOList);
        this.otherService.findUser();
    }

    /**
     * Method under test: {@link OtherService#findUser()}
     */
    @Test
    void testFindUser3() {
        ArrayList<UserPO> userPOList = new ArrayList<>();
        userPOList.add(new UserPO("janedoe", "iloveyou", "42", "1"));
        userPOList.add(new UserPO("janedoe", "iloveyou", "42", "1"));
        when(this.userService.getUser((String) any())).thenReturn(userPOList);
        this.otherService.findUser();
        verify(this.userService).getUser((String) any());
    }

    /**
     * Method under test: {@link OtherService#findUser()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindUser4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.aierx.boot.service.rs.OtherService.findUser(OtherService.java:46)
        //   In order to prevent findUser()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findUser().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<UserPO> userPOList = new ArrayList<>();
        userPOList.add(null);
        when(this.userService.getUser((String) any())).thenReturn(userPOList);
        this.otherService.findUser();
    }

    /**
     * Method under test: {@link OtherService#findUser()}
     */
    @Test
    void testFindUser5() {
        ArrayList<UserPO> userPOList = new ArrayList<>();
        userPOList.add(new UserPO("janedoe", "iloveyou", "42", "1"));
        userPOList.add(new UserPO("janedoe", "iloveyou", "2", "1"));
        when(this.userService.getUser((String) any())).thenReturn(userPOList);
        this.otherService.findUser();
        verify(this.userService).getUser((String) any());
    }

    /**
     * Method under test: {@link OtherService#findUser()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindUser6() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.aierx.boot.service.rs.OtherService.findUser(OtherService.java:48)
        //   In order to prevent findUser()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   findUser().
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<UserPO> userPOList = new ArrayList<>();
        userPOList.add(new UserPO("janedoe", "iloveyou", "42", "1"));
        userPOList.add(new UserPO());
        when(this.userService.getUser((String) any())).thenReturn(userPOList);
        this.otherService.findUser();
    }
}

