package com.hasc.finder.domain.interactor;

import com.hasc.finder.domain.repository.SongsRepository;

import javax.inject.Inject;

public class UseCaseFactory {

    private SongsRepository repository;

    @Inject
    public UseCaseFactory(SongsRepository repository){
        this.repository = repository;
    }

    public UseCase getSongs(){
        return new GetSongsUseCase(repository);
    }
}
