package org.dsa.viewmodel

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel

class DataViewModel(): ViewModel(){


/*    fun downloadMusic(url: String, outputPath: String) {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            response.body?.byteStream()?.use { inputStream ->
                val file = File(outputPath)
                file.outputStream().use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        }
    }*/

/*    val musicFilePath = File(context.getExternalFilesDir(null), "musicfile.mp3")
    downloadMusic("https://example.com/musicfile.mp3", musicFilePath.path)*/

    fun playMusicFromStorage(context: Context, musicFilePath: String) {
        val mediaPlayer = MediaPlayer()

        try {
            mediaPlayer.setDataSource(musicFilePath)
            mediaPlayer.prepare()
            mediaPlayer.start()
            mediaPlayer.pause() // Pauses the music
            mediaPlayer.stop()  // Stops the music

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}