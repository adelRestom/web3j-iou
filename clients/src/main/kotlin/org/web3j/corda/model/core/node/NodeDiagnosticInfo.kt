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
    date = "2019-12-19T05:21:14.912Z"
)
data class NodeDiagnosticInfo(
    val version: kotlin.String,
    val revision: kotlin.String,
    val platformVersion: kotlin.Int,
    val vendor: kotlin.String,
    val cordapps: kotlin.collections.List<org.web3j.corda.model.core.cordapp.CordappInfo>
)
