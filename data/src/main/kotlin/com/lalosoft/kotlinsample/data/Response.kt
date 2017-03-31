package com.lalosoft.kotlinsample.data

/**
 * Created by gonzalo on 3/29/17
 */

data class Response<out T>(val type: String, val value: T)
