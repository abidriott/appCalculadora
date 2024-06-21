package com.example.appmicalculadora

class Operaciones(var num1:Float, var num2: Float) {

    //bonjour

    public fun suma(): Float{
        return this.num1+this.num2

    }
    public fun resta(): Float{
        return this.num1 - this.num2
    }

    public fun multiplica(): Float{
        return num1*num2;

    }
    public fun div(): Float{
        return this.num1/this.num2
    }
}