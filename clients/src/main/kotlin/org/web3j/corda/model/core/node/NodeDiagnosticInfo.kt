package org.web3j.corda.model.core.node

import javax.annotation.Generated
import org.web3j.corda.model.core.cordapp.CordappInfo

/**
*
* @param version
* @param revision
* @param platformVersion
* @param vendor
* @param cordapps
*/
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-20T02:08:15.118Z"
)
data class NodeDiagnosticInfo(
    val version: kotlin.String,
    val revision: kotlin.String,
    val platformVersion: kotlin.Int,
    val vendor: kotlin.String,
    val cordapps: kotlin.collections.List<org.web3j.corda.model.core.cordapp.CordappInfo>
)
