package kz.onelab.onelabsamples.lecture1;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {

    @Mock
    private MyService myService;

    @Test
    public void text_Execute() {
        assertEquals(myService.getValue(), "1231");
    }

}