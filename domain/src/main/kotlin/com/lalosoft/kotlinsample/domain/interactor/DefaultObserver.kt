package com.lalosoft.kotlinsample.domain.interactor

import io.reactivex.observers.DisposableObserver

/**
 * Default {@link DisposableObserver} base class to be used whenever you want default error handling.
 */
class DefaultObserver<T> : DisposableObserver<T>() {

    override fun onNext(value: T) {
        // no-op by default.
    }

    override fun onComplete() {
        // no-op by default.
    }

    override fun onError(e: Throwable?) {
        // no-op by default.
    }
}