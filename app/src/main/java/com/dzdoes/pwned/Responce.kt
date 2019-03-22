package com.dzdoes.pwned

data class Responce (
    val breaches:List<Breach>
)



data class Breach(
    val Name:String,
    val Title:String,
    val Domain:String,
    val BreachDate:String,
    val AddedDate:String,
    val ModifiedDate:String,
    val PwnCount:Int,
    val Description:String,
    val DataClasses:List<String>,
    val IsVerified:Boolean,
    val IsSensitive:Boolean,
    val IsRetired:Boolean,
    val IsSpamList:Boolean
)