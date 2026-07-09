package org.example;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        System.out.println("Result from mock API: " + result);

        assertEquals("Mock Data", result);
    }
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
        System.out.println("Verified that getData() was called on mockApi.");
    }
}