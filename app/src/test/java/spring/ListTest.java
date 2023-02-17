package spring;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;

public class ListTest {

    @Test
    public void testSizeOneReturn() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);

        assertEquals(10, listMock.size());
    }

    @Test
    public void testSizeMultipleRetruns() {
        List listMock = mock(List.class);
        when(listMock.size())
                .thenReturn(10)
                .thenReturn(20);

        assertEquals(10, listMock.size());
        assertEquals(20, listMock.size());
    }

    @Test
    public void testGetIndexAtZero() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("It's a String.");

        assertEquals("It's a String.", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void testGetWithAnyIndex() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("It's a String.");

        assertEquals("It's a String.", listMock.get(0));
        assertEquals("It's a String.", listMock.get(1));
    }
}
