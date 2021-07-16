package com.jacob.curso.presentation.catalog.adapters

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jacob.curso.R
import com.jacob.curso.presentation.catalog.model.Color

class ColorAdapter(
    private val colorList : List<Color>
):RecyclerView.Adapter<ColorAdapter.ColorViewHolder>(){

    /** Crea la vista del item que mostraremos en el recyclerView */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_color,parent,false)
        return ColorViewHolder(view)
    }

    /** Unión entre los datos de la vista y los componentes a mostrar */
    /** Ira iterando con cada una de las posiciones (Como un cilo) */
    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val color = colorList[position]
        holder.nameColor.text = color.name
        /** Si no es nulo nuestro item, entra a la siguiente acción*/
        color.hex?.let {
            holder.colorImage.setColorFilter(ContextCompat.getColor(holder.view.context,it))
        }
    }

    /** Funcion que nos regresa un Entero (Tamaño de nuestra lista) */
    override fun getItemCount() = colorList.size

    /** Creamos instancias de nustros componentes del item a mostrar */
    class ColorViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val nameColor = view.findViewById<TextView>(R.id.name)
        val colorImage = view.findViewById<AppCompatImageView>(R.id.colorImageView)
        //val nameColor : TextView = view.findViewById(R.id.name)
    }
}