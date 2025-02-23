val tasks = mutableListOf<String>()
fun main(){
    while(true){
        menu()
    }
}

fun menu(){
    println("Yeshua's Task Manager")
    println("1. Add a task.")
    println("2. Delete a task.")
    println("3. Mark a task as done.")
    println("4. Exit")
    println("Choose a number: ")

    when(readlnOrNull()?.toIntOrNull()) {
        1 -> tasks.addAll(listmaking())
        2 -> deletetask(tasks)
        3 -> markedDone(tasks)
        4 -> {
            println("Closing program")
            return
        }
        else -> println("Invalid Try again")
    }
}

fun listmaking(): MutableList<String> {
    val list = mutableListOf<String>()
    var count = 0

    println("How many tasks do you want to put in your task manager: ") //asking how many tasks do you want in your list
    val taskNum = readlnOrNull()?.toIntOrNull() ?: return list

    println("Please enter your task(s): ")
    while (count < taskNum){ //while loop for making sure the program pauses/stops after the max has been reached
        val userInput = readln() ?: ""
        list.add(userInput)
        count++
    }
    println("Task(s) added successfully")
    return list
}

//function for deleting the tasks
fun deletetask(list: MutableList<String>){
    if (list.isEmpty()){
        println("No tasks to delete")
        return
    }
    println("Your tasks: ")
    list.forEachIndexed{index, task -> println("$index: $task") }
    println("Do you want to delete some tasks? (Y/N)")
    val answer = readlnOrNull()

    if (answer?.uppercase() == "Y"){
        println("Which task number do you want to delete?")
        val numDel = readlnOrNull()?.toIntOrNull()
        println("Okay.. deleting task $numDel")
        if (numDel != null && numDel in list.indices) {
            list.removeAt(numDel)
        } else {
            println("Invalid task number.")
        }
    }
    println("Updated task list: ")
    for (task in list){
        println(task)
    }

}

//function for marking the task as finished
//my plan is to have it not ask until the user has inputted a task

fun markedDone(list: MutableList<String>){
    if(list.isEmpty()){
        println("Nothing to mark done since there are nothing in the list.")
    }else{
        print(list.indices)
    }
}