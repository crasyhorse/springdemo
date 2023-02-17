package spring.bussines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import spring.business.DataService;
import spring.business.SomeBusinessImpl;

public class SomeBussinesImplTest {

    @Test
    public void greatestReturnsGreatestValueOfThree() {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.all()).thenReturn(new int[] { 24, 6, 15 });

        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = someBusinessImpl.greatest();

        assertEquals(24, result);
    }
}
