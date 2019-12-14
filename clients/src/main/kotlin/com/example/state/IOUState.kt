package com.example.state

import javax.annotation.Generated
import org.web3j.corda.model.core.contracts.UniqueIdentifier
import org.web3j.corda.model.core.identity.AbstractParty
import org.web3j.corda.model.core.identity.Party

/**
*
* @param value
* @param lender
* @param borrower
* @param linearId
* @param participants
*/
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-14T17:50:00.464Z"
)
data class IOUState(
    val value: kotlin.Int,
    val participants: kotlin.collections.List<org.web3j.corda.model.core.identity.AbstractParty>,
    val lender: org.web3j.corda.model.core.identity.Party? = null,
    val borrower: org.web3j.corda.model.core.identity.Party? = null,
    val linearId: org.web3j.corda.model.core.contracts.UniqueIdentifier? = null
)
