data class ItemData(var originalPos: Int,var originalValue: Any,var type: String? = null,var info: String? = null)
fun main() {val result = processList(listOf(25, "Hola", null, false))
    println(result)}
fun processList(inputList: List<Any?>?): List<ItemData>? { 
    val outputList: MutableList<ItemData> = mutableListOf<ItemData>()
	if (inputList != null){
        var cont: Int =0
        for(item: Any? in inputList){
            if (item != null) outputList.add(when (item) {
                    is String -> ItemData(cont, item, "cadena", "L"+item.length)
                    is Int -> ItemData(cont, item, "entero", if(item%10==0) "M10" else if(item%5==0) "M5" else if(item%2==0) "M2" else null)
                    is Boolean -> ItemData(cont, item, "Booleano", if (item) "Verdadero" else "Falso")
                    else -> ItemData(cont, item, null, null)
            })
            cont++
        }
    }else return null
    return outputList}