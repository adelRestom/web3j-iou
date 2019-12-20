package org.web3j.corda.model.core.cordapp

import javax.annotation.Generated

/**
*
* @param type
* @param name
* @param shortName
* @param minimumPlatformVersion
* @param targetPlatformVersion
* @param version
* @param vendor
* @param licence
* @param jarHash Base 58 Encoded Secure Hash
*/
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-20T02:08:15.118Z"
)
data class CordappInfo(
    val type: kotlin.String,
    val name: kotlin.String,
    val shortName: kotlin.String,
    val minimumPlatformVersion: kotlin.Int,
    val targetPlatformVersion: kotlin.Int,
    val version: kotlin.String,
    val vendor: kotlin.String,
    val licence: kotlin.String,
    /* Base 58 Encoded Secure Hash */
    val jarHash: kotlin.String
)
