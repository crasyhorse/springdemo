package spring.bussines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import spring.business.DataService;
import spring.business.SomeBusinessImpl;

@ExtendWith(MockitoExtension.class)
public class SomeBussinesImplAnnotationTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusinessImpl;

    @Test
    public void greatestReturnsGreatestValueOfThree() {
        when(dataServiceMock.all()).thenReturn(new int[] {24, 6, 15});
        int result = someBusinessImpl.greatest();

        assertEquals(24, result);
    }

    @Test
    public void greatestReturnsGreatestValueOfNone() {

        when(dataServiceMock.all()).thenReturn(new int[]{});
        int result = someBusinessImpl.greatest();

        assertEquals(Integer.MIN_VALUE, result);
    }
}
