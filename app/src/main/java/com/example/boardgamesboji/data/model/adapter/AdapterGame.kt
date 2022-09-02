package com.example.boardgamesboji.data.model.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boardgamesboji.ui.view.DetalleGame
import com.example.boardgamesboji.R
import com.example.boardgamesboji.data.model.retrofit.Game
import com.squareup.picasso.Picasso

const val GAMEID_MESSAGE = "com.example.boardgamesboji.GAMEID"

class AdapterGame(private val datos: List<Game>): RecyclerView.Adapter<AdapterGame.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

        val txtGameName: TextView
        val imageGame: ImageView
        val txtPublisher: TextView
        val txtPlayer: TextView
        val txtPrecio: TextView

        init {

            txtGameName = view.findViewById(R.id.txtGameName)
            imageGame = view.findViewById(R.id.imagenGame)
            txtPublisher = view.findViewById(R.id.txtPublisher)
            txtPlayer = view.findViewById(R.id.txtPlayer)
            txtPrecio = view.findViewById(R.id.txtPrecio)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = datos.get(position)

        holder.txtGameName.text = game.nombre
        holder.txtPublisher.text = "By ${game.editor}"
        holder.txtPrecio.text = "Precio: ${game.precio.toString()}"
        holder.txtPlayer.text = "Players: ${game.player}"

        Picasso.get().load(game.imagen).into(holder.imageGame)

        // evento click de la tarjeta
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetalleGame::class.java).apply {
                putExtra(GAMEID_MESSAGE, game.id)
            }
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return datos.size
    }
}