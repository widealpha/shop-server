package cn.widealpha.shop.util

import org.springframework.lang.Nullable
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.lang.StringBuilder
import java.util.*

object FileUtil {
    private const val HOST = "http://121.196.101.7/"
    fun saveImage(multipartFile: MultipartFile?, @Nullable use: String?): String? {
        if (multipartFile == null) {
            return null
        }
        val fileName = generatorFilename(null, "jpg")
        var path = "/home/share/"
        if (use != null) {
            path += "$use/"
        }
        val p = File(path)
        if (!p.exists()) {
            p.mkdirs()
        }
        val file = File(path + fileName)
        file.setReadable(true, false)
        try {
            FileOutputStream(file).use { fos ->
                file.createNewFile()
                fos.write(multipartFile.bytes)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return if (use != null) "$HOST$use/$fileName" else HOST + fileName
    }

    fun saveMusic(multipartFile: MultipartFile?, @Nullable use: String?): String? {
        if (multipartFile == null) {
            return null
        }
        val filename: String = if (multipartFile.originalFilename != null) {
            val names = multipartFile.originalFilename!!.split("\\.".toRegex()).toTypedArray()
            generatorFilename(null, names[names.size - 1])
        } else {
            generatorFilename(null, "mp3")
        }
        var path = "/home/share/"
        if (use != null && use.trim { it <= ' ' }.isNotEmpty()) {
            path += "$use/"
        }
        val p = File(path)
        if (!p.exists()) {
            p.mkdirs()
        }
        val file = File(path + filename)
        file.setReadable(true, false)
        try {
            FileOutputStream(file).use { fos ->
                file.createNewFile()
                fos.write(multipartFile.bytes)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return if (use != null) "$HOST$use/$filename" else HOST + filename
    }

    private fun generatorFilename(@Nullable prefix: String?, @Nullable suffix: String?): String {
        val date = Date()
        val builder = StringBuilder()
        if (prefix != null) {
            builder.append(prefix).append('-')
        }
        builder.append(date.time)
        if (suffix != null) {
            builder.append('.').append(suffix)
        }
        return builder.toString()
    }
}