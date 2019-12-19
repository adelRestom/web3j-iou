package org.web3j.braid.server.rpc

import javax.annotation.Generated

/**
*
* @param user user name
* @param password password
*/
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-19T05:21:14.912Z"
)
data class LoginRequest(
    /* user name */
    val user: kotlin.String,
    /* password */
    val password: kotlin.String
)
