package school.mjc.blog;

public class BlogService {

    public static final int MINIMAL_RATING = -10;

    private final RestService restService;

    public BlogService(RestService restService) {
        this.restService = restService;
    }

    public int calculateRating(int likes, int dislikes) {
        int i = likes - dislikes;
        if (i < MINIMAL_RATING) {
            restService.deletePost();
            return Integer.MIN_VALUE;
        }
        return i;
    }
}
