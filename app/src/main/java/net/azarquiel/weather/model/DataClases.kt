package net.azarquiel.weather.model

import com.google.gson.annotations.SerializedName

//Result guarda todos los datos del json
//@SerializedName para poder cambiarle de nombre
//Creamos un dataclass para cada uno de los objetos que aparezcan[], list{}
//las etiquetas no se pueden cambiar, lo que va entre parentesis
data class Result(
    @SerializedName("list")
    var dias:List<Dia>
)
data class Dia(
    @SerializedName("main")
    var temperaturas:Main,
    @SerializedName("weather")
    var pronoico:List<Weather>,
    var pop:Float,
    var dt_txt:String
)
data class Main(var tem_min:Float, var tem_max:Float)

data class Weather(var description:String, var icon:String)
