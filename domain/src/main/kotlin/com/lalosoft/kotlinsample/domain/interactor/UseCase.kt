package com.lalosoft.kotlinsample.domain.interactor

import com.lalosoft.kotlinsample.domain.executor.PostExecutionThread
import com.lalosoft.kotlinsample.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
abstract class UseCase<T, Params> {

    private val threadExecutor: ThreadExecutor? = null
    private val postExecutionThread: PostExecutionThread? = null
    private val disposables: CompositeDisposable? = null

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    internal abstract fun buildUseCaseObservable(params: Params): Observable<T>?

    /**
     * Executes the current use case.

     * @param observer [DisposableObserver] which will be listening to the observable build
     * * by [.buildUseCaseObservable] ()} method.
     * *
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<T>, params: Params) {
        observer.let {
            val observable = this.buildUseCaseObservable(params)
                    ?.subscribeOn(Schedulers.from(threadExecutor))
                    ?.observeOn(postExecutionThread?.getScheduler())
            addDisposable(observable?.subscribeWith(observer))
        }
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables?.isDisposed()!!) {
            disposables.dispose()
        }
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: DisposableObserver<T>?) {
        disposables?.add(disposable)
    }

}