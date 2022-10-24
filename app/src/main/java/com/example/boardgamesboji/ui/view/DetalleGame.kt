package com.example.boardgamesboji.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.boardgamesboji.data.model.adapter.GAMEID_MESSAGE
import com.example.boardgamesboji.databinding.ActivityDetalleGameBinding
import com.example.boardgamesboji.ui.viewmodel.DetalleGameViewModel
import com.squareup.picasso.Picasso

class DetalleGame : AppCompatActivity() {

    lateinit var binding: ActivityDetalleGameBinding

    private val detalleGameViewModel: DetalleGameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameId = intent.getIntExtra(GAMEID_MESSAGE, 0)

        detalleGameViewModel.cargarGame(gameId)

        detalleGameViewModel.game.observe(this, Observer { game->
            with(binding){
                detalleNombre.text = game.nombre
                detallePrecio.text = "Precio: $ ${game.precio.toString()}"
                detallePublisher.text = "by ${game.editor}"
                txtDetalleArtista.text = game.artista
                txtDetalleDesigner.text = game.designer
                txtDetalleEdad.text = game.edad
                txtDetalleTiempoJuego.text  = game.tiempoJuego
                txtDetalleYear.text = game.year.toString()
                txtDetalleOficialLink.text = game.oficialLink
                detallePlayers.text = "Players: ${game.player}"
                detalleYear.text = game.year.toString()
                txtDetallePublisher.text = game.editor
                txtDetalleNombre.text = game.nombre
                txtDetalleDescripcion.text = "Descripcion:  ${game.descripcion} "

                Picasso.get().load(game.imagen).into(detalleImagen)


                btnComprar.setOnClickListener{
                    val txtCorreo = """
                        
                        Hola
                        Quisiera reservar este juego de mesa ${game.nombre}, favor de contactar a este correo o al
                        siguiente número _________
                        Quedo atento.
                        
                        
                    """.trimIndent()

                    val intentMail = Intent(Intent.ACTION_SENDTO).apply {
                        type = "msage/rfc822"
                        data = Uri.parse("mailto:")
                        val para:Array<String> = arrayOf("Info@boji-games.cl")
                        putExtra(Intent.EXTRA_EMAIL, para)
                        putExtra(Intent.EXTRA_SUBJECT, "Quiero Reservar este Juego ${game.nombre}")
                        putExtra(Intent.EXTRA_TEXT, txtCorreo)
                    }
                    startActivity(intentMail)

                    if (intentMail.resolveActivity(packageManager) != null){
                        startActivity(intentMail)
                    }else{
                        Toast.makeText(baseContext, " No se tiene ninguna app de correo Instalada!!!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}