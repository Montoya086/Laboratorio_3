/*
 * Universidad del Valle de Guatemala
 * Programación de plataformas móviles
 * Ultima modificación: 17/07/2022
 * Andrés Estuardo Montoya - 21552
 */ 
import org.junit.Test
import kotlin.test.*

data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
/*
 * Función main
 */
fun main() {
    val result = processList(listOf(25, "Hola", null, false))
    println(result)
}
/*
 * Función processList
 * Funcion en la cual se ingresa una lista de datos y devuelve otra lista con las caracteristicas de los datos ingresados
 */
fun processList(inputList: List<Any?>?): List<ItemData>? {
    var outputList: MutableList<ItemData> = mutableListOf<ItemData>()
	if (inputList != null){
        var cont: Int =0
        for(item: Any? in inputList){
            if (item != null){
            var tipo: String?
            var info: String?
            when (item) {
                is String ->{ 
                    tipo="cadena"
                    info= ("L"+item.length)
                }
                is Int -> {
                    tipo="entero"
                    if(item%10==0){
                        info = "M10"
                    }else if(item%5==0){
                        info = "M5"
                    }else if (item%2==0){
                        info = "M2"
                    }else{
                        info = null
                    }
                }
                is Boolean -> {
                    tipo="Booleano"
                    if (item){
                        info="Verdadero"
                    }else{
                        info = "Falso"
                    }
                }
                else -> {
                    tipo=null
                    info=null
                }
            }
            
            val newItem = ItemData(
                originalPos = cont,
                originalValue = item,
                type = tipo,
                info = info
            )
            
            outputList.add(newItem)
            }
            cont++
        }
    }else{
        return null
    }
            return outputList
}