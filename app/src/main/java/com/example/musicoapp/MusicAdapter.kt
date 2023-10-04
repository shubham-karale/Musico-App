package com.example.musicoapp

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MusicAdapter(val context:Activity,val dataList:List<Data>):RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    class MusicViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val musicTitle = itemView.findViewById<TextView>(R.id.musicTitle)
        val musicImage  = itemView.findViewById<ImageView>(R.id.musicTrackImage)
        val playBtn = itemView.findViewById<ImageView>(R.id.playBtn)
        val pauseBtn = itemView.findViewById<ImageView>(R.id.pauseBtn)
        val nextTrackBtn = itemView.findViewById<ImageView>(R.id.nextBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return MusicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentTrack = dataList[position]
        var mediaPlayer = MediaPlayer.create(context,currentTrack.preview.toUri())
        holder.musicTitle.text = currentTrack.title
        Picasso.get().load(currentTrack.album.cover).into(holder.musicImage)

        holder.playBtn.setOnClickListener {
            mediaPlayer.start()
        }

        holder.pauseBtn.setOnClickListener {
            mediaPlayer.pause()
        }

        holder.nextTrackBtn.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context,dataList[position+1].preview.toUri())
            mediaPlayer.start()
        }

    }
}