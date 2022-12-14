package br.com.vtvinicius.data_remote.model.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("code")
    val code: Int,

    @SerializedName("message")
    val message: String,

    @SerializedName("dados")
    val dados: T?,
)
