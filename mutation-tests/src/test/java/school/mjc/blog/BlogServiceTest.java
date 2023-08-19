package school.mjc.blog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {

    @Mock
    private RestService restService;
    @InjectMocks
    private BlogService service;

    @Test
    public void testRatingCalculation() {
        int rating = service.calculateRating(5, 2);

        assertEquals(3, rating);
    }

    @Test
    public void testMinimalRating() {
        int rating = service.calculateRating(1, 12);

        assertEquals(Integer.MIN_VALUE, rating);
        verify(restService, only()).deletePost();
    }

    @Test
    public void testMinimalRatingBoundary() {
        int rating = service.calculateRating(1, 11);

        assertEquals(-10, rating);
    }
}
