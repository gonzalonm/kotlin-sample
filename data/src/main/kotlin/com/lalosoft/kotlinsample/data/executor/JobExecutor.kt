package com.lalosoft.kotlinsample.data.executor

import com.lalosoft.kotlinsample.domain.executor.ThreadExecutor
import javax.inject.Inject
import javax.inject.Singleton
import java.util.concurrent.*


/**
 * Decorated {@link java.util.concurrent.ThreadPoolExecutor}
 */
@Singleton
class JobExecutor : ThreadExecutor {

    var threadPoolExecutor: ThreadPoolExecutor? = null

    @Inject
    constructor() {
        this.threadPoolExecutor = ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS,
                LinkedBlockingQueue(), JobThreadFactory())
    }

    override fun execute(command: Runnable?) {
        threadPoolExecutor?.execute(command)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "android_" + counter++)
        }
    }
}