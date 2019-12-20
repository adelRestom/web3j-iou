package org.web3j.braid.server.progress

import javax.annotation.Generated
import org.web3j.corda.model.InvocationError

/**
* pet status in the store
* @param flowClass Java class name
* @param invocationId The invocation-id header as supplied in the flow initiation post request
* @param step The step name as defined by the flow
* @param error
* @param complete Indicates if the progress tracker for this flow invocation-id is completed
*/
@Generated(
    value = ["org.web3j.corda.codegen.CorDappClientGenerator"],
    date = "2019-12-20T02:08:15.118Z"
)
data class ProgressNotification(
    /* Indicates if the progress tracker for this flow invocation-id is completed */
    val complete: kotlin.Boolean,
/* Java class name */
    val flowClass: kotlin.String? = null,
/* The invocation-id header as supplied in the flow initiation post request */
    val invocationId: kotlin.String? = null,
/* The step name as defined by the flow */
    val step: kotlin.String? = null,
    val error: org.web3j.corda.model.InvocationError? = null
)
