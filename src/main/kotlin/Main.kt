import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private fun log(msg:String) = println("[${Thread.currentThread().name}] $msg")  //This tells us which thread we are printing the message from(can help during debugging)

fun main(){
    networkRequest()
}

private fun networkRequest(){

    GlobalScope.launch {                                   // Used to launch a new coroutine in the background.
        log("Making network request...")

        for (i in 1..3){                             // For-Loop which will simulate problem thinking
            delay(1000)                           // Delay is similar to the Sleep function except it suspends instead of blocking
            println("First: $i")
        }
        log("First network request made!")
    }
                                                            //Just to show that we can actually launch two process at the same time
    GlobalScope.launch {
        delay(500)
        log("Making second network request...")

        for (i in 1..3){
            delay(1000)
            println("Second: $i")
        }
        log("Second network request made!")
    }

    Thread.sleep(4000)                         //We need to stop the program from actually finishing with the exit code because once it reaches the exit code the entire program will terminate & the coroutines will stop

    log("Done")

}