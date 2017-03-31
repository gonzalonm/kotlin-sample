package com.lalosoft.kotlinsample.data.net

import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.Callable
import java.io.IOException
import java.util.concurrent.TimeUnit


/**
 * Api Connection class used to retrieve data from the cloud.
 */
class ApiConnection : Callable<String> {

    private val CONTENT_TYPE_LABEL = "Content-Type"
    private val CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8"

    private var url: URL? = null
    private var response: String? = null

    @Throws(MalformedURLException::class)
    constructor (urlString: String) {
        this.url = URL(urlString)
    }

    @Throws(MalformedURLException::class)
    fun createGET(urlString: String): ApiConnection {
        return ApiConnection(urlString)
    }

    fun requestSyncCall(): String? {
        connectToApi()
        return this.response
    }

    private fun connectToApi() {
        val okHttpClient = createClient()
        val request = Request.Builder()
                .url(this.url)
                .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
                .get()
                .build()

        try {
            this.response = okHttpClient.newCall(request).execute().body().string()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun createClient(): OkHttpClient {
        val okHttpClient = OkHttpClient()
        okHttpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS)
        okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS)

        return okHttpClient
    }

    override fun call(): String? {
        return requestSyncCall()
    }
}