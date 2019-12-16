package com.hasc.finder.domain.interactor;

import com.hasc.finder.domain.repository.SongsRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UseCaseFactoryTest {

    @Mock
    private SongsRepository repository;

    UseCaseFactory sut;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        sut = new UseCaseFactory(repository);
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }

    @Test
    public void getSongs_CreatesCorrectInstance(){
        UseCase useCase = sut.getSongs();

        Assert.assertTrue(useCase instanceof GetSongsUseCase);
    }

}
