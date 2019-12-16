package com.hasc.finder.domain.interactor;

import com.hasc.finder.domain.Handler;
import com.hasc.finder.domain.Song;
import com.hasc.finder.domain.repository.SongsRepository;
import com.hasc.finder.utils.TestUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class GetSongsUseCaseTest {

    @Mock
    private SongsRepository repository;

    @Mock
    Handler<List<Song>> handler;

    @Captor
    ArgumentCaptor<Handler<List<Song>>> songListCaptor;

    GetSongsUseCase sut;

    String fakeMediaType = "music";
    String fakeTerm = "jazz";

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        sut = new GetSongsUseCase(repository);
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void execute_InvokesRepository(){
        sut.execute(null, new GetSongsUseCase.Params(fakeMediaType, fakeTerm));

        Mockito.verify(repository).getSongs(ArgumentMatchers.eq(fakeMediaType), ArgumentMatchers.eq(fakeTerm), ArgumentMatchers.any(Handler.class));
    }

    @Test
    public void execute_ReturnsSongList(){
        List<Song> songList = TestUtils.createMainSongList();

        sut.execute(handler, new GetSongsUseCase.Params(fakeMediaType, fakeTerm));
        setSongListAvailable(songList);

        Mockito.verify(handler).handle(ArgumentMatchers.eq(songList));
    }

    private void setSongListAvailable(List<Song> songList){
        Mockito.verify(repository).getSongs(ArgumentMatchers.eq(fakeMediaType), ArgumentMatchers.eq(fakeTerm), songListCaptor.capture());
        songListCaptor.getValue().handle(songList);
    }
}
