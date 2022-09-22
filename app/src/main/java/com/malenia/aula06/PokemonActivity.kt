package com.malenia.aula06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.malenia.aula06.databinding.ActivityPokemonBinding


class PokemonActivity : AppCompatActivity() {
    lateinit var binding: ActivityPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pokemons = arrayListOf("Escolha um Pokémon","Bulbassauro", "Charmander","Squirtle")

        //vamos usar o adapter para converter o array em um Spinner  ( ele faz está conversão)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pokemons )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter

        //codigo referencia para tratamento de spinner
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(adapter: AdapterView<*>?, spinner: View?, posicao: Int, id: Long) {
           when(posicao){
               1 -> {
                   val imagemBulbassauro = getDrawable(R.drawable.bulbassauro)
                    binding.imageView2.setImageDrawable(imagemBulbassauro)
               }
               2-> {
                   val imagemCharmander = getDrawable(R.drawable.charmander)
                   binding.imageView2.setImageDrawable(imagemCharmander)
               }

               3-> {
                   val imagemSquirtle = getDrawable(R.drawable.squirtle)
                   binding.imageView2.setImageDrawable(imagemSquirtle)
               }
               else -> { binding.imageView2.setImageDrawable(null)}
           }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

       binding.button.setOnClickListener {
           when(binding.spinner.selectedItemPosition){

               1->{  val titulo = "Bulbassauro"
                        val msg ="""Categoria :  Seed
                                    |Habilidade: Overgrow
                                    |Type: Grass / Poison
                        """.trimMargin()
                   alert(titulo, msg,this)
               }
               2->{  val titulo = "Charmander"
                        val msg ="""Categoria :  Lizard
                                    |Habilidade: Blaze
                                    |Type: Fire
                        """.trimMargin()
                   alert(titulo, msg,this)
               }
               3->{  val titulo = "Squirtle"
                        val msg ="""Categoria :  Tiny Turtle
                                    |Habilidade: Torrent
                                    |Type: Water
                        """.trimMargin()
                   alert(titulo, msg,this)
               }


           }

       }


    }
}