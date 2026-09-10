package com.example.tvapp.core.commons

import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import retrofit2.HttpException

sealed class AppException(
    override val message: String,
    override val cause: Throwable? = null
) : Exception(message, cause) {

    // ---- Network Errors ----
    data class NoInternetException(
        val msg: String = "Tidak ada koneksi internet. Periksa jaringan Anda."
    ) : AppException(msg)

    data class TimeoutException(
        val msg: String = "Koneksi timeout. Silakan coba lagi."
    ) : AppException(msg)

    data class ServerException(
        val code: Int,
        val msg: String = "Terjadi kesalahan pada server ($code)."
    ) : AppException(msg)

    data class UnauthorizedException(
        val msg: String = "Sesi Anda telah berakhir. Silakan login kembali."
    ) : AppException(msg)

    data class ForbiddenException(
        val msg: String = "Anda tidak memiliki akses untuk melakukan ini."
    ) : AppException(msg)

    data class NotFoundException(
        val msg: String = "Data yang Anda cari tidak ditemukan."
    ) : AppException(msg)

    // ---- Data / Parsing Errors ----
    data class ParsingException(
        val msg: String = "Gagal memproses data dari server."
    ) : AppException(msg)

    data class EmptyDataException(
        val msg: String = "Data tidak tersedia."
    ) : AppException(msg)

    // ---- Validation / Business Logic Errors ----
    data class ValidationException(
        val field: String? = null,
        val msg: String
    ) : AppException(msg)

    // ---- Database / Local Errors ----
    data class DatabaseException(
        val msg: String = "Terjadi kesalahan pada penyimpanan lokal."
    ) : AppException(msg)

    // ---- Fallback ----
    data class UnknownException(
        val msg: String = "Terjadi kesalahan yang tidak diketahui."
    ) : AppException(msg)

    companion object {

        fun from(throwable: Throwable): AppException {
            return when (throwable) {
                is AppException -> throwable

                is UnknownHostException,
                is ConnectException -> NoInternetException()

                is SocketTimeoutException -> TimeoutException()

                is HttpException -> mapHttpException(throwable)

                is IOException -> ParsingException(
                    msg = "Gagal membaca data: ${throwable.localizedMessage ?: "IO error"}"
                )

                else -> UnknownException(
                    msg = throwable.localizedMessage ?: "Terjadi kesalahan tidak terduga."
                )
            }
        }

        private fun mapHttpException(e: HttpException): AppException {
            return when (e.code()) {
                401 -> UnauthorizedException()
                403 -> ForbiddenException()
                404 -> NotFoundException()
                in 500..599 -> ServerException(e.code())
                else -> ServerException(e.code(), "Terjadi kesalahan (${e.code()}).")
            }
        }
    }
}