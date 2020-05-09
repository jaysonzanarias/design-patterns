package structural_patterns.proxy;

import structural_patterns.proxy.downloader.YoutubeDownloader;
import structural_patterns.proxy.proxy.YoutubeCacheProxy;
import structural_patterns.proxy.some_cool_media_library.ThirdPartyYoutubeClass;

/**
 * https://refactoring.guru/design-patterns/proxy/java/example
 * Output:
 * Connecting to http://www.youtube.com... Connected!
 * Downloading populars... Done!
 *
 * -------------------------------
 * Most popular videos on Youtube (imagine fancy HTML)
 * ID: sadgahasgdas / Title: Catzzzz.avi
 * ID: asdfas3ffasd / Title: Dancing video.mpq
 * ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
 * ID: mkafksangasj / Title: Dog play with ball.mp4
 * ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: catzzzzzzzzz
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Connecting to http://www.youtube.com... Connected!
 * Downloading populars... Done!
 *
 * -------------------------------
 * Most popular videos on Youtube (imagine fancy HTML)
 * ID: sadgahasgdas / Title: Catzzzz.avi
 * ID: asdfas3ffasd / Title: Dancing video.mpq
 * ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
 * ID: mkafksangasj / Title: Dog play with ball.mp4
 * ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/dancesvideoo... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: dancesvideoo
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: catzzzzzzzzz
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/someothervid... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: someothervid
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Time elapsed: 9310ms
 * Connecting to http://www.youtube.com... Connected!
 * Downloading populars... Done!
 *
 * -------------------------------
 * Most popular videos on Youtube (imagine fancy HTML)
 * ID: sadgahasgdas / Title: Catzzzz.avi
 * ID: asdfas3ffasd / Title: Dancing video.mpq
 * ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
 * ID: mkafksangasj / Title: Dog play with ball.mp4
 * ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/catzzzzzzzzz... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: catzzzzzzzzz
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Retrieved list from cache.
 *
 * -------------------------------
 * Most popular videos on Youtube (imagine fancy HTML)
 * ID: sadgahasgdas / Title: Catzzzz.avi
 * ID: asdfas3ffasd / Title: Dancing video.mpq
 * ID: 3sdfgsd1j333 / Title: Programing lesson#1.avi
 * ID: mkafksangasj / Title: Dog play with ball.mp4
 * ID: dlsdk5jfslaf / Title: Barcelona vs RealM.mov
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/dancesvideoo... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: dancesvideoo
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Retrieved video 'catzzzzzzzzz' from cache.
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: catzzzzzzzzz
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Connecting to http://www.youtube.com/someothervid... Connected!
 * Downloading video... Done!
 *
 * -------------------------------
 * Video page (imagine fancy HTML)
 * ID: someothervid
 * Title: Some video title
 * Video: Random video.
 * -------------------------------
 *
 * Time elapsed: 6229ms
 * Time saved by caching proxy: 3081ms
 * Process finished with exit code 0
 */
public class Demo {
    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

    }

    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
