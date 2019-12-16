package com.hasc.finder.domain;

import com.hasc.finder.utils.TestUtils;

import org.junit.Assert;
import org.junit.Test;

public class SongTest {

    @Test
    public void compareTwoIdenticalSongsReturnsEquals() throws Exception {
        Song songOne = TestUtils.createMainSong();
        Song songTwo = TestUtils.createMainSong();

        Assert.assertEquals(songOne, songTwo);
    }

    @Test
    public void compareTwoDifferentSongsReturnsNotEquals() throws Exception {
        Song songOne = TestUtils.createMainSong();
        Song songTwo = TestUtils.createAltSong();

        Assert.assertNotEquals(songOne, songTwo);
    }
}
