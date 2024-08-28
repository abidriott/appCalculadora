package com.example.appmicalculadora

import kotlin.time.measureTime

class Operaciones (var num1:Float, var num2: Float) {

    public fun sumar() : Float{
        return this.num1 + this.num2
    }

    public fun restar() : Float{
        return this.num1 - this.num2
    }

    public fun multiplicar() : Float{
        return this.num1 * this.num2
    }

    public  fun dividir() : Float{
        return this.num1 / this.num2
    }
}