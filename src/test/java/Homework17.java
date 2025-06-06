import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() {
        String expectedSongAddedMsg = "Added 1 song into \"Second User Playlist.\"";

        // Navigate to koel app
        navigateUrl();

        // Log in with valid credentials
        provideEmail("kelly.wade@testpro.io");
        providePassword("P!990109189300ok");
        clickSubmit();
        // Search for a song
        searchSong("Lament");
        // Click 'View All' button to display search results
        clickViewAllBtn();
        // Click the first song in the search results
        selectFirstSong();
        // Click the 'ADD TO...' button
        clickAddToBtn();
        // Choose the playlist to add selected song to
        selectPlaylist();
        //Assertion
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMsg);
    }
}

