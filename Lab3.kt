data class ItemData(var originalPos: Int,var originalValue: Any,var type: String? = null,var info: String? = null)
fun main() {val result = processList(listOf(25, "Hola", null, false))
    println(result)}
fun processList(inputList: List<Any?>?): List<ItemData>? { //function that classify items on a list
    val outputList: MutableList<ItemData> = mutableListOf<ItemData>()
	if (inputList != null){ //if it's null, avoids it
        var cont: Int =0 //position counter
        for(item: Any? in inputList){//walk thru the array
            if (item != null) outputList.add(when (item) {//evaluate the type
                    is String -> ItemData(cont, item, "cadena", "L"+item.length)//is string
                    is Int -> ItemData(cont, item, "entero", if(item%10==0) "M10" else if(item%5==0) "M5" else if(item%2==0) "M2" else null) //is integer
                    is Boolean -> ItemData(cont, item, "Booleano", if (item) "Verdadero" else "Falso") //is boolean
                    else -> ItemData(cont, item, null, null) // is another type
            })
            cont++//add 1 to position counter
        }
    }else return null
    return outputList}