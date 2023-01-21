package com.example.s25662Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankServiceTest {

    @Mock
    private UserStorage userStorage;

    @InjectMocks
    private BankService bankService;



    @Test
    void shouldNotTakeMoney(){
        when(userStorage.getUserList()).thenReturn(new ArrayList<>());
        TransferInfo transferInfo = bankService.transfer(123456, 10.00f);
        assertThat(transferInfo.getStatus()).isEqualTo("DECLINED");
    }

    @Test
    void shouldTakeMoney(){
        List<User> userList = new ArrayList<>();
        userList.add(new User(987654, 123.45f));

        when(userStorage.getUserList()).thenReturn(userList);
        TransferInfo transferInfo = bankService.transfer(987654, 10.00f);
        assertThat(transferInfo.getStatus()).isEqualTo("ACCEPTED");
    }


}
