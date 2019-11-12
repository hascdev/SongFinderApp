package com.hasc.finder.domain.interactor;

import com.hasc.finder.domain.Handler;

public interface UseCase<T, P> {

    void execute(Handler<T> handler, P params);

}